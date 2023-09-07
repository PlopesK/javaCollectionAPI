package Set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContato() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarContato(String nome) {
        Set<Contato> contatoPorNome = new HashSet<>();
        for(Contato c: contatoSet) {
            if(c.getNome().startsWith(nome)) {
                contatoPorNome.add(c);
            }
        }
        return contatoPorNome;
    }

    public Contato atualizarContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        for(Contato c: contatoSet) {
            if(c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Wellington", 1234343);
        agendaContatos.adicionarContato("Olavo", 0);
        agendaContatos.adicionarContato("Olavo de Carvalho", 534544);
        agendaContatos.adicionarContato("Maria", 1234343);
        agendaContatos.adicionarContato("Marina", 2423123);

        agendaContatos.exibirContato();

        System.out.println("Pesquisando por 'Olavo' \n" + agendaContatos.pesquisarContato("Olavo"));
        System.out.println("Pesquisando por 'Mari' \n" + agendaContatos.pesquisarContato("Mari"));
        System.out.println("Pesquisando por 'Marina' \n" + agendaContatos.pesquisarContato("Marina"));

        System.out.println("\nContato atualizado = " + agendaContatos.atualizarContato("Olavo", 4872937));
        agendaContatos.exibirContato();
    }
}


