package ps2.clinica_app.model;

import jakarta.persistence.*;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;

    public Paciente() {}

    public Paciente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
    }
}
