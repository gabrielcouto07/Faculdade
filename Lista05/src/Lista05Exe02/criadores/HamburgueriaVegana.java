package Lista05Exe02.criadores;

import Lista05Exe02.sanduiches.HamburgerVegano;
import Lista05Exe02.sanduiches.Sanduiche;
import Lista05Exe02.sanduiches.SanduicheDeLegumesGrelhados;
import Lista05Exe02.sanduiches.WrapDeFalafel;

public class HamburgueriaVegana extends Hamburgueria {
    @Override
    public Sanduiche criarSanduiche(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "hamburguervegano" -> new HamburgerVegano();
            case "wrapdefalafel" -> new WrapDeFalafel();
            case "sanduichedelegumesgrelhados" -> new SanduicheDeLegumesGrelhados();
            default -> null;
        };
    }
}
