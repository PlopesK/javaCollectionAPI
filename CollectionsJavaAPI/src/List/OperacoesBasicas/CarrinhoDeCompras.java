package List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade, String descricao) {
        Item item = new Item(nome, preco, quantidade, descricao);
        itemList.add(item);
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void verificarItems() {
        if(!itemList.isEmpty()){
            System.out.println(this.itemList);
        } else {
            System.out.println("Carrinho vazio :( \n");
        }
    }

    public void apagarItem(String nome) {
        List<Item> removerItems = new ArrayList<>();
        if(!itemList.isEmpty()){
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    removerItems.add(i);
                    System.out.println("\n ***********" + removerItems + " foi removido(a)*********** \n");
                }
            }
            itemList.removeAll(removerItems);
        } else {
            System.out.println("Sem items para remover!");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Batata", 27,  3,  "Batata, perfeita em todas as ocasiões");
        carrinhoDeCompras.adicionarItem("Maçã", 12,  20,  "Maçã, como os médicos dizem, '1 maçã por dia evita 1 visita ao médico'");
        carrinhoDeCompras.adicionarItem("Banana", 5,  50,  "Banana, hmm banana");

        carrinhoDeCompras.verificarItems();

        carrinhoDeCompras.apagarItem("Banana");

        carrinhoDeCompras.verificarItems();
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal() + '\n');
    }
}
