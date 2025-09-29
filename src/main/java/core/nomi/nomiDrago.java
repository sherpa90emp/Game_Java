package core.nomi;

public enum nomiDrago {
    INFERNALE ("Drago Infernale di Fuoco"),
    OSCURO ("Drago Oscuro di Ghiaccio"),
    SELVAGGIO ("Drago Selvaggio di Vento"),
    ANTICO ("Drago Antico di Terra"),
    IMPETUOSO ("Drago Impetuoso di Fulmine"),
    SPETTRALE ("Drago Spettrale di Nebbia"),
    FEROCE ("Drago Feroce di Lava"),
    MALEDETTO ("Drago Maledetto degli Inferi"),
    VELENOSO ("Drago Velenoso di Ombra"),
    GLACIALE ("Drago Glaciale della Rovina");

    private final String nome;

    nomiDrago(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static nomiDrago getRandomNome() {
        nomiDrago[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
