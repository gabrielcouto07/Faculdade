import argparse
import sys
from typing import List

from .analysis import build_alert_message, evaluate_crypto_data, evaluate_fiat_data
from .config import FilterSettings
from .data_sources import get_crypto_market_data, get_fiat_fluctuations
from .notifications import send_whatsapp_alert


def parse_args(argv: List[str]) -> argparse.Namespace:
    parser = argparse.ArgumentParser(description="Monitor de cripto e moedas com alertas no WhatsApp")
    parser.add_argument("--coins", type=str, help="Lista separada por vírgula de IDs de moedas no CoinGecko")
    parser.add_argument("--fiat", type=str, help="Lista separada por vírgula de moedas fiat (ex: EUR,BRL)")
    parser.add_argument("--min-change-24h", type=float, default=None, help="Variação mínima de 24h para alertar")
    parser.add_argument("--min-change-7d", type=float, default=None, help="Variação mínima de 7d para alertar")
    parser.add_argument("--min-volume", type=float, default=None, help="Volume mínimo em USD")
    parser.add_argument(
        "--fiat-change-threshold", type=float, default=None, help="Variação mínima diária (%) para moedas fiat"
    )
    parser.add_argument("--send-whatsapp", action="store_true", help="Envia alerta pelo WhatsApp se credenciais existirem")
    parser.add_argument("--vs-currency", type=str, default=None, help="Moeda de referência para preços de cripto")
    parser.add_argument("--base-fiat", type=str, default=None, help="Moeda base para comparação de fiat")
    return parser.parse_args(argv)


def build_settings(args: argparse.Namespace) -> FilterSettings:
    settings = FilterSettings()
    if args.min_change_24h is not None:
        settings.min_change_24h = args.min_change_24h
    if args.min_change_7d is not None:
        settings.min_change_7d = args.min_change_7d
    if args.min_volume is not None:
        settings.min_volume_usd = args.min_volume
    if args.fiat_change_threshold is not None:
        settings.fiat_change_threshold = args.fiat_change_threshold
    if args.coins:
        settings.tracked_coins = [coin.strip() for coin in args.coins.split(",") if coin.strip()]
    if args.fiat:
        settings.tracked_fiat = [code.strip().upper() for code in args.fiat.split(",") if code.strip()]
    if args.vs_currency:
        settings.vs_currency = args.vs_currency
    if args.base_fiat:
        settings.base_fiat = args.base_fiat.upper()
    return settings


def run_monitor(args: argparse.Namespace) -> str:
    settings = build_settings(args)
    crypto_data = get_crypto_market_data(settings.tracked_coins, vs_currency=settings.vs_currency)
    fiat_data = get_fiat_fluctuations(settings.tracked_fiat, base_currency=settings.base_fiat)

    crypto_insights = evaluate_crypto_data(crypto_data, settings)
    fiat_insights = evaluate_fiat_data(fiat_data, settings)

    alert_message = build_alert_message(crypto_insights, fiat_insights)
    if args.send_whatsapp:
        try:
            sent = send_whatsapp_alert(alert_message)
            if sent:
                print("Alerta enviado pelo WhatsApp.")
            else:
                print("Credenciais do WhatsApp não configuradas. Mensagem apenas exibida.")
        except Exception as exc:  # noqa: BLE001
            print(f"Falha ao enviar alerta: {exc}")
    return alert_message


def main(argv: List[str] | None = None) -> int:
    parsed = parse_args(argv or [])
    message = run_monitor(parsed)
    print(message)
    return 0


if __name__ == "__main__":
    sys.exit(main(sys.argv[1:]))
