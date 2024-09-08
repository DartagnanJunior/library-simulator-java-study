import java.text.SimpleDateFormat;
import java.util.Date;

public class Autor {
    private Integer id;
    private String nome;
    private Date dataNascimento;
    private static int contadorId = 0;

    public Autor(String nome, Date dataNascimento) {
        this.id = gerarIdUnico();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    private static synchronized int gerarIdUnico() {
        return ++contadorId;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoData.format(dataNascimento);
        return String.format("Autor: %d - %s, %s", id, nome, dataFormatada);
    }
}
