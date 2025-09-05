public class Mago extends Heroi {

    public Mago(String nome) {
        super(nome, 200, 25, 18);
    }

    public Mago(String nome, int nivel, int xp) {
        super(nome, (int)(200 * nivel * 1.2), (int)(25 * nivel * 1.2), (int)(18 * nivel * 1.2));
        setNivel(nivel);
        setXp(xp);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println("Ataque do mago " + getNome() + "!");
        int dano;
        dano = rng.nextInt(getAtaque() / 2, getAtaque() * 2) - (alvo.getDefesa() / 2);
        if (dano < 1) dano = 1;
        alvo.receberDano(dano);
        mostrarAtaque(alvo, dano);
    }
}
