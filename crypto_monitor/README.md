# Monitor de Criptomoedas e Moedas Fiat

Aplicação em Python para acompanhar preços de criptomoedas (CoinGecko) e moedas fiat (exchangerate.host), aplicar filtros customizados e enviar alertas pelo WhatsApp via Twilio.

## Funcionalidades
- Consulta em tempo real de preços e variação percentual de criptomoedas.
- Flutuação diária de moedas fiat em relação a uma moeda base.
- Filtros configuráveis para variações percentuais e volume.
- Geração de mensagens prontas para envio ao WhatsApp.
- Suporte opcional ao envio via Twilio (WhatsApp Business API).

## Estrutura
```
crypto_monitor/
├── crypto_monitor/
│   ├── analysis.py          # Filtros, formatação e geração de alertas
│   ├── cli.py               # Interface de linha de comando
│   ├── config.py            # Configurações e valores padrão
│   ├── data_sources.py      # Integração com CoinGecko e exchangerate.host
│   ├── notifications.py     # Envio opcional de mensagens pelo WhatsApp
│   └── __init__.py
├── README.md
└── requirements.txt
```

## Instalação
```bash
python -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
```

## Uso Rápido
Exemplo com filtros padrões (BTC, ETH, SOL e moedas EUR, BRL, GBP):
```bash
python -m crypto_monitor.cli
```

Com filtros customizados e envio pelo WhatsApp (necessita variáveis de ambiente abaixo):
```bash
python -m crypto_monitor.cli \
  --coins bitcoin,ethereum,solana,cardano \
  --fiat EUR,BRL \
  --min-change-24h 4 --min-change-7d 8 --min-volume 75000000 \
  --fiat-change-threshold 1.0 \
  --send-whatsapp
```

## Variáveis de Ambiente para WhatsApp (Twilio)
- `TWILIO_ACCOUNT_SID`
- `TWILIO_AUTH_TOKEN`
- `TWILIO_WHATSAPP_FROM` (remetente autorizado no Twilio)
- `WHATSAPP_TO` (destinatário em formato internacional)

Sem essas variáveis, a aplicação apenas imprime o alerta. Com as variáveis configuradas, a mensagem é enviada via API do Twilio.

## Saída Esperada
A execução gera um resumo como o exemplo abaixo:
```
📊 Alerta de Mercado

Criptomoedas:
Bitcoin (BTC)
Preço: 68000.00
Variação 24h: 3.20% | 7d: 6.50%
Volume: $15,500,000,000
Média móvel (7d): 67000.34

Moedas Fiat:
EUR (alta)
Início: 0.9200 | Fim: 0.9285
Variação: 0.92%
```

## Conectando ao WhatsApp
A saída `alert_message` pode ser consumida por integrações externas. Para acionar diretamente o WhatsApp com Twilio, use `--send-whatsapp` ou invoque `send_whatsapp_alert(message)` no seu próprio código, garantindo que as variáveis de ambiente estejam configuradas.

## Observações
- CoinGecko impõe limites de rate-limit; evite chamadas muito frequentes.
- exchangerate.host retorna a flutuação diária; o parâmetro `--base-fiat` define a moeda base (padrão USD).
- Para análises mais profundas, você pode estender `analysis.py` para incluir indicadores adicionais (RSI, MACD, etc.).
