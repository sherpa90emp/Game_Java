package core.nomi;

public enum nomiGoblin {
    SPEZZADITA ("Goblin Spezzadita"),
    MANGIACARNE ("Goblin Mangiacarne"),
    STRAPPAFEGATO ("Goblin Strappafegato"),
    OCCHIOGUERCIO ("Goblin Occhioguercio"),
    FRACASSACRANIO ("Goblin Fracassacranio"),
    BRUCIABUDELLA ("Goblin Bruciabudella"),
    SPUTASANGUE ("Goblin Sputasangue"),
    SPACCADENTI ("Goblin Spaccadenti"),
    CAVATESTE ("Goblin Cavateste"),
    ZANNAVELENOSA ("Goblin Zannavelenosa");

    private final String nome;

    nomiGoblin(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static nomiGoblin getRandomNome() {
        nomiGoblin[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
