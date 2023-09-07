package List.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        pessoasPorAltura.sort(new ComparatorPorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();

        ordenacaoPessoa.adicionarPessoa("Eduardo", 43, 1.60);
        ordenacaoPessoa.adicionarPessoa("Jeremias", 96, 1.70);
        ordenacaoPessoa.adicionarPessoa("Fernanda", 16, 1.50);
        ordenacaoPessoa.adicionarPessoa("Paula", 20, 1.80);
        ordenacaoPessoa.adicionarPessoa("Juninho", 22, 1.75);

        System.out.println(ordenacaoPessoa.pessoaList + "\n");

        System.out.println("Ordenação por Altura: " + ordenacaoPessoa.ordenarPorAltura() + "\n");
        System.out.println("Ordenação por Idade: " + ordenacaoPessoa.ordenarPorIdade() + "\n");
    }
}
