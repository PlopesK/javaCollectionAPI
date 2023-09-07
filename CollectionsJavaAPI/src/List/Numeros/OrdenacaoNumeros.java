package List.Numeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    //atributos
    private List<Integer> numerosList;

    //construtor
    public OrdenacaoNumeros() {
        this.numerosList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.numerosList.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAscendente = new ArrayList<>(this.numerosList);
        if (!numerosList.isEmpty()) {
            Collections.sort(numerosAscendente);
            return numerosAscendente;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosDescendente = new ArrayList<>(this.numerosList);
        if (!numerosList.isEmpty()) {
            numerosDescendente.sort(Collections.reverseOrder());
            return numerosDescendente;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirNumeros() {
        if (!numerosList.isEmpty()) {
            System.out.println(this.numerosList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(1);
        numeros.adicionarNumero(6);
        numeros.adicionarNumero(12);
        numeros.adicionarNumero(10);
        numeros.adicionarNumero(103);
        numeros.adicionarNumero(42);
        numeros.adicionarNumero(77);

        System.out.println("Números: ");
        numeros.exibirNumeros();
        System.out.println(" ");

        System.out.println("Ordem Ascendente: ");
        System.out.println(numeros.ordenarAscendente() + "\n");

        System.out.println("Ordem Descendente: ");
        System.out.println(numeros.ordenarDescendente() + "\n");

        System.out.println("Números(Ordem Padrão): ");
        numeros.exibirNumeros();
    }
}
