package Nomi;

public enum NomiPozione {
    CURAPICCOLA ("Pozione di cura piccola"),
    CURAGRANDE ("Pozione di cura grande");


    private final String nome;

    NomiPozione(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
