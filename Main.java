import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Evoluir para receber autores e livros dinamico

        Autor georgeMartin = new Autor(3, "George R.R. Martin", new Date());
        Autor agathaChristie = new Autor(4, "Agatha Christie", new Date());
        Autor isaacAsimov = new Autor(5, "Isaac Asimov", new Date());
        Autor stephenKing = new Autor(6, "Stephen King", new Date());

        biblioteca.adicionarAutores(georgeMartin, agathaChristie, isaacAsimov, stephenKing);

        Livro livro1 = new Livro(1, georgeMartin.getNome(), "A Guerra dos Tronos");
        Livro livro2 = new Livro(2, georgeMartin.getNome(), "A Fúria dos Reis");
        Livro livro3 = new Livro(3, agathaChristie.getNome(), "Assassinato no Expresso do Oriente");
        Livro livro4 = new Livro(4, agathaChristie.getNome(), "O Misterioso Caso de Styles");
        Livro livro5 = new Livro(5, isaacAsimov.getNome(), "Fundação");
        Livro livro6 = new Livro(6, isaacAsimov.getNome(), "Eu, Robô");
        Livro livro7 = new Livro(7, stephenKing.getNome(), "O Iluminado");
        Livro livro8 = new Livro(8, stephenKing.getNome(), "It: A Coisa");

        biblioteca.adicionarLivros(livro1, livro2, livro3, livro4, livro5, livro6, livro7, livro8);

        var autores = biblioteca.listarAutores();
        var livros = biblioteca.listarLivros();
        System.out.printf("Autores: " );
        for (Autor a : autores) {
            System.out.println(a.getNome());
        }
        System.out.printf("Livros: ");
        for (Livro l : livros) {
            System.out.println(l.getTitulo());
        }
    }
}
