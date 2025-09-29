package core.nomi;

public enum NomiScheletro {
    OBLIOETERNO ("Scheletro dell’Oblio Eterno"),
    EVOCAFIAMME ("Scheletro Evocafiamme"),
    OSSARUNICHE ("Scheletro delle Ossa Runiche"),
    CUSTODEDELSIGILLO ("Scheletro Custode del Sigillo"),
    INCANTASPINA ("Scheletro Incantaspina"),
    VELOCREMISI ("Scheletro del Velo Cremisi"),
    MARCHIATODALLABISSO ("Scheletro Marchiato dall’Abisso"),
    PORTAVOCEDEIMORTI ("Scheletro Portavoce dei Morti"),
    VEGGENTEDELVUOTO ("Scheletro Veggente del Vuoto"),
    TESSIMAGIE ("Scheletro Tessimagie");

    private final String nome;

    NomiScheletro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static NomiScheletro getRandomNome() {
        NomiScheletro[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
