package Map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if(!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        } else {
            System.out.println("Agenda vazia!");
        }
    }

    public void exibirContato() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if(!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        } else {
            System.out.println("Agenda vazia!");
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Gabriel João", 2131232);
        agendaContatos.adicionarContato("Ana", 312321213);
        agendaContatos.adicionarContato("João", 33231312);
        agendaContatos.adicionarContato("Julia", 821987312);
        agendaContatos.adicionarContato("Gabriel", 4444444);

        agendaContatos.exibirContato();

        agendaContatos.removerContato("Gabriel João");
        agendaContatos.exibirContato();

        System.out.println("\nPesquisou o usuário de número: \n" + agendaContatos.pesquisarPorNome("Gabriel"));
    }
}