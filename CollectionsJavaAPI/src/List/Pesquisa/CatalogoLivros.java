package List.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int publicacao) {
        livroList.add(new Livro(titulo, autor, publicacao));
    }


    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!livroList.isEmpty()) {
            for(Livro l: livroList) {
                if(l.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisaPorIntervaloAno(int anoInicial, int anoFinal){
        List<Livro> livrosPorIntervaloAutor = new ArrayList<>();
        if(!livroList.isEmpty()) {
            for(Livro l: livroList) {
                if(l.getPublicacao() >= anoInicial && l.getPublicacao() <= anoFinal){
                    livrosPorIntervaloAutor.add(l);
                }
            }
        }
        return livrosPorIntervaloAutor;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroPorTitulo = null;
        if(!livroList.isEmpty()) {
            for(Livro l: livroList) {
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = l;
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2023);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2023);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2020);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2019);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 2022);

        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2") + "\n");
        System.out.println(catalogoLivros.pesquisaPorIntervaloAno(2019, 2022) + "\n");
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1") + "\n");
    }
}
