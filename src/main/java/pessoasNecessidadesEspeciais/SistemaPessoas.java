package pessoasNecessidadesEspeciais;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class SistemaPessoas {
    List<Pessoa> listaPessoas = new ArrayList<>();

    public void cadastrarPessoa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade da pessoa: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o tipo de deficiência: ");
        String tipoDeficiencia = scanner.nextLine();

        System.out.print("Digite o grau da deficiência (LEVE, MODERADO, SEVERO): ");
        String grauInput = scanner.nextLine();
        Grau grau = Grau.valueOf(grauInput.toUpperCase());

        System.out.print("Digite o endereço da pessoa: ");
        String endereco = scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, idade, tipoDeficiencia, grau, endereco);
        listaPessoas.add(pessoa);

        System.out.println("Pessoa cadastrada com sucesso!");
    }

    public void listarPessoas() {
        if (listaPessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        for (Pessoa pessoa : listaPessoas) {
            System.out.println(pessoa.getNome() + " - " + pessoa.getTipoDeficiencia() + " - " + pessoa.getGrau() + " - " + pessoa.getEndereco());
        }
    }

    public void filtrarPessoas() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tipo de deficiência para filtrar (ex: física, auditiva, visual, etc.): ");
        String tipoDeficiencia = scanner.nextLine();

        System.out.print("Digite o grau da deficiência para filtrar (LEVE, MODERADO, SEVERO): ");
        String grauInput = scanner.nextLine();
        Grau grau = Grau.valueOf(grauInput.toUpperCase());

        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getTipoDeficiencia().equalsIgnoreCase(tipoDeficiencia) && pessoa.getGrau().equals(grau)) {
                System.out.println(pessoa.getNome() + " - " + pessoa.getTipoDeficiencia() + " - " + pessoa.getGrau() + " - " + pessoa.getEndereco());
            }
        }
    }

    public void registrarAtendimento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da pessoa para registrar o atendimento: ");
        String nome = scanner.nextLine();

        Pessoa pessoa = encontrarPessoa(nome);
        if (pessoa == null) {
            System.out.println("Pessoa não encontrada.");
            return;
        }

        System.out.print("Digite a data do atendimento (AAAA-MM-DD): ");
        String dataInput = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = LocalDate.parse(dataInput, formatter);

        System.out.print("Digite o tipo de atendimento (fisioterapia, psicologia, etc.): ");
        String tipoAtendimento = scanner.nextLine();

        System.out.print("Digite o nome do profissional responsável: ");
        String profissionalResponsavel = scanner.nextLine();

        Atendimento atendimento = new Atendimento(java.sql.Date.valueOf(data), tipoAtendimento, profissionalResponsavel);
    }


    private Pessoa encontrarPessoa(String nome) {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                return pessoa;
            }
        }
        return null;
    }
}
