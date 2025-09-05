import java.util.Random;

public abstract class Personagem {
    private String nome;
    private int nivel;
    private int vidaMax;
    private int vida;
    private int ataque;
    private int defesa;
    private int xp;

    protected Random rng = new Random();

    public Personagem(String nome, int vidaMax, int ataque, int defesa) {
        this.nome = nome;
        this.vidaMax = vidaMax;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nivel = 1;
        this.vida = vidaMax;
        this.xp = 0;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public int getVidaMax() { return vidaMax; }
    public void setVidaMax(int vidaMax) { this.vidaMax = vidaMax; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    public int getDefesa() { return defesa; }
    public void setDefesa(int defesa) { this.defesa = defesa; }

    public int getXp() { return xp; }
    public void setXp(int xp) { this.xp = xp; }

    public boolean estaVivo() { return vida > 0; }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (vida < 0) vida = 0;
    }

    public abstract void atacar(Personagem alvo);
}
