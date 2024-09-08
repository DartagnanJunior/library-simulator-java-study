import java.text.SimpleDateFormat;
import java.util.Date;

public class Livro {

    private Integer id;
    private String titulo;
    private String autor;
    private Boolean disponivel;
    private Date dataCadastro;
    private Date dataAtualizacao;
    private static int contadorId = 0;

    public Livro(String autor, String titulo) {
        this.id = gerarIdUnico();
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = new Date();
        this.dataAtualizacao = new Date();
    }

    private static synchronized int gerarIdUnico() {
        return ++contadorId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDataAtualizacao(Date data) {
        this.dataAtualizacao = data;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoData.format(dataAtualizacao);
        return String.format("Livro: %d - %s, %s, %s, data de atualização: %s", id, titulo, autor, disponivel, dataFormatada);
    }
}
