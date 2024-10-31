package Lista05Exe02.criadores;

import Lista05Exe02.sanduiches.Sanduiche;

public abstract class Hamburgueria {
    public abstract Sanduiche criarSanduiche(String tipo);

    public Sanduiche pedirSanduiche(String tipo) {
        Sanduiche sanduiche = criarSanduiche(tipo);
        if (sanduiche != null) {
            sanduiche.preparar();
        } else {
            System.out.println("Desculpe, este tipo de sanduíche não está disponível.");
        }
        return sanduiche;
    }
}
