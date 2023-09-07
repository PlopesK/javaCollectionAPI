package OperacoesBasicas;

public class Item {
    String nome;
    double preco;
    int quantidade;
    String descricao;

    public Item(String nome, double preco, int quantidade, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "\nItem { \n" +
                "nome= " + nome +
                ", preco= " + preco +
                ", quantidade= " + quantidade +
                ", descricao= " + descricao + '\n' +
                '}';
    }
}
