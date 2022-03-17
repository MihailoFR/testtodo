package Liste;
import java.sql.*;
import java.util.Scanner;


public class Liste {
    private String nom;
    private int ref_utilisateur;

    public Liste(String nom) {

        this.nom = nom;

    }



    public void ValiderListe() throws SQLException {
        Scanner valider = new Scanner(System.in);
        System.out.println("Veuillez entrer le nom de votre Liste");
        String nom=valider.nextLine();
        Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetliste?serverTimezone=UTC","root","");
        PreparedStatement ajouter = maConnection.prepareStatement("INSERT INTO liste(nom)" + "VALUES(?)", Statement.RETURN_GENERATED_KEYS);
        ajouter.setString(1, nom);
        ajouter.executeUpdate();
        System.out.println("Votre liste vient d'etre ajoutée");
    }


    public void ModifierListe() throws SQLException {
        Scanner update = new Scanner(System.in);
        Scanner id = new Scanner(System.in);
        System.out.println("Quel liste voulez-vous modifier ?(l'id)");
        System.out.println("Pour consulter les id veulliez choisir 'afficher'");
        int upid = id.nextInt();
        System.out.println("Saisir le nouveau nom : ");
        String upnom = update.nextLine();
        Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetliste?serverTimezone=UTC","root","");
        PreparedStatement modifier = maConnection.prepareStatement("Update liste set nom = ? WHERE id_liste = ?");
        modifier.setString(1, upnom);
        modifier.setInt(2,upid);
        modifier.executeUpdate();
        System.out.println("Votre liste vient d'etre modifiée");
    }


    public void SupprimerListe() throws SQLException {
        System.out.println("Quel liste voulez-vous supprimer ?(l'id)");
        System.out.println("Pour consulter les id veulliez choisir 'afficher'");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetliste?serverTimezone=UTC","root","");
        PreparedStatement modifier = maConnection.prepareStatement("DELETE FROM liste WHERE id_liste = ?");
        modifier.setString(1, String.valueOf(id));
        modifier.executeUpdate();
        System.out.println("Votre liste a été supprimée avec succès");
    }

    public void AfficherListe() throws SQLException {
        Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetliste?serverTimezone=UTC","root","");
        PreparedStatement requeteSelect = maConnection.prepareStatement("SELECT * FROM liste");
        ResultSet monResultat = requeteSelect.executeQuery();

        System.out.println("Vos liste : ");
        while (monResultat.next()) {
            System.out.println(monResultat.getInt("id_liste") + " - " + monResultat.getString("nom")+ " - " + monResultat.getInt("ref_utilisateur"));
        }

    }
}


