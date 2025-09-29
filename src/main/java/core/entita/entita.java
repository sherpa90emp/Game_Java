package core.entita;

public abstract class entita {
    protected String nome;

    public entita(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
