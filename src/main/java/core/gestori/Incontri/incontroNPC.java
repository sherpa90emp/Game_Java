package core.gestori.Incontri;

import controller.inputPort;
import core.entita.NPC.fabbro;
import core.entita.NPC.guaritore;
import core.entita.NPC.mercante;
import core.entita.NPC.npc;
import core.entita.Player.eroe;
import core.interfacce.incontro;
import core.oggetti.oggetto;
import core.tipi.TipoNPC;
import core.tipi.TipoOggetti;

import  java.util.InputMismatchException;


public class incontroNPC implements incontro<TipoNPC> {

    private npc npcGenerato;

    @Override
    public void esegui(eroe eroe, TipoNPC tipo) {

    }

    @Override
    public boolean esegui(eroe eroe, TipoNPC tipoNPC, inputPort<String> input) {
        switch (tipoNPC) {
            case MERCANTE -> {
                mercante mercante = new mercante();
                System.out.println("Si avvicina a te una persona guardinga e ti sussurra: \n'Shhh.. Ehii, si si dico a te! \nSono il mercante " + mercante.getNome() + " e vengo dalla terre aride del sud!'");
                System.out.println(mercante.getNome() + " ti propone alcuni core.oggetti che potrebbero fare al caso tuo!");

                boolean continua = true;
                while (continua) {
                    System.out.println(mercante.stampaOggettiVendibili());
                    System.out.println("Quale oggetto desideri comprare?\n0 - Per salutare il mercante ed andartene.");
                    try {
                        byte scelta = Byte.parseByte(input.getInput());
                        switch (scelta) {
                            case 1 -> {
                                oggetto pozione = null;
                                for (oggetto o : mercante.getOggettiVendibili()) {
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
                                for (oggetto o : eroe.getInventario()) {
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
                                oggetto bombe = null;
                                for (oggetto o : mercante.getOggettiVendibili()) {
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
                                for (oggetto o : eroe.getInventario()) {
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
                            default -> System.out.println("Numero non valido, inserisci un numero da 0 a 2!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input non valido!");
                    }
                }
            }
            case GUARITORE -> {
                guaritore guaritore = new guaritore();
                System.out.println("Si avvicina a te una persona che sembra brillare di luce propria e con voce avvolgente ti dice:\n'Salve viandante, mi chiamo " + guaritore.getNome() + " e sono un guaritore.\nIl nostro incontro è finalmente giunto!'");
                guaritore.curaEAumentoHp(eroe);
            }
            case FABBRO -> {
                fabbro fabbro = new fabbro();
                System.out.println("Ti sembra che ci sia qualcuno, ma guardandoti intorno non vedi niente.\nSubito dopo senti una voce: 'Non fare finta di non vedermi testa di capra!'\nAbbassi lo sguardo e vedi un nano con martello più grande di lui!\nIl nano borbottando si presenta: 'Sono " + fabbro.getNome() + ", il mastro fabbro!'");
                fabbro.potenziamentoDifAtt(eroe);
            }
        }
        return false;
    }
}