import java.util.ArrayList;

import donnee.EspeceBatracien;
import donnee.IndiceLoutre;
import donnee.Lieu;
import donnee.ObsBatracien;
import donnee.ObsLoutre;
import donnee.Observateur;

public class Scenario {
    ObsBatracien batracien;
    public static void main(String[] args) {
        testObsBatracien();
        testObsLoutre();
    }

    public void testObsBatracien(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        int[] obs;
        Lieu lieu = new Lieu(785, 154);
        ObsBatracien batracien = new ObsBatracien(1, 17052022, 1909, lieu, observateurs, obs, CALAMITE);
        System.out.pritnln(batracien.getEspece());
        System.out.pritnln(batracien.getNombreAdultes());
        System.out.pritnln(batracien.getNombreAmplexus());
        System.out.pritnln(batracien.getNombrePonte());
        System.out.pritnln(batracien.getNombreTetard());
        System.out.pritnln(batracien.setEspece(PELODYTE));
        System.out.pritnln(batracien.setNombreAdultes(5));
        System.out.pritnln(batracien.setNombreAmplexus(2));
        System.out.pritnln(batracien.setNombrePonte(3));
        System.out.pritnln(batracien.setNombreTetard(9));
    }

    public void testObsLoutre(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        int[] obs;
        Lieu lieu = new Lieu(785, 154);
        ObsLoutre loutre = new ObsLoutre(2, 17052022, 1918, lieu, observateurs, POSITIF);
        System.out.println(loutre.getIndice());
        System.out.print(loutre.setIndice(NEGATIF));
    }
}
