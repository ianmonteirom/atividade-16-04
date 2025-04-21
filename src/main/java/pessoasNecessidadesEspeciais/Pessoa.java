package pessoasNecessidadesEspeciais;

public class Pessoa {
    private String nome;
    private int idade;
    private String tipoDeficiencia;
    public Grau grau;
    public String endereco;

    public Pessoa(String nome, int idade, String tipoDeficiencia, Grau grau, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.tipoDeficiencia = tipoDeficiencia;
        this.grau = grau;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public Grau getGrau() {
        return grau;
    }

    public void setGrau(Grau grau) {
        this.grau = grau;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
