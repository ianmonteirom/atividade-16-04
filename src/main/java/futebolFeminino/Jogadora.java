package futebolFeminino;

import java.util.Scanner;

public class Jogadora {
    private String nome;
    private String posicao;
    private int numeroCamisa;

    private Scanner scanner = new Scanner(System.in);

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    private String getNome() {
        return this.nome;
    }

    private String getPosicao() {
        return this.posicao;
    }

    private int getNumeroCamisa() {
        return this.numeroCamisa;
    }

    public String receberNome() {
        System.out.print("Por favor, digite o nome da jogadora que deseja cadastrar: ");
        setNome(scanner.nextLine());
        String nome = getNome();
        return nome;
    }

    public String receberPosicao() {
        System.out.print("Por favor, digite a posição da jogadora" + nome);
        setPosicao(scanner.nextLine());
        String posicao = getPosicao();
        return posicao;
    }

    public int receberNumeroCamisa() {
        System.out.print("Por favor, digite o número da camisa da jogadora" + nome);
        setNumeroCamisa(scanner.nextInt());
        int numeroCamisa = getNumeroCamisa();
        return numeroCamisa;
    }

}
