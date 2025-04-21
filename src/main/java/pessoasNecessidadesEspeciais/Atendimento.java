package pessoasNecessidadesEspeciais;

import java.util.Date;

public class Atendimento {
    private Date data;
    private String tipoAtendimento;
    private String profissionalResponsavel;

    public Atendimento(Date data, String tipoAtendimento, String profissionalResponsavel) {
        this.data = data;
        this.tipoAtendimento = tipoAtendimento;
        this.profissionalResponsavel = profissionalResponsavel;
    }

    public Date getData() {
        return data;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public String getProfissionalResponsavel() {
        return profissionalResponsavel;
    }

    @Override
    public String toString() {
        return "Atendimento [Data: " + data + ", Tipo: " + tipoAtendimento + ", Profissional: " + profissionalResponsavel + "]";
    }
}
