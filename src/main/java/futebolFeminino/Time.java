package futebolFeminino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Time {
    private String nome;
    private String cidade;
    private List<Jogadora> listaJogadoras = new ArrayList<>();
    private int pontos;

    public Time() {
        this.pontos = 0;
    }

    private Scanner scanner = new Scanner(System.in);

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCidade() {
        return this.cidade;
    }

    public List<Jogadora> getListaJogadoras() {
        return this.listaJogadoras;
    }

    public int getPontos() {
        return this.pontos;
    }

    public Jogadora cadastrarJogadora() {
        Jogadora jogadora = new Jogadora();
        String nome = jogadora.receberNome();
        String posicao = jogadora.receberPosicao();
        int numeroCamisa = jogadora.receberNumeroCamisa();
        adicionarJogadoraLista(jogadora);
        return jogadora;
    }

    public String receberNome() {
        System.out.print("Por favor, digite o nome do time que deseja cadastrar: ");
        setNome(scanner.nextLine());
        String nome = getNome();
        return nome;
    }

    public String receberCidade() {
        System.out.print("Por favor, digite a cidade do time " + nome + ": ");
        setCidade(scanner.nextLine());
        String cidade = getCidade();
        return cidade;
    }

    private void adicionarJogadoraLista(Jogadora jogadora) {
        listaJogadoras.add(jogadora);
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }


}
