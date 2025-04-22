package futebolFeminino;

import util.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CampeonatoTest {

    private Campeonato campeonato;

    @BeforeEach
    public void setUp() {
        campeonato = new Campeonato();
    }

    @Test
    public void testCadastrarTime() {
        TestHelper.simulateInput("Time 1\nCidade 1\n");

        Time time = campeonato.cadastrarTime();
        assertNotNull(time, "O time não deve ser nulo.");
        assertTrue(campeonato.getListaTimes().contains(time), "O time deve estar na lista de times.");
    }


    @Test
    public void testRegistrarPartida() {
        TestHelper.simulateInput("Time 1\nTime 2\n");

        Time time1 = campeonato.cadastrarTime();
        Time time2 = campeonato.cadastrarTime();

        String resultado = campeonato.registrarPartida();
        assertNotNull(resultado, "O resultado da partida não deve ser nulo.");
    }

    @Test
    public void testOrdenacaoTimesPorPontos() {
        TestHelper.simulateInput("Time 1\nCidade 1\nTime 2\nCidade 2\nTime 3\nCidade 3\n");

        Time time1 = campeonato.cadastrarTime();
        time1.adicionarPontos(10);

        Time time2 = campeonato.cadastrarTime();
        time2.adicionarPontos(20);

        Time time3 = campeonato.cadastrarTime();
        time3.adicionarPontos(5);

        campeonato.listarTimes();

        assertEquals("Time 2", campeonato.getListaTimes().get(0).getNome(), "O time com mais pontos deve ser o primeiro.");
        assertEquals("Time 1", campeonato.getListaTimes().get(1).getNome(), "O time com 10 pontos deve ser o segundo.");
        assertEquals("Time 3", campeonato.getListaTimes().get(2).getNome(), "O time com 5 pontos deve ser o terceiro.");
    }


    @Test
    public void testRegistrarPlacar() {
        TestHelper.simulateInput("2x1\n");

        String placar = "2x1";
        String resultado = campeonato.registrarPlacar();
        assertNotNull(resultado, "O placar registrado não deve ser nulo.");
    }


    @Test
    public void testAdicionarPontos() {
        Time time = new Time();
        time.adicionarPontos(3);
        assertEquals(3, time.getPontos(), "O time deve ter 3 pontos.");
        time.adicionarPontos(2);
        assertEquals(5, time.getPontos(), "O time deve ter 5 pontos.");
    }


    @Test
    public void testPartidaEmpate() {
        TestHelper.simulateInput("Time 1\nTime 2\n2x2\n");

        Time time1 = campeonato.cadastrarTime();
        Time time2 = campeonato.cadastrarTime();

        String resultado = "2x2";
        campeonato.registrarPlacar();
        campeonato.atualizarPontos(time1, time2, resultado);

        assertEquals(1, time1.getPontos(), "Ambos os times devem ter 1 ponto após empate.");
        assertEquals(1, time2.getPontos(), "Ambos os times devem ter 1 ponto após empate.");
    }


    @Test
    public void testPartidaVitoria() {
        TestHelper.simulateInput("Time 1\nTime 2\n3x1\n");

        Time time1 = campeonato.cadastrarTime();
        Time time2 = campeonato.cadastrarTime();

        String resultado = "3x1";
        campeonato.registrarPlacar();
        campeonato.atualizarPontos(time1, time2, resultado);

        assertEquals(3, time1.getPontos(), "O time1 deve ter 3 pontos após vitória.");
        assertEquals(0, time2.getPontos(), "O time2 deve ter 0 pontos após derrota.");
    }

}
