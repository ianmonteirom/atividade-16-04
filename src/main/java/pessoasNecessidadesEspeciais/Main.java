package pessoasNecessidadesEspeciais;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaPessoas sistema = new SistemaPessoas();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Pessoa");
            System.out.println("2 - Listar Pessoas");
            System.out.println("3 - Filtrar Pessoas");
            System.out.println("4 - Registrar Atendimento");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    sistema.cadastrarPessoa();
                    break;
                case 2:
                    sistema.listarPessoas();
                    break;
                case 3:
                    sistema.filtrarPessoas();
                    break;
                case 4:
                    sistema.registrarAtendimento();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
