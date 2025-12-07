"""Ferramentas para monitorar cripto e moedas com alertas personalizáveis."""

from .analysis import build_alert_message, evaluate_crypto_data, evaluate_fiat_data
from .cli import main
from .config import FilterSettings
from .data_sources import get_crypto_market_data, get_fiat_fluctuations
from .notifications import send_whatsapp_alert

__all__ = [
    "build_alert_message",
    "evaluate_crypto_data",
    "evaluate_fiat_data",
    "main",
    "FilterSettings",
    "get_crypto_market_data",
    "get_fiat_fluctuations",
    "send_whatsapp_alert",
]
