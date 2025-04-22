package pessoasNecessidadesEspeciais;

import util.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SistemaPessoasTest {

    private SistemaPessoas sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaPessoas();
    }

    @Test
    public void testCadastrarPessoa() {
        TestHelper.simulateInput("João\n30\nFísica\nLeve\nRua 123\n");

        sistema.cadastrarPessoa();

        assertEquals(1, sistema.listaPessoas.size(), "Deve haver 1 pessoa cadastrada.");
        assertEquals("João", sistema.listaPessoas.get(0).getNome(), "O nome da pessoa cadastrada deve ser João.");
    }

    @Test
    public void testListarPessoas() {
        TestHelper.simulateInput("João\n30\nFísica\nLeve\nRua 123\n");
        sistema.cadastrarPessoa();

        sistema.listarPessoas();
        assertEquals(1, sistema.listaPessoas.size(), "Deve haver 1 pessoa cadastrada.");
    }

    @Test
    public void testFiltrarPessoas() {
        TestHelper.simulateInput("João\n30\nFísica\nLeve\nRua 123\n");
        sistema.cadastrarPessoa();
        TestHelper.simulateInput("Maria\n25\nAuditiva\nModerado\nRua 456\n");
        sistema.cadastrarPessoa();

        TestHelper.simulateInput("Física\nLeve\n");
        sistema.filtrarPessoas();

        assertEquals(1, sistema.listaPessoas.size(), "Deve haver 1 pessoa filtrada.");
        assertEquals("João", sistema.listaPessoas.get(0).getNome(), "O nome da pessoa filtrada deve ser João.");
    }

    @Test
    public void testRegistrarAtendimento() {
        TestHelper.simulateInput("João\n30\nFísica\nLeve\nRua 123\n");
        sistema.cadastrarPessoa();

        TestHelper.simulateInput("João\n2023-04-15\nFisioterapia\nDr. Silva\n");
        sistema.registrarAtendimento();
    }
}
