package core.gestori;

import core.entita.Player.elfo;
import core.entita.Player.eroe;
import core.entita.Player.guerriero;
import core.entita.Player.mago;

import  java.util.List;

public class gestoreFineGioco {

    public static void morteEroe(eroe eroe) {
        if (eroe.isDead()) {
            System.out.println("\n *** GAME OVER ***");
            System.out.println("Il tuo eroe è morto ma è comunque stata un'avventura magnifica!");
            System.out.println("Il tuo eroe: ");
            System.out.println(eroe.getNome() + ", " + classeEroe(eroe));
            System.out.println("I nemici che hai sconfitto in battaglia: ");
            List<String> mostriUccisi = eroe.getMostriUccisi();
            if (mostriUccisi.isEmpty()) {
                System.out.println("Nessun mostro ucciso, ma probabilmente hai camminato molto!");
            } else {
                System.out.println("Hai sconfitto un totale di: " + mostriUccisi.size() + " mostri!");
                for (String nome : mostriUccisi) {
                    System.out.println("- " + nome);
                }
            }
            System.out.println("Non demordere, ti aspetto per un'altra avventura! A presto!");
            System.exit(0);
        }
    }

    public static void vittoriaEroe(eroe eroe) {
        System.out.println("\n *** FINE ***");
        System.out.println("Congratulazioni hai sconfitto il drago! Che avventura fantastica!");
        System.out.println("Il tuo eroe: ");
        System.out.println(eroe.getNome() + ", " + classeEroe(eroe));
        System.out.println("I nemici che hai sconfitto in battaglia: ");
        List<String> mostriUccisi = eroe.getMostriUccisi();
        if (mostriUccisi.isEmpty()) {
            System.out.println("Nessun mostro ucciso, ma probabilmente hai camminato molto!");
        } else {
            System.out.println("Hai sconfitto un totale di: " + mostriUccisi.size() + " mostri!");
            for (String nome : mostriUccisi) {
                System.out.println("- " + nome);
            }
        }
        System.out.println("Ti aspetto per un'altra avventura! A presto!");
        System.exit(0);
    }

    public static String classeEroe(eroe eroe) {
        if (eroe instanceof guerriero) return  "Guerriero";
        if (eroe instanceof elfo) return  "Elfo";
        if (eroe instanceof mago) return  "Mago";
        return "Sconosciuta";
    }
}
