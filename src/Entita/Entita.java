package Entita;

public abstract class Entita {
    protected String nome;

    public Entita(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
