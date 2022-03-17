package Application;

import Liste.Liste;
import Tache.Tache;
import Utilisateur.Utilisateur;
import jdk.jshell.execution.Util;

import java.sql.SQLException;
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

        System.out.println("   Menu principale  : ");
        System.out.println("-(lister) Lister tous les utilisateurs");
        System.out.println("-(rechercher) Rechercher des utilisateurs");
        System.out.println("-(ajouter) Ajouter un utilisateurs");
        System.out.println("-(selectionner) Selectionner un utilisateurs");
        System.out.println("-(deconnecter) Se deconnecter");
        System.out.println("-(quitter) Quitter");

        System.out.println("Votre choix : ");
        Scanner scanner1 = new Scanner(System.in);
        String maChaine = scanner1.nextLine();


        switch (maChaine) {
            case "lister":

                monUti.
        }
    }
}