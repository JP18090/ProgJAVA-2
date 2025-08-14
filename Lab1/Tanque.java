import java.util.Random;

public class Tanque {
    private String nome;
    private int blindagem;
    private int municao;
    private boolean vivo;

    public Tanque(String nome) {
        this.nome = nome;
        this.blindagem = 100;
        this.municao = 5;
        this.vivo = true;
    }

    public String getNome() {
        return nome;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void atirar(Tanque alvo) {
        if (!vivo) {
            System.out.println(nome + " está destruído e não pode atacar!");
            return;
        }

        if (municao > 0) {
            municao--;
            System.out.println(nome + " atirou em " + alvo.getNome() + "!");
            alvo.serAtingido();
        } else {
            System.out.println(nome + " está sem munição!");
        }
    }

    public void serAtingido() {
        int dano = new Random().nextInt(31) + 20; // Dano entre 20 e 50
        blindagem -= dano;
        System.out.println(nome + " foi atingido! Dano: " + dano + ". Blindagem restante: " + blindagem);
        if (blindagem <= 0) {
            explodir();
        }
    }

    public void explodir() {
        vivo = false;
        System.out.println(nome + " explodiu!");
    }

    public String status() {
        return nome + " - Blindagem: " + blindagem + ", Munição: " + municao + ", Vivo: " + vivo;
    }
}
