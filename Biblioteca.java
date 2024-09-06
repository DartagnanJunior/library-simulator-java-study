import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
//    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarAutores(Autor... autores) {
        for (Autor a : autores) {
            this.autores.add(a);
        }
    }

    public void adicionarLivros(Livro... livros) {
        for (Livro l : livros) {
            this.livros.add(l);
        }
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public List<Autor> listarAutores() {
        return autores;
    }
}
