package Application;

import Liste.Liste;
import Tache.Tache;
import Utilisateur.Utilisateur;
import jdk.jshell.execution.Util;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) throws SQLException {

        Utilisateur monUti = new Utilisateur();
        System.out.println("----------------------------- ToDoList App -----------------------------");
        System.out.println("                Pour commencer veillez vous connecter(c)                  ");
        System.out.println("           Si vous n'avez pas de compte,veillez vous inscrire(i)          ");
        System.out.println("Votre choix : ");
        Scanner choix = new Scanner(System.in);
        String choa = choix.nextLine();
        if (choa.equals("c")) {
            monUti.SeConnecter();
        }
        if (choa.equals("i")) {
            monUti.Sinscrire();
        }

        String maChaine = "";
        while (!maChaine.equals("quitter")) {

        System.out.println("   Menu principale  : ");
        System.out.println("        LISTE         ");
        System.out.println("-(ajoutliste) Ajouter une liste");
        System.out.println("-(afficherliste) Afficher toute les listes");
        System.out.println("-(modifierliste) Modifier une liste");
        System.out.println("-(supprimerliste) Supprimer une liste");
        System.out.println("        TACHE       ");
        System.out.println("-(ajouttache) Ajouter une tache");
        System.out.println("-(affichertache) Afficher toutes les taches");
        System.out.println("-(modifiertache) Modifier une tache");
        System.out.println("-(supprimertache) Supprimer une tache");
        System.out.println("-(validitetache) La validité de vos taches");
        System.out.println("-(consultertache) Consulter dans quelle liste se trouve votre tache");
        System.out.println("      UTILISATEUR     ");
        System.out.println("-(modifieruti) Modifier son utilisateur");
        System.out.println("-(afficheruti) Afficher son utilisateur");
        System.out.println("       QUITTER      ");
        System.out.println("-(quitter) Quitter");


       System.out.println("Votre choix : ");
        Scanner scanner1 = new Scanner(System.in);
        maChaine = scanner1.nextLine();

            switch (maChaine) {
                case "ajoutliste":
                    Liste laListe = new Liste();
                    laListe.ValiderListe();
                    System.out.println("Vous pouvez ainsi interagir avec votre liste et ajouter des taches");
                    break;

                case "afficherliste":
                    Liste maListe = new Liste();
                    maListe.AfficherListe();
                    break;

                case "modifierliste":
                    Liste leListe = new Liste();
                    leListe.ModifierListe();
                    break;

                case "supprimerliste":
                    Liste suppListe = new Liste();
                    suppListe.SupprimerListe();
                    break;

                case "ajouttache":
                    Tache ajouTache = new Tache();
                    ajouTache.ValiderTache();
                    break;

                case "affichertache":
                    Tache deTache = new Tache();
                    deTache.AfficherTache();
                    break;

                case "modifiertache":
                    Tache feTache = new Tache();
                    feTache.ModifierTache();
                    break;

                case "supprimertache":
                    Tache faTache = new Tache();
                    faTache.SupprimerTache();
                    break;

                case "validitetache":
                    Tache geTache = new Tache();
                    geTache.ValiditeDeLaTache();
                    break;

                case "consultertache":
                    Tache neTache = new Tache();
                    neTache.tacheDansListe();
                    break;

                case "modifieruti":
                    Utilisateur moiUti = new Utilisateur();
                    moiUti.Modifier();
                    break;

                case "afficheruti":
                    Utilisateur newUti = new Utilisateur();
                    newUti.AfficherUtilisateur();
                    break;

                case "quitter":
                    return;
            }
        }
    }
}
