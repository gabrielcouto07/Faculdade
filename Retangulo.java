package lista.lista01;

public class Retangulo {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        if (base <= 0) {
            throw new IllegalArgumentException("Base deve ser maior que zero.");
        }
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que zero.");
        }
        this.base = base;
        this.altura = altura;
    }

    public double calculaArea() {
        return base * altura;
    }

    public double calculaPerimetro() {
        return 2 * (base + altura);
    }
}
