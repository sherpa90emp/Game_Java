package core.nomi;

public enum NomiGoblin {
    SPEZZADITA("Goblin Spezzadita"),
    MANGIACARNE("Goblin Mangiacarne"),
    STRAPPAFEGATO("Goblin Strappafegato"),
    OCCHIOGUERCIO("Goblin Occhioguercio"),
    FRACASSACRANIO("Goblin Fracassacranio"),
    BRUCIABUDELLA("Goblin Bruciabudella"),
    SPUTASANGUE("Goblin Sputasangue"),
    SPACCADENTI("Goblin Spaccadenti"),
    CAVATESTE("Goblin Cavateste"),
    ZANNAVELENOSA("Goblin Zannavelenosa");

    private final String nome;

    NomiGoblin(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static NomiGoblin getRandomNome() {
        NomiGoblin[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
