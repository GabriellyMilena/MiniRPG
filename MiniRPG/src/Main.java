import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static Random rng = new Random();

    public static void main(String[] args) {
        System.out.println("====== Bem vindo ao USF RPG! ======");
        System.out.println("Digite o nome do seu heroi: ");
        String nome = sc.nextLine().trim();
        System.out.println("Mago (1) ou Guerreiro (2)? ");
        int escolha = sc.nextInt();
        Heroi heroi = switch (escolha) {
            case 1 -> new Mago(nome);
            case 2 -> new Guerreiro(nome);
            default -> new Guerreiro(nome);
        };

        heroi.mostrarStatus();

        int fase = 1;
        int continua = 1;

        while (continua == 1) {
            System.out.println("====== Fase " + fase + " ======");
            int index = rng.nextInt(2); // 0 ou 1
            Heroi inimigo = fabricaInimigo(fase, index);
            System.out.println("Um inimigo apareceu! ");
            inimigo.mostrarStatus();

            while (heroi.estaVivo() && inimigo.estaVivo()) {
                heroi.atacar(inimigo);
                if (!inimigo.estaVivo()) {
                    System.out.println("Inimigo morreu!");
                } else {
                    inimigo.atacar(heroi);
                    if (!heroi.estaVivo()) System.out.println("Heroi morreu! Game Over");
                }
                System.out.println("===================");
            }

            if (heroi.estaVivo()) {
                heroi.ganharXP(inimigo.getXp());
                heroi.setVida(heroi.getVidaMax());
                fase++;
                System.out.println("Quer continuar? 1- Sim  |  2- Não");
                continua = sc.nextInt();
                continua = switch (continua) {
                    case 1 -> 1;
                    default -> 0;
                };
            } else {
                continua = 0;
            }
        }
    }

    public static Heroi fabricaInimigo(int fase, int index) {
        String[] nomes = {
                "Sombracósmico", "Fangorre", "Vermilion", "Necrofang", "Grisaldor", "Chamasombra", "Rathok", "Lúgubre", "Viperion", "Oblivion",
                "Carnívoro Sombrio", "Dracorrupto", "Fenrith", "Malévolo", "Aracnion"
        };
        int aux = rng.nextInt(nomes.length);
        Heroi inimigo;
        if (index == 1) {
            inimigo = new Guerreiro(nomes[aux], fase, fase * 50);
        } else {
            inimigo = new Mago(nomes[aux], fase, fase * 50);
        }
        return inimigo;
    }
}
