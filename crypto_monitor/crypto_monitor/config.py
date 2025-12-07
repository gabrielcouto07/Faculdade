from dataclasses import dataclass, field
from typing import Dict, List


@dataclass
class FilterSettings:
    """Configurable thresholds for alerts and data selection."""

    min_change_24h: float = 2.5
    min_change_7d: float = 5.0
    min_volume_usd: float = 50_000_000
    fiat_change_threshold: float = 0.5
    tracked_coins: List[str] = field(default_factory=lambda: ["bitcoin", "ethereum", "solana"])
    tracked_fiat: List[str] = field(default_factory=lambda: ["EUR", "BRL", "GBP"])
    vs_currency: str = "usd"
    base_fiat: str = "USD"

    def as_dict(self) -> Dict[str, float]:
        return {
            "min_change_24h": self.min_change_24h,
            "min_change_7d": self.min_change_7d,
            "min_volume_usd": self.min_volume_usd,
            "fiat_change_threshold": self.fiat_change_threshold,
        }
