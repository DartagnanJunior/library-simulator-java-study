import java.util.Date;

public class Livro {

    private Integer id;
    private String titulo;
    private String autor;
    private Boolean disponivel;
    private Date dataCadastro;
    private Date dataAtualizacao;
    private static int contadorId = 0;

    public Livro( String autor, String titulo) {
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Livro{" +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", disponivel=" + disponivel +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
