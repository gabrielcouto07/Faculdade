import datetime as dt
from typing import Dict, Iterable, List, Optional

import requests

CoinData = Dict[str, object]
FiatFluctuation = Dict[str, object]


def _request_json(url: str, params: Optional[Dict[str, object]] = None) -> Dict[str, object]:
    response = requests.get(url, params=params, timeout=10)
    response.raise_for_status()
    return response.json()


def get_crypto_market_data(ids: Iterable[str], vs_currency: str = "usd") -> List[CoinData]:
    """Return market data from CoinGecko for the requested coins."""

    url = "https://api.coingecko.com/api/v3/coins/markets"
    params = {
        "vs_currency": vs_currency,
        "ids": ",".join(ids),
        "order": "market_cap_desc",
        "sparkline": "true",
        "price_change_percentage": "1h,24h,7d",
    }

    raw = _request_json(url, params=params)
    return [coin for coin in raw if isinstance(coin, dict)]


def get_fiat_fluctuations(
    symbols: Iterable[str], base_currency: str = "USD", start_date: Optional[dt.date] = None
) -> Dict[str, FiatFluctuation]:
    """Return day-over-day percentage changes for fiat currencies using exchangerate.host."""

    if start_date is None:
        start_date = dt.date.today() - dt.timedelta(days=1)

    end_date = start_date + dt.timedelta(days=1)
    url = "https://api.exchangerate.host/fluctuation"
    params = {
        "base": base_currency,
        "symbols": ",".join(symbols),
        "start_date": start_date.isoformat(),
        "end_date": end_date.isoformat(),
    }
    payload = _request_json(url, params=params)

    rates = payload.get("rates", {}) if isinstance(payload, dict) else {}
    filtered = {symbol: data for symbol, data in rates.items() if isinstance(data, dict)}
    return filtered
