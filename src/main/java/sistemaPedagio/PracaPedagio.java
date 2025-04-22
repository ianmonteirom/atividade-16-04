package sistemaPedagio;

public class PracaPedagio {
    private String localizacao;
    private double tarifaBase;

    public PracaPedagio(String localizacao, double tarifaBase) {
        this.localizacao = localizacao;
        this.tarifaBase = tarifaBase;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
}
