package Map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProduto {
    private Map<Long, Produto> estoqueProdutoMap;

    public EstoqueProduto() {
        this.estoqueProdutoMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        estoqueProdutoMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        if(!estoqueProdutoMap.isEmpty()) {
            System.out.println(estoqueProdutoMap);
        } else {
            System.out.println("Estoque vazio!");
        }
    }

    public double calcularTotal() {
        double valorTotal = 0;
        if(!estoqueProdutoMap.isEmpty()) {
            for(Produto p: estoqueProdutoMap.values()) {
                valorTotal += p.getQuantidade() * p.getPreco();
            }
        } else {
            System.out.println("Estoque vazio!");
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!estoqueProdutoMap.isEmpty()) {
        for (Produto p: estoqueProdutoMap.values()) {
            if(p.getPreco() > maiorPreco){
                produtoMaisCaro = p;
                maiorPreco = p.getPreco();
            }
        }
        } else {
            System.out.println("Estoque vazio!");
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if(!estoqueProdutoMap.isEmpty()) {
            for (Produto p: estoqueProdutoMap.values()) {
                if(p.getPreco() < menorPreco){
                    produtoMaisBarato = p;
                    menorPreco = p.getPreco();
                }
            }
        } else {
            System.out.println("Estoque vazio!");
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotal() {
        Produto produtoMaiorQuantidadeValorNoEstoque = null;
        double maiorValorTotalProdutoEstoque = 0d;
        if (!estoqueProdutoMap.isEmpty()) {
            for (Map.Entry<Long, Produto> entry : estoqueProdutoMap.entrySet()) {
                double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
                if (valorProdutoEmEstoque > maiorValorTotalProdutoEstoque) {
                    maiorValorTotalProdutoEstoque = valorProdutoEmEstoque;
                    produtoMaiorQuantidadeValorNoEstoque = entry.getValue();
                }
            }
        }
        return produtoMaiorQuantidadeValorNoEstoque;
    }

    public static void main(String[] args) {
        EstoqueProduto estoqueProduto = new EstoqueProduto();

        estoqueProduto.adicionarProduto(12312, "Livro", 30.44, 2);
        estoqueProduto.adicionarProduto(32423, "Teclado", 21.99, 1);
        estoqueProduto.adicionarProduto(43543, "Banana", 5.12, 99);

        System.out.println("\nOs items em estoque são: \n");
        estoqueProduto.exibirProdutos();

        System.out.println("\nMais caro: " + estoqueProduto.obterProdutoMaisCaro());
        System.out.println("\nMais barato: " + estoqueProduto.obterProdutoMaisBarato());
        System.out.println("\nO total será: " + estoqueProduto.calcularTotal());
        System.out.println("\nProduto com maior quantidade em valor no estoque: " + estoqueProduto.obterProdutoMaiorQuantidadeValorTotal());
    }
}
