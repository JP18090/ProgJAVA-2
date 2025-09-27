package ps2.clinica_app.model;

import jakarta.persistence.*;

@Entity
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String data;

    public Prontuario() {}

    public Prontuario(String descricao, String data) {
        this.descricao = descricao;
        this.data = data;
    }

    public Long getId() { return id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    @Override
    public String toString() {
        return "Prontuario [id=" + id + ", descricao=" + descricao + ", data=" + data + "]";
    }
}
