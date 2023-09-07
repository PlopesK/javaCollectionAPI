package Set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void deletarConvidado(int codigoConvite) {
        Convidado convidadoRemover = null;
        for (Convidado c: convidadoSet) {
            if(c.getCodigoConvite() == codigoConvite) {
                convidadoRemover = c;
                break;
            } else {
                throw new RuntimeException("Convidado não encontrado!");
            }
        }
        convidadoSet.remove(convidadoRemover);
    }

    public int contarConvidado() {
        return convidadoSet.size();
    }

    public void exibirConvidado() {
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("Paulin", 1234);
        conjuntoConvidados.adicionarConvidado("Osvaldo", 1234); //Não aparece por não permitir códigos repetidos
        conjuntoConvidados.adicionarConvidado("Julia", 3132);
        conjuntoConvidados.adicionarConvidado("Gabriel", 4444);
        conjuntoConvidados.adicionarConvidado("Gabriel", 3123);
        conjuntoConvidados.adicionarConvidado("Aline", 1210);

        System.out.println("\nExistem " + conjuntoConvidados.contarConvidado() + " dentro do Set de Convidados: \n");
        conjuntoConvidados.exibirConvidado();

        conjuntoConvidados.deletarConvidado(1234);
        conjuntoConvidados.deletarConvidado(3123);
        System.out.println("\nExistem " + conjuntoConvidados.contarConvidado() + " dentro do Set de Convidados: \n");
        conjuntoConvidados.exibirConvidado();
    }
}
