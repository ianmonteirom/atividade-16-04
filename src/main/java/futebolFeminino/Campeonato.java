package futebolFeminino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Campeonato {
    private List<Time> listaTimes = new ArrayList<>();
    private List<String> listaPartidas;
    private List<String> listaPlacares;

    public Campeonato() {
        listaTimes = new ArrayList<>();
    }

    public List<Time> getListaTimes() {
        return this.listaTimes;
    }

    public Time cadastrarTime() {
        Time time = new Time();
        String nome = time.receberNome();
        String cidade = time.receberCidade();
        List<Jogadora> listaJogadoras = time.getListaJogadoras();
        adicionarTimeLista(time);
        return time;
    }

    private void adicionarTimeLista(Time time) {
        listaTimes.add(time);
    }

    public String registrarPartida() {
        Scanner scanner = new Scanner(System.in);

        Time time1 = escolherTime();
        if (time1 == null) return "";

        Time time2 = escolherTime();
        if (time2 == null || time1 == time2) {
            System.out.println("Você não pode escolher o mesmo time para os dois.");
            return "";
        }

        String resultado = registrarPlacar();
        atualizarPontos(time1, time2, resultado);

        return time1.getNome() + " x " + time2.getNome();
    }

    private Time escolherTime() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lista de Times:");
        List<Time> listaTimes = getListaTimes();
        if (listaTimes.isEmpty()) {
            System.out.println("Nenhum time cadastrado.");
            return null;
        }

        for (int i = 0; i < listaTimes.size(); i++) {
            System.out.println((i + 1) + " - " + listaTimes.get(i).getNome());
        }

        System.out.print("Escolha o número do time: ");
        int escolhaTime = scanner.nextInt();
        scanner.nextLine();
        if (escolhaTime < 1 || escolhaTime > listaTimes.size()) {
            System.out.println("Opção inválida.");
            return null;
        }
        return listaTimes.get(escolhaTime - 1);
    }

    String registrarPlacar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o placar da partida (ex: 2x1): ");
        String resultado = scanner.nextLine();
        return resultado;
    }

    void atualizarPontos(Time time1, Time time2, String resultado) {
        String[] placar = resultado.split("x");
        int golsTime1 = Integer.parseInt(placar[0].trim());
        int golsTime2 = Integer.parseInt(placar[1].trim());

        if (golsTime1 > golsTime2) {
            time1.adicionarPontos(3);
        } else if (golsTime1 < golsTime2) {
            time2.adicionarPontos(3);
        } else {
            time1.adicionarPontos(1);
            time2.adicionarPontos(1);
        }

        System.out.println("Partida registrada: " + time1.getNome() + " " + golsTime1 + " x " + golsTime2 + " " + time2.getNome());
        System.out.println("Pontos: " + time1.getNome() + " - " + time1.getPontos() + " pontos");
        System.out.println("Pontos: " + time2.getNome() + " - " + time2.getPontos() + " pontos");
    }

    public void listarTimes() {
        List<Time> listaTimes = getListaTimes();

        if (listaTimes.isEmpty()) {
            System.out.println("Nenhum time cadastrado.");
            return;
        }

        Collections.sort(listaTimes, new Comparator<Time>() {
            @Override
            public int compare(Time t1, Time t2) {
                return Integer.compare(t2.getPontos(), t1.getPontos());
            }
        });

        System.out.println("Lista de Times (ordenada por pontos):");
        for (Time time : listaTimes) {
            System.out.println(time.getNome() + " - " + time.getCidade() + " - " + time.getPontos() + " pontos");
        }
    }

    public void listarPartidas() {
        for (String partida : listaPartidas) {
            System.out.println(partida);
        }
    }
}
