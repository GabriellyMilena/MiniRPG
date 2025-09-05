public abstract class Heroi extends Personagem {
    private int xpProxNivel;

    public Heroi(String nome, int vidaMax, int ataque, int defesa) {
        super(nome, vidaMax, ataque, defesa);
        this.xpProxNivel = 100;
    }

    public void ganharXP(int quantidade) {
        setXp(getXp() + quantidade);
        while (getXp() >= (xpProxNivel * getNivel())) {
            subirNivel();
            setXp(getXp() - (xpProxNivel * getNivel()));
        }
    }

    public void subirNivel() {
        setNivel(getNivel() + 1);
        setVidaMax(getVidaMax() + 8);
        setVida(getVidaMax());
        setAtaque(getAtaque() + 5);
        setDefesa(getDefesa() + 5);

        System.out.println(this.getNome() + " || Subiu de nível!");
        System.out.println("|| Status:");
        System.out.println("|| Nível: " + getNivel());
        System.out.println("|| Vida máxima: " + getVidaMax());
        System.out.println("|| Ataque: " + getAtaque());
        System.out.println("|| Defesa: " + getDefesa());
    }

    public void mostrarAtaque(Personagem alvo, int dano) {
        System.out.println("O " + getNome() + " causou " + dano + " pontos de dano em " + alvo.getNome() + "!");
        if (!alvo.estaVivo()) {
            System.out.println("E causou a morte de " + alvo.getNome());
        }
        System.out.println("O " + alvo.getNome() + " está com " + alvo.getVida() + "/" + alvo.getVidaMax());
    }

    public void mostrarStatus() {
        System.out.println("=====================");
        System.out.println(this.getNome() + "! Seus status:");
        System.out.println("Vida: " + this.getVida() + "/" + this.getVidaMax());
        System.out.println("Ataque: " + this.getAtaque());
        System.out.println("Defesa: " + this.getDefesa());
        System.out.println("=====================");
    }
}
