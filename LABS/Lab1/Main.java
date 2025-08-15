import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Perguntar quantidade de tanques
        int numTanques;
        do {
            System.out.print("Quantos tanques deseja criar? (2 a 10): ");
            numTanques = sc.nextInt();
        } while (numTanques < 2 || numTanques > 10);

        Tanque[] base = new Tanque[numTanques];

        // Criar tanques
        for (int i = 0; i < numTanques; i++) {
            System.out.print("Digite o nome do tanque " + (i + 1) + ": ");
            String nome = sc.next();
            base[i] = new Tanque(nome);
        }

        int rodada = 1;

        // Simulação até restar apenas 1 tanque vivo
        while (contarVivos(base) > 1) {
            System.out.println("\n=== Rodada " + rodada + " ===");

            // Sorteio do atacante
            int attackerIndex;
            do {
                attackerIndex = rand.nextInt(base.length);
            } while (!base[attackerIndex].isVivo());

            // Sorteio do alvo (diferente do atacante)
            int targetIndex;
            do {
                targetIndex = rand.nextInt(base.length);
            } while (targetIndex == attackerIndex || !base[targetIndex].isVivo());

            Tanque atacante = base[attackerIndex];
            Tanque alvo = base[targetIndex];

            System.out.println("\n== Novo ataque ==");
            atacante.atirar(alvo);

            // Mostrar status geral
            System.out.println("\nStatus geral:");
            for (Tanque t : base) {
                System.out.println(t.status());
            }

            rodada++;
        }

        // Resultado final
        int idxVencedor = encontrarVencedor(base);
        if (idxVencedor != -1) {
            System.out.println("\n🏆 O vencedor é " + base[idxVencedor].getNome() + "!");
        } else {
            System.out.println("\nTodos os tanques foram destruídos!");
        }

        sc.close();
    }

    // Métodos auxiliares
    private static int contarVivos(Tanque[] base) {
        int vivos = 0;
        for (Tanque t : base) {
            if (t.isVivo()) vivos++;
        }
        return vivos;
    }

    private static int encontrarVencedor(Tanque[] base) {
        for (int i = 0; i < base.length; i++) {
            if (base[i].isVivo()) {
                return i;
            }
        }
        return -1;
    }
}
