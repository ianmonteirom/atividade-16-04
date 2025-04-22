package sistemaPedagio;

import java.util.ArrayList;
import java.util.List;

public class Pedagio {
    List<Veiculo> veiculosPassados;
    List<Double> valoresArrecadados;
    private PracaPedagio pracaPedagio;

    public Pedagio(PracaPedagio pracaPedagio) {
        this.pracaPedagio = pracaPedagio;
        this.veiculosPassados = new ArrayList<>();
        this.valoresArrecadados = new ArrayList<>();
    }

    public void registrarPassagem(Veiculo veiculo) {
        double valorPedagio = calcularValorPedagio(veiculo);
        veiculosPassados.add(veiculo);
        valoresArrecadados.add(valorPedagio);
        System.out.println("Veículo " + veiculo.getPlaca() + " passou pela praça " + pracaPedagio.getLocalizacao() + " e foi cobrado: R$ " + valorPedagio);
    }

    public double calcularValorPedagio(Veiculo veiculo) {
        double tarifaBase = pracaPedagio.getTarifaBase();
        switch (veiculo.getTipo().toLowerCase()) {
            case "carro":
                return tarifaBase;
            case "moto":
                return tarifaBase * 0.5;
            case "caminhão":
                return tarifaBase * veiculo.getEixos();
            default:
                return 0.0;
        }
    }

    public void gerarRelatorio() {
        System.out.println("\nRelatório de arrecadação da praça: " + pracaPedagio.getLocalizacao());
        double totalArrecadado = 0;
        for (int i = 0; i < veiculosPassados.size(); i++) {
            Veiculo veiculo = veiculosPassados.get(i);
            double valor = valoresArrecadados.get(i);
            System.out.println("Veículo: " + veiculo.getPlaca() + " | Tipo: " + veiculo.getTipo() + " | Valor cobrado: R$ " + valor);
            totalArrecadado += valor;
        }
        System.out.println("Total arrecadado: R$ " + totalArrecadado);
    }
}
