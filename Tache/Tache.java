package Tache;

import Liste.Liste;

import java.sql.*;
import java.util.Scanner;

public class Tache {
    private String nom;
    private String type;
    private String note;
    private String date;
    private String validite;
    private String personne;
    private String difficulte;

    public Tache (String nom,String type,String note,String date,String difficulte){
        this.nom=nom;
        this.type=type;
        this.note=note;
        this.date=date;
        this.difficulte=difficulte;
    }


    public void ValiderTache() throws SQLException {
        System.out.println("Souhaitez-vous egalement ajouter une personne ?(o/n)");
        Scanner reponse = new Scanner(System.in);
        String rep = reponse.nextLine();
        if (rep.equals("o")){
            System.out.println("Personne : ");
            personne = reponse.nextLine();
        }else{
            personne = null;
        }

        Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC","root","");
        PreparedStatement ajouter = maConnection.prepareStatement("INSERT INTO tache(nom,type,note,date,validite,personne,difficulte)" + "VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ajouter.setString(1, this.nom);
        ajouter.setString(2, this.type);
        ajouter.setString(3, this.note);
        ajouter.setString(4, this.date);
        ajouter.setString(5, String.valueOf(validite));
        ajouter.setString(6, personne);
        ajouter.setString(7, this.difficulte);
        ajouter.executeUpdate();

    }


    public void ModifierTache() throws SQLException {
        String quitter = "m";
        while (quitter.equals("m")) {
            System.out.println("Quel tache voulez-vous modifier ?(l'id)");
            System.out.println("Pour consulter les id veulliez choisir 'afficher tache'");
            Scanner oe = new Scanner(System.in);
            int uid = oe.nextInt();
            System.out.println("Que voulez vous modifier (tout/nom/type/note/date/personne/difficulte)?");
            Scanner repondre = new Scanner(System.in);
            String reponse = repondre.nextLine();
            if (reponse.equals("tout")) {
                Scanner update = new Scanner(System.in);
                System.out.println("Saisir le nouveau nom : ");
                String upnom = update.nextLine();
                System.out.println("Saisir le nouveau type : ");
                String uptype = update.nextLine();
                System.out.println("Saisir la nouvelle note : ");
                String upnote = update.nextLine();
                System.out.println("Saisir la nouvelle date : ");
                String udate = update.nextLine();
                System.out.println("Modifier la personne : ");
                String uppersonne = update.nextLine();
                System.out.println("Saisir la nouvelle difficulte : ");
                String updifficulte = update.nextLine();
                Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
                PreparedStatement modifier = maConnection.prepareStatement("Update tache set nom = ?,type = ?,note = ?,date = ?,personne = ?,difficulte = ? WHERE id_tache = ?");
                modifier.setString(1, upnom);
                modifier.setString(2,uptype);
                modifier.setString(3, upnote);
                modifier.setString(4, udate);
                modifier.setString(5, uppersonne);
                modifier.setString(6, updifficulte);
                modifier.setInt(7, uid);
                modifier.executeUpdate();
                System.out.println("Modifiée");
                System.out.println("Voulez vous encore modifier ou quitter (m/q)");
                Scanner rer = new Scanner(System.in);
                quitter = rer.nextLine();

            }
            if (reponse.equals("nom")) {
                System.out.println("Saisir le nouveau nom : ");
                Scanner nom = new Scanner(System.in);
                String upnom = nom.nextLine();
                Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
                PreparedStatement modifier = maConnection.prepareStatement("Update tache set nom = ? WHERE id_tache = ?");
                modifier.setString(1, upnom);
                modifier.setInt(2, uid);
                modifier.executeUpdate();
                System.out.println("Modifiée");
                System.out.println("Voulez vous encore modifier ou quitter (m/q)");
                Scanner rera = new Scanner(System.in);
                quitter = rera.nextLine();
            }
            if (reponse.equals("type")) {
                System.out.println("Saisir le nouveau type : ");
                Scanner type = new Scanner(System.in);
                String uptype = type.nextLine();
                Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
                PreparedStatement modifier = maConnection.prepareStatement("Update tache set type = ? WHERE id_tache = ?");
                modifier.setString(1, uptype);
                modifier.setInt(2, uid);
                modifier.executeUpdate();
                System.out.println("Modifiée");
                System.out.println("Voulez vous encore modifier ou quitter (m/q)");
                Scanner rern = new Scanner(System.in);
                quitter = rern.nextLine();
            }
            if (reponse.equals("note")) {
                System.out.println("Saisir la nouvelle note : ");
                Scanner note = new Scanner(System.in);
                String upnote = note.nextLine();
                Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
                PreparedStatement modifier = maConnection.prepareStatement("Update tache set note = ? WHERE id_tache = ?");
                modifier.setString(1, upnote);
                modifier.setInt(2, uid);
                modifier.executeUpdate();
                System.out.println("Modifiée");
                System.out.println("Voulez vous encore modifier ou quitter (m/q)");
                Scanner rerb = new Scanner(System.in);
                quitter = rerb.nextLine();
            }
            if (reponse.equals("date")) {
                System.out.println("Saisir la nouvelle date : ");
                Scanner date = new Scanner(System.in);
                String update = date.nextLine();
                Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
                PreparedStatement modifier = maConnection.prepareStatement("Update tache set date = ? WHERE id_tache = ?");
                modifier.setString(1, update);
                modifier.setInt(2, uid);
                modifier.executeUpdate();
                System.out.println("Modifiée");
                System.out.println("Voulez vous encore modifier ou quitter (m/q)");
                Scanner rerc = new Scanner(System.in);
                quitter = rerc.nextLine();
            }
            if (reponse.equals("personne")) {
                System.out.println("Saisir la nouvelle personne : ");
                Scanner personne = new Scanner(System.in);
                String uppersonne = personne.nextLine();
                Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
                PreparedStatement modifier = maConnection.prepareStatement("Update tache set personne = ? WHERE id_tache = ?");
                modifier.setString(1, uppersonne);
                modifier.setInt(2, uid);
                modifier.executeUpdate();
                System.out.println("Modifiée");
                System.out.println("Voulez vous encore modifier ou quitter (m/q)");
                Scanner rerd = new Scanner(System.in);
                quitter = rerd.nextLine();
            }
            if (reponse.equals("difficulte")) {
                int number = 0;
                System.out.println("Choissisez une difficulté ");
                System.out.println("1) facile");
                System.out.println("2) moyen");
                System.out.println("3) difficile");
                Scanner difficulte = new Scanner(System.in);
                number = difficulte.nextInt();
                if (number == 1) {
                    String updifficulte = "facile";
                    Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
                    PreparedStatement modifier = maConnection.prepareStatement("Update tache set difficulte = ? WHERE id_tache = ?");
                    modifier.setString(1, updifficulte);
                    modifier.setInt(2, uid);
                    modifier.executeUpdate();
                    System.out.println("Modifiée");
                    System.out.println("Voulez vous encore modifier ou quitter (m/q)");
                    Scanner rere = new Scanner(System.in);
                    quitter = rere.nextLine();
                }
                if (number == 2) {
                    String updifficulte = "moyen";
                    Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
                    PreparedStatement modifier = maConnection.prepareStatement("Update tache set difficulte = ? WHERE id_tache = ?");
                    modifier.setString(1, updifficulte);
                    modifier.setInt(2, uid);
                    modifier.executeUpdate();
                    System.out.println("Modifiée");
                    System.out.println("Voulez vous encore modifier ou quitter (m/q)");
                    Scanner rere = new Scanner(System.in);
                    quitter = rere.nextLine();
                }
                if (number == 3) {
                    String updifficulte = "difficile";
                    Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
                    PreparedStatement modifier = maConnection.prepareStatement("Update tache set difficulte = ? WHERE id_tache = ?");
                    modifier.setString(1, updifficulte);
                    modifier.setInt(2, uid);
                    modifier.executeUpdate();
                    System.out.println("Modifiée");
                    System.out.println("Voulez vous encore modifier ou quitter (m/q)");
                    Scanner rere = new Scanner(System.in);
                    quitter = rere.nextLine();
                }

            }
            if (quitter.equals("m")){
                System.out.println("Reessayer");
            }
            if (quitter.equals("q")){
                System.out.println("A bientot");
            }
        }
    }





    public void SupprimerTache() throws SQLException {
        System.out.println("Quelle tache voulez-vous supprimer ?(l'id)");
        System.out.println("Pour consulter les id veulliez choisir 'afficher'");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC","root","");
        PreparedStatement modifier = maConnection.prepareStatement("DELETE FROM tache WHERE id_tache = ?");
        modifier.setString(1, String.valueOf(id));
        modifier.executeUpdate();
    }

    public void AfficherTache() throws SQLException {
        Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC","root","");
        PreparedStatement requeteSelect = maConnection.prepareStatement("SELECT * FROM tache");
        ResultSet monResultat = requeteSelect.executeQuery();

        while (monResultat.next()) {
            System.out.println(monResultat.getInt("id_tache") + " - " + monResultat.getString("nom") + " - " + monResultat.getString("type")+  " - " + monResultat.getString("note")+ " - " + monResultat.getString("date")+ " - " + monResultat.getString("difficulte")+ " - " + monResultat.getString("validite")+ " - " + monResultat.getString("personne"));
        }

    }

    public void ValiditeDeLaTache() throws SQLException {
        System.out.println("Quel tache voulez vous valide? (id)");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Cette tache est-elle effectué,en cours ou à decaler (effectue/encours/decaler)");
        Scanner sc = new Scanner(System.in);
        String reponses = sc.nextLine();
        if (reponses.equals("effectue")){
            validite = "Effectue";
            Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
            PreparedStatement modifier = maConnection.prepareStatement("Update tache set validite = ? WHERE id_tache = ?");
            modifier.setString(1, validite);
            modifier.setInt(2, id);
            modifier.executeUpdate();
            System.out.println("Modifiée");
            System.out.println("Souhaitez vous supprimer cette tache ducoup?(o/n)");
            Scanner supp = new Scanner(System.in);
            String supresion = supp.nextLine();
            if (supresion.equals("o")){
                Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC","root","");
                PreparedStatement supprimer = maConnection.prepareStatement("DELETE FROM tache WHERE Id_tache = ?");
                supprimer.setInt(1, id);
                supprimer.executeUpdate();
                System.out.println("Supprimée");
            }
            if(supresion.equals("n")){
                System.out.println("Ok");
            }

        }
        if (reponses.equals("encours")){
            validite = "En cours";
            Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
            PreparedStatement modifier = maConnection.prepareStatement("Update tache set validite = ? WHERE id_tache = ?");
            modifier.setString(1, validite);
            modifier.setInt(2, id);
            modifier.executeUpdate();
            System.out.println("Modifiée");
        }
        if (reponses.equals("decaler")){
            validite = "encours";
            System.out.println("A quelle date souhaitez vous decaler votre tache ?");
            Scanner datt = new Scanner(System.in);
            String newdate = datt.nextLine();
            Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
            PreparedStatement modifier = maConnection.prepareStatement("Update tache set validite = ?,date = ? WHERE id_tache = ?");
            modifier.setString(1, validite);
            modifier.setString(2,newdate);
            modifier.setInt(3, id);
            modifier.executeUpdate();
            System.out.println("Modifiée");
        }


    }



}
