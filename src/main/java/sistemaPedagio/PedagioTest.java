package sistemaPedagio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedagioTest {

    private Pedagio pedagio;
    private PracaPedagio pracaPedagio;

    @BeforeEach
    public void setUp() {
        pracaPedagio = new PracaPedagio("Rodovia XYZ", 10.0);
        pedagio = new Pedagio(pracaPedagio);
    }

    @Test
    public void testRegistrarPassagemCarro() {
        Veiculo veiculo = new Veiculo("ABC1234", "carro", 0);
        pedagio.registrarPassagem(veiculo);

        assertEquals(1, pedagio.veiculosPassados.size(), "Deve haver 1 veículo registrado.");
        assertEquals(10.0, pedagio.valoresArrecadados.get(0), "O valor do pedágio para o carro deve ser a tarifa base (10.0).");
    }

    @Test
    public void testRegistrarPassagemMoto() {
        Veiculo veiculo = new Veiculo("XYZ5678", "moto", 0);
        pedagio.registrarPassagem(veiculo);

        assertEquals(1, pedagio.veiculosPassados.size(), "Deve haver 1 veículo registrado.");
        assertEquals(5.0, pedagio.valoresArrecadados.get(0), "O valor do pedágio para a moto deve ser 50% da tarifa base (5.0).");
    }

    @Test
    public void testRegistrarPassagemCaminhao() {
        Veiculo veiculo = new Veiculo("LMN9876", "caminhão", 4);
        pedagio.registrarPassagem(veiculo);

        assertEquals(1, pedagio.veiculosPassados.size(), "Deve haver 1 veículo registrado.");
        assertEquals(40.0, pedagio.valoresArrecadados.get(0), "O valor do pedágio para o caminhão deve ser a tarifa base multiplicada pelos eixos (10.0 * 4 = 40.0).");
    }

    @Test
    public void testCalcularValorPedagio() {
        Veiculo carro = new Veiculo("ABC1234", "carro", 0);
        Veiculo moto = new Veiculo("XYZ5678", "moto", 0);
        Veiculo caminhao = new Veiculo("LMN9876", "caminhão", 4);

        assertEquals(10.0, pedagio.calcularValorPedagio(carro), "O valor do pedágio para carro deve ser a tarifa base.");
        assertEquals(5.0, pedagio.calcularValorPedagio(moto), "O valor do pedágio para moto deve ser 50% da tarifa base.");
        assertEquals(40.0, pedagio.calcularValorPedagio(caminhao), "O valor do pedágio para caminhão deve ser a tarifa base multiplicada pelos eixos.");
    }

    @Test
    public void testGerarRelatorio() {
        Veiculo veiculo1 = new Veiculo("ABC1234", "carro", 0);
        Veiculo veiculo2 = new Veiculo("XYZ5678", "moto", 0);
        Veiculo veiculo3 = new Veiculo("LMN9876", "caminhão", 4);

        pedagio.registrarPassagem(veiculo1);
        pedagio.registrarPassagem(veiculo2);
        pedagio.registrarPassagem(veiculo3);

        pedagio.gerarRelatorio();
        assertEquals(3, pedagio.veiculosPassados.size(), "Deve haver 3 veículos registrados.");
        assertEquals(55.0, pedagio.valoresArrecadados.stream().mapToDouble(Double::doubleValue).sum(), "O total arrecadado deve ser 55.0.");
    }
}
