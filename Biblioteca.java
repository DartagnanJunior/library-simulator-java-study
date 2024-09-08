import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
//    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarAutor(Autor a) {
        this.autores.add(a);
    }

    public void adicionarLivro(Livro l) {
        this.livros.add(l);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public List<Autor> listarAutores() {
        return autores;
    }

    public static Autor encontrarAutorPorId(List<Autor> autores, int id) {
        Optional<Autor> autorEncontrado = autores.stream()
                .filter(autor -> autor.getId() == id)
                .findFirst();
        return autorEncontrado.orElse(null);
    }

    public List<Livro> listarLivrosDisponiveis() {
        return livros.stream()
                .filter(Livro::getDisponivel)
                .collect(Collectors.toList());
    }

}
