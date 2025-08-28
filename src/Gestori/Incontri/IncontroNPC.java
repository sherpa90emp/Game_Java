package Gestori.Incontri;

import Entita.NPC.Fabbro;
import Entita.NPC.Guaritore;
import Entita.NPC.Mercante;
import Entita.NPC.NPC;
import Entita.Player.Eroe;
import Interface.Incontro;
import Oggetti.Oggetto;
import Tipi.TipoNPC;
import Tipi.TipoOggetti;

import java.util.InputMismatchException;
import java.util.Scanner;


public class IncontroNPC implements Incontro<TipoNPC> {

    private NPC npcGenerato;

    @Override
    public void esegui(Eroe eroe, TipoNPC tipo) {

    }

    @Override
    public boolean esegui(Eroe eroe, TipoNPC tipoNPC, Scanner scanner) {
        switch (tipoNPC) {
            case MERCANTE -> {
                Mercante mercante = new Mercante();
                System.out.println("Si avvicina a te una persona guardinga e ti sussurra: \n'Shhh.. Ehii, si si dico a te! \nSono il mercante " + mercante.getNome() + " e vengo dalla terre aride del sud!'");
                System.out.println(mercante.getNome() + " ti propone alcuni oggetti che potrebbero fare al caso tuo!");

                boolean continua = true;
                while (continua) {
                    System.out.println(mercante.stampaOggettiVendibili());
                    System.out.println("Quale oggetto desideri comprare?\n0 - Per salutare il mercante ed andartene.");
                    try {
                        byte input = scanner.nextByte();
                        scanner.nextLine();
                        switch (input) {
                            case 1 -> {
                                Oggetto pozione = null;
                                for (Oggetto o : mercante.getOggettiVendibili()) {
                                    if (o.getTipoOggetto() == TipoOggetti.CONSUMABILE) {
                                        pozione = o;
                                        break;
                                    }
                                }
                                if (pozione == null || pozione.getQuantita() <= 0) {
                                    System.out.println("Il mercante ha finito le pozioni!");
                                    break;
                                }
                                System.out.println("Il mercante ti porge la pozione e tu le monete.");
                                pozione.setQuantita(pozione.getQuantita() - 1);
                                for (Oggetto o : eroe.getInventario()) {
                                    if (o.getTipoOggetto() == TipoOggetti.CONSUMABILE) {
                                        int pozioniPrimaAcquisto = o.getQuantita();
                                        o.setQuantita(o.getQuantita() + 1);
                                        System.out.println(o.getNome() + ": " + pozioniPrimaAcquisto + " -> " + o.getQuantita());
                                    }
                                    if (o.getTipoOggetto() == TipoOggetti.VALUTA) {
                                        int monetaPrimaAcquisto = o.getQuantita();
                                        o.setQuantita(o.getQuantita() - 15);
                                        System.out.println("Hai speso " + (monetaPrimaAcquisto - o.getQuantita()) + " monete!");
                                        System.out.println(o.getNome() + ": " + monetaPrimaAcquisto + " -> " + o.getQuantita());
                                    }
                                }
                            }
                            case 2 -> {
                                Oggetto bombe = null;
                                for (Oggetto o : mercante.getOggettiVendibili()) {
                                    if (o.getTipoOggetto() == TipoOggetti.ESPLOSIVO) {
                                        bombe = o;
                                        break;
                                    }
                                }
                                if (bombe == null || bombe.getQuantita() <= 0) {
                                    System.out.println("Il mercante ha finito le bombe!");
                                    break;
                                }
                                System.out.println("Il mercante ti porge la bombetta e tu le monete.");
                                bombe.setQuantita(bombe.getQuantita() - 1);
                                for (Oggetto o : eroe.getInventario()) {
                                    if (o.getTipoOggetto() == TipoOggetti.ESPLOSIVO) {
                                        int bombePrimaAcquisto = o.getQuantita();
                                        o.setQuantita(o.getQuantita() + 1);
                                        System.out.println(o.getNome() + ": " + bombePrimaAcquisto + " -> " + o.getQuantita());
                                    }
                                    if (o.getTipoOggetto() == TipoOggetti.VALUTA) {
                                        int monetaPrimaAcquisto = o.getQuantita();
                                        o.setQuantita(o.getQuantita() - 15);
                                        System.out.println("Hai speso " + (monetaPrimaAcquisto - o.getQuantita()) + " monete!");
                                        System.out.println(o.getNome() + ": " + monetaPrimaAcquisto + " -> " + o.getQuantita());
                                    }
                                }
                            }
                            case 0 -> {
                                System.out.println("Ringrazi il mercante delle offerte e prosegui per il tuo cammino!");
                                continua = false;
                            }
                            default -> System.out.println("Numero non valido, inserisci un numero da 1 a 4!");
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine();
                        System.out.println("Input non valido!");
                    }
                }
            }
            case GUARITORE -> {
                Guaritore guaritore = new Guaritore();
                System.out.println("Si avvicina a te una persona che sembra brillare di luce propria e con voce avvolgente ti dice:\n'Salve viandante, mi chiamo " + guaritore.getNome() + " e sono un guaritore.\nIl nostro incontro è finalmente giunto!'");
                guaritore.curaEAumentoHp(eroe);
            }
            case FABBRO -> {
                Fabbro fabbro = new Fabbro();
                System.out.println("Ti sembra che ci sia qualcuno, ma guardandoti intorno non vedi niente.\nSubito dopo senti una voce: 'Non fare finta di non vedermi testa di capra!'\nAbbassi lo sguardo e vedi un nano con martello più grande di lui!\nIl nano borbottando si presenta: 'Sono " + fabbro.getNome() + ", il mastro fabbro!'");
                fabbro.potenziamentoDifAtt(eroe);
            }
        }
        return false;
    }
}