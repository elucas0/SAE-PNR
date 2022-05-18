import java.util.ArrayList;
import java.util.Timer;

import donnee.EspeceBatracien;
import donnee.IndiceLoutre;
import donnee.Lieu;
import donnee.ObsBatracien;
import donnee.ObsLoutre;
import donnee.Observateur;
import java.sql.*;
//c'est de la merde

public class Scenario {
    ObsBatracien batracien;
    public static void main(String[] args) {
        testObsBatracien();
        testObsLoutre();
    }

    public static void testObsBatracien(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        int[] obs = new int[1];;
        Lieu lieu = new Lieu(785, 154);
        ObsBatracien batracien = new ObsBatracien(1, new Date(1), new Time(1) , lieu, observateurs, obs, EspeceBatracien.PELODYTE);
        System.out.println(batracien.getEspece());
        System.out.println(batracien.getNombreAdultes());
        System.out.println(batracien.getNombreAmplexus());
        System.out.println(batracien.getNombrePonte());
        System.out.println(batracien.getNombreTetard());
        batracien.setEspece(EspeceBatracien.PELODYTE);
        batracien.setNombreAdultes(5);
        batracien.setNombreAmplexus(2);
        batracien.setNombrePonte(3);
        batracien.setNombreTetard(9);
    }

    public static void testObsLoutre(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        int[] obs = new int[1];
        Lieu lieu = new Lieu(785, 154);
        ObsLoutre loutre = new ObsLoutre(1, new Date(1), new Time(1) , lieu, observateurs, obs,  IndiceLoutre.POSITIF);
        System.out.println(loutre.getIndice());
        loutre.setIndice(IndiceLoutre.NEGATIF);
    }
}
