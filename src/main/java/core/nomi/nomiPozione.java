package core.nomi;

public enum nomiPozione {
    CURAPICCOLA ("Pozione di cura piccola"),
    CURAGRANDE ("Pozione di cura grande");


    private final String nome;

    nomiPozione(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
