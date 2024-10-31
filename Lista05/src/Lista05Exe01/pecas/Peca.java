package Lista05Exe01.pecas;

import Lista05Exe01.movimentos.Movimento;

public abstract class Peca {
    protected Movimento movimento;

    public Peca(Movimento movimento) {
        this.movimento = movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
    }

    public void mover() {
        movimento.executarMovimento();
    }
}
