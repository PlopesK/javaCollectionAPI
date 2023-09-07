package Set.Ordenacao;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProduto {
    private Set<Produto> produtoSet;

    public CadastroProduto() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(codigo, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutoPorNome() {
        return new TreeSet<>(produtoSet);
    }

    public Set<Produto> exibirProdutoPorPreco() {
        Set<Produto> produtoPorPreco = new TreeSet<>(new CompararPorPreco());
        produtoPorPreco.addAll(produtoSet);
        return produtoPorPreco;
    }

    public Set<Produto> exibirProdutoPorQuantidade() {
        Set<Produto> produtoPorQuantidade = new TreeSet<>(new CompararPorQuantidade());
        produtoPorQuantidade.addAll(produtoSet);
        return produtoPorQuantidade;
    }

    public static void main(String[] args) {
        CadastroProduto cadastroProduto = new CadastroProduto();

        cadastroProduto.adicionarProduto(0, "Banana", 5.20, 14);
        cadastroProduto.adicionarProduto(0, "Maçã", 10.30, 32); //Não registra por ter o mesmo código
        cadastroProduto.adicionarProduto(1, "Morango", 12.00, 8);
        cadastroProduto.adicionarProduto(2, "Manga", 15.50, 3);
        cadastroProduto.adicionarProduto(3, "Abacaxi", 8.50, 10);
        cadastroProduto.adicionarProduto(4, "Caju", 20.20, 22);

        System.out.println("Sem organização: \n" + cadastroProduto.produtoSet + "\n");

        System.out.println("Organizando por Nome: \n" + cadastroProduto.exibirProdutoPorNome() + "\n");

        System.out.println("Organizando por Preço: \n" + cadastroProduto.exibirProdutoPorPreco() + "\n");

        System.out.println("Organizando por Quantidade: \n" + cadastroProduto.exibirProdutoPorQuantidade() + "\n");
    }
}

class CompararPorPreco implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}

class CompararPorQuantidade implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Integer.compare(p1.getQuantidade(), p2.getQuantidade());
    }
}
