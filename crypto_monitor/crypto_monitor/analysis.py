from dataclasses import dataclass
from typing import Dict, Iterable, List

from .config import FilterSettings
from .data_sources import CoinData, FiatFluctuation


@dataclass
class CryptoInsight:
    asset_id: str
    symbol: str
    name: str
    price: float
    change_24h: float
    change_7d: float
    volume: float
    moving_average: float


@dataclass
class FiatInsight:
    symbol: str
    change_percentage: float
    start_rate: float
    end_rate: float


def _moving_average(prices: Iterable[float]) -> float:
    data = list(prices)
    if not data:
        return 0.0
    return sum(data) / len(data)


def evaluate_crypto_data(coins: List[CoinData], settings: FilterSettings) -> List[CryptoInsight]:
    insights: List[CryptoInsight] = []
    for coin in coins:
        sparkline = coin.get("sparkline_in_7d", {}).get("price", [])
        insight = CryptoInsight(
            asset_id=str(coin.get("id", "")),
            symbol=str(coin.get("symbol", "")).upper(),
            name=str(coin.get("name", "")),
            price=float(coin.get("current_price", 0.0)),
            change_24h=float(coin.get("price_change_percentage_24h", 0.0)),
            change_7d=float(coin.get("price_change_percentage_7d_in_currency", 0.0)),
            volume=float(coin.get("total_volume", 0.0)),
            moving_average=_moving_average(sparkline[-48:]),
        )

        if _passes_crypto_filters(insight, settings):
            insights.append(insight)
    return insights


def _passes_crypto_filters(insight: CryptoInsight, settings: FilterSettings) -> bool:
    return (
        insight.change_24h >= settings.min_change_24h
        or insight.change_7d >= settings.min_change_7d
        or insight.volume >= settings.min_volume_usd
    )


def evaluate_fiat_data(fluctuations: Dict[str, FiatFluctuation], settings: FilterSettings) -> List[FiatInsight]:
    insights: List[FiatInsight] = []
    for symbol, data in fluctuations.items():
        change_pct = float(data.get("change_pct", 0.0))
        start_rate = float(data.get("start_rate", 0.0))
        end_rate = float(data.get("end_rate", 0.0))
        if abs(change_pct) >= settings.fiat_change_threshold:
            insights.append(
                FiatInsight(
                    symbol=symbol,
                    change_percentage=change_pct,
                    start_rate=start_rate,
                    end_rate=end_rate,
                )
            )
    return insights


def format_crypto_insight(insight: CryptoInsight) -> str:
    return (
        f"{insight.name} ({insight.symbol})\n"
        f"Preço: {insight.price:.2f}\n"
        f"Variação 24h: {insight.change_24h:.2f}% | 7d: {insight.change_7d:.2f}%\n"
        f"Volume: ${insight.volume:,.0f}\n"
        f"Média móvel (7d): {insight.moving_average:.2f}"
    )


def format_fiat_insight(insight: FiatInsight) -> str:
    direction = "alta" if insight.change_percentage >= 0 else "queda"
    return (
        f"{insight.symbol} ({direction})\n"
        f"Início: {insight.start_rate:.4f} | Fim: {insight.end_rate:.4f}\n"
        f"Variação: {insight.change_percentage:.2f}%"
    )


def build_alert_message(crypto: List[CryptoInsight], fiat: List[FiatInsight]) -> str:
    lines: List[str] = ["📊 Alerta de Mercado"]

    if crypto:
        lines.append("\nCriptomoedas:")
        for insight in crypto:
            lines.append(format_crypto_insight(insight))
            lines.append("")
    else:
        lines.append("Nenhuma cripto bateu os filtros.")

    if fiat:
        lines.append("\nMoedas Fiat:")
        for insight in fiat:
            lines.append(format_fiat_insight(insight))
            lines.append("")
    else:
        lines.append("Nenhuma moeda fiat ultrapassou o limite configurado.")

    return "\n".join(line for line in lines if line.strip())
