import os
from typing import Optional

import requests


def build_twilio_payload(body: str) -> Optional[dict]:
    account_sid = os.getenv("TWILIO_ACCOUNT_SID")
    auth_token = os.getenv("TWILIO_AUTH_TOKEN")
    sender = os.getenv("TWILIO_WHATSAPP_FROM")
    recipient = os.getenv("WHATSAPP_TO")

    if not all([account_sid, auth_token, sender, recipient]):
        return None

    return {
        "url": f"https://api.twilio.com/2010-04-01/Accounts/{account_sid}/Messages.json",
        "auth": (account_sid, auth_token),
        "data": {
            "From": f"whatsapp:{sender}",
            "To": f"whatsapp:{recipient}",
            "Body": body,
        },
    }


def send_whatsapp_alert(message: str) -> bool:
    payload = build_twilio_payload(message)
    if payload is None:
        return False

    response = requests.post(payload["url"], auth=payload["auth"], data=payload["data"], timeout=10)
    response.raise_for_status()
    return True
