package futebolFeminino;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Campeonato campeonato = new Campeonato();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Time");
            System.out.println("2 - Listar Times");
            System.out.println("3 - Cadastrar Partida");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (campeonato.getListaTimes().size() < 20) {
                        campeonato.cadastrarTime();
                    } else {
                        System.out.println("Já foram cadastrados 20 times.");
                    }
                    break;
                case 2:
                    campeonato.listarTimes();
                    break;
                case 3:
                    campeonato.registrarPartida();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
