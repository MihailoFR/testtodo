package Application;

import Liste.Liste;
import Tache.Tache;
import Utilisateur.Utilisateur;
import jdk.jshell.execution.Util;

import java.sql.SQLException;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) throws SQLException {

Tache maTache = new Tache("Reviser","Scolaire","Reviser math","03/03","moyen");
maTache.ValiderTache();

    }
}
