package Lista05Exe02;

import Lista05Exe02.criadores.Hamburgueria;
import Lista05Exe02.criadores.HamburgueriaVegana;

public class Lista05Exe02 {
    public static void main(String[] args) {
        Hamburgueria hamburgueriaVegana = new HamburgueriaVegana();

        System.out.println("Pedindo um Hambúrguer Vegano:");
        hamburgueriaVegana.pedirSanduiche("hamburguervegano");

        System.out.println("\nPedindo um Wrap de Falafel:");
        hamburgueriaVegana.pedirSanduiche("wrapdefalafel");

        System.out.println("\nPedindo um Sanduíche de Legumes Grelhados:");
        hamburgueriaVegana.pedirSanduiche("sanduichedelegumesgrelhados");

        System.out.println("\nTentando pedir um sanduíche indisponível:");
        hamburgueriaVegana.pedirSanduiche("hamburguerfrango");
    }
}