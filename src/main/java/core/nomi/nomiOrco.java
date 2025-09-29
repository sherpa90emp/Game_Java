package core.nomi;

public enum nomiOrco {
    SPACCACRANI ("Orco Spaccacrani"),
    DENTIGROSSI ("Orco Dentigrossi"),
    MARTELLATORE ("Orco Martellatore"),
    SCORTICATORE ("Orco Scorticatore"),
    ZANNEPOSSENTI ("Orco Zannepossenti"),
    CORNOFERREO ("Orco Cornoferreo"),
    FAUCILACERANTI ("Orco Faucilaceranti"),
    SGIGNAZZATORE ("Orco Sghignazzante"),
    SVENTRATORE ("Orco Sventratore");

    private final String nome;

    nomiOrco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static nomiOrco getRandomNome() {
        nomiOrco[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
