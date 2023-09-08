package Map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventoMap;

    private AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventoMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventoTreeMap);
    }

    public void proximoEvento() {
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventoMap);
        for (Map.Entry<LocalDate, Evento> entry : eventoTreeMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("\nO próximo evento: " + proximoEvento + "acontecerá na data " + proximaData);
                break;
            }
        }
    }

    public void ultimoEvento() {
        LocalDate ultimaData = null;
        Evento ultimoEvento = null;
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventoMap).descendingMap();
        for (Map.Entry<LocalDate, Evento> entry : eventoTreeMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isBefore(dataAtual)) {
                ultimaData = entry.getKey();
                ultimoEvento = entry.getValue();
                System.out.println("\nO último evento: " + ultimoEvento + "foi em " + ultimaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 22), "Lola Paulo", "Cantoria braba");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 2, 10), "Lola Paulo 2", "A volta dos que não cantaram");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.JUNE, 2), "Rock in June", "Bandas de rock XXXXXXXXXX");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.SEPTEMBER, 27), "Criatividade 5", "Estou sem ideia do que colocar");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER, 31), "Halloween", "Spoooky!!");

        System.out.println("\nTodos os eventos são: ");
        agendaEventos.exibirAgenda();

        agendaEventos.proximoEvento();

        agendaEventos.ultimoEvento();
    }
}
