package sistemaPedagio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PracaPedagio pracaPedagio = new PracaPedagio("Rodovia XYZ", 10.0); // Exemplo: tarifa base R$10
        Pedagio pedagio = new Pedagio(pracaPedagio);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Registrar Passagem");
            System.out.println("2 - Gerar Relatório");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Digite o tipo de veículo (carro, moto, caminhão): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite o número de eixos (apenas para caminhão): ");
                    int eixos = scanner.nextInt();
                    scanner.nextLine();

                    Veiculo veiculo = new Veiculo(placa, tipo, eixos);
                    pedagio.registrarPassagem(veiculo);
                    break;
                case 2:
                    pedagio.gerarRelatorio();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
