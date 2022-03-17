package Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Utilisateur {
    private String nom_utilisateur;
    private String mdp;


    public Utilisateur() {
        this.nom_utilisateur = nom_utilisateur;
        this.mdp = mdp;

    }

    public void SeConnecter() throws SQLException {
        boolean estConnecte = false;

        while (!estConnecte) {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Veillez vous connecter");
            System.out.println("Nom d'utilisateur :");
            nom_utilisateur = scanner.nextLine();
            System.out.println("Mot de passe :");
            mdp = scanner.nextLine();

            try (PreparedStatement requete = cnx.prepareStatement("SELECT * FROM utilisateur where nom_utilisateur=? and mdp=?")) {
                requete.setString(1, nom_utilisateur);
                requete.setString(2, mdp);
                ResultSet rs = requete.executeQuery();

                if (rs.next()) {
                    System.out.println("Vous etes connecte, bienvenue");
                    estConnecte = true;
                } else {
                    System.out.println("Il se peut que votre nom d'utilisateur ou mot de passe soit incorrect");
                    System.out.println("Souhaitez vous reessayer ? (oui)");
                    System.out.println("En cas d'oublie de nom d'utilisateur/mdp saisissez (oublie) ");
                    Scanner oublie = new Scanner(System.in);
                    String repp = oublie.nextLine();
                    if (repp.equals("oublie")){
                        System.out.println("Question de sécurité : Dans quelle ville vos parents se sont-ils rencontrés ?");
                        Scanner securite = new Scanner(System.in);
                        String questiondesec = securite.nextLine();
                        Connection connnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
                        try (PreparedStatement req = cnx.prepareStatement("SELECT * FROM utilisateur WHERE question_securite = ?")) {
                            req.setString(1, questiondesec);
                            ResultSet reqq = req.executeQuery();
                            if (reqq.next()){
                                System.out.println("Voici, vos indentifiants");
                                Connection azerty = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC","root","");
                                PreparedStatement requeteSelect = azerty.prepareStatement("SELECT nom_utilisateur,mdp FROM utilisateur");
                                ResultSet leRes = requeteSelect.executeQuery();

                                while (leRes.next()) {
                                    System.out.println("nom d'utilisateur : " + leRes.getString("nom_utilisateur")+ " et le mot de passe :  " + leRes.getString("mdp"));
                                }
                            }
                            else {
                                System.out.println("Erreur, la reponse à la question de sécurité n'est pas bonne ducoup le compte sera supprimer sous peu");
                                Connection ty = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC","root","");
                                PreparedStatement suu = ty.prepareStatement("DELETE FROM utilisateur ");
                                suu.executeUpdate();
                                return ;
                            }

                            }
                    }

                }
            }


        }

    }

    public void Sinscrire() throws SQLException {
        System.out.println("Veillez vous inscrire");
        Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC", "root", "");
        Scanner inscrire = new Scanner(System.in);
        System.out.println("Nom :");
        String nom = inscrire.nextLine();
        System.out.println("Prenom :");
        String prenom = inscrire.nextLine();
        System.out.println("Nom d'utilisateur :");
        String nom_utilisateur = inscrire.nextLine();
        System.out.println("Mot de passe :");
        String mdp = inscrire.nextLine();
        System.out.println("Question de sécurité : Dans quelle ville vos parents se sont-ils rencontrés ?(en cas de nom_utilisateur/mdp oubliée)");
        String qds = inscrire.nextLine();

        PreparedStatement requete = cnx.prepareStatement("INSERT INTO utilisateur ( nom,prenom,nom_utilisateur,mdp,question_securite) VALUES (?,?,?,?,?)"); {
            requete.setString(1, nom);
            requete.setString(2, prenom);
            requete.setString(3, nom_utilisateur);
            requete.setString(4, mdp);
            requete.setString(5,qds);
            requete.executeUpdate();

            System.out.println("Inscrit avec succès");
        }

    }

    public void Modifier() throws SQLException {
        Scanner modifi = new Scanner(System.in);
        Scanner id = new Scanner(System.in);
        System.out.println("Saisir le nouveau nom d'utilisateur : ");
        String nd = modifi.nextLine();
        System.out.println("Saisir le nouveau mot de passe : ");
        String mdp = modifi.nextLine();
        Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC","root","");
        PreparedStatement modifier = maConnection.prepareStatement("Update utilisateur set nom_utilisateur = ?,mdp = ?");
        modifier.setString(1, nd);
        modifier.setString(2, mdp);
        modifier.executeUpdate();
    }

    public void AfficherUtilisateur() throws SQLException {
        Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoliste?serverTimezone=UTC","root","");
        PreparedStatement requeteSelect = maConnection.prepareStatement("SELECT * FROM utilisateur");
        ResultSet monResultat = requeteSelect.executeQuery();

        while (monResultat.next()) {
            System.out.println(monResultat.getInt("id_utilisateur") + " - " + monResultat.getString("nom")+ " - " + monResultat.getString("prenom")+ " - " + monResultat.getString("nom_utilisateur")+ " - " + monResultat.getString("mdp"));
        }

    }

    }



