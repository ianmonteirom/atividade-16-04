package sistemaPedagio;

public class Veiculo {
    private String placa;
    private String tipo; // Carro, moto, caminhão
    private int eixos;

    public Veiculo(String placa, String tipo, int eixos) {
        this.placa = placa;
        this.tipo = tipo;
        this.eixos = eixos;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }
}
