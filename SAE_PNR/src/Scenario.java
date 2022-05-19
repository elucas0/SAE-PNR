import java.util.ArrayList;

import donnee.*;

import java.sql.*;

public class Scenario {
    public static void main(String[] args) {
        testObsBatracien();
        testObsLoutre();

        test_Chouette_obsChouette();
    }

    public static void testObsBatracien(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        Observateur obs4 = new Observateur(1, "LeBars", "Floraian");
        observateurs.add(obs4);
        int[] obs = {1, 2, 3, 4};
        Lieu lieu = new Lieu(785, 154);
        ObsBatracien batracien = null;
        ObsBatracien batracienErreur;
        try{
            batracienErreur = new ObsBatracien(0, null, null, null, null, null, null);
            batracien = new ObsBatracien(1, new Date(1), new Time(1) , lieu, observateurs, obs, EspeceBatracien.PELODYTE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
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
        System.out.println("CHANGEMENT AVEC LES SET");
        System.out.println(batracien.getEspece());
        System.out.println(batracien.getNombreAdultes());
        System.out.println(batracien.getNombreAmplexus());
        System.out.println(batracien.getNombrePonte());
        System.out.println(batracien.getNombreTetard());
    }

    public static void testObsLoutre(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        Lieu lieu = new Lieu(785, 154);
        ObsLoutre loutre = new ObsLoutre(1, new Date(1), new Time(1) , lieu, observateurs,IndiceLoutre.POSITIF);
        System.out.println(loutre.getIndice());
        loutre.setIndice(IndiceLoutre.NEGATIF);
        System.out.println("CHANGEMENT AVEC LES SET");
        System.out.println(loutre.getIndice());
    }


    public static void test_Chouette_obsChouette(){

        System.out.println("-----Test ObsChouette et Chouette-----");

        System.out.println("-----Test Chouette constructeur-----");

        Chouette chouette1;
        try{
            chouette1 = new Chouette("1", Sexe.MALE, EspeceChouette.CHEVECHE);
            Chouette chouette2 = new Chouette(null, null, null);
        }catch(Exception e){
            e.printStackTrace();
        }
        Lieu test = new Lieu(5.0, 5.0);
        Time heure = new Time(1);
        Date date = new Date(1);

        ArrayList<Observateur> obs = new ArrayList<>();

        System.out.println("-----Test ObsChouette constructeur-----");
        ObsChouette obsChouette1;
        try{
            obsChouette1 = new ObsChouette(1, (java.sql.Date) date, heure, test, obs, TypeObservation.SONORE);
            ObsChouette obsChouette2 = new ObsChouette(-1, null, null, null, null, null);

        }catch(Exception e){
            e.printStackTrace();
        }


        ArrayList<ObsChouette> test2 = new ArrayList<ObsChouette>();
        test2.add(obsChouette1);

        System.out.println("-----Test ajouteObs()----");
        chouette1.ajouteObs(obsChouette1);
        chouette1.ajouteObs(null);

        System.out.println("-----Test ajoutePlsObs()----");
        chouette1.ajoutePlsObs(test2);
        chouette1.ajoutePlsObs(null);

        System.out.println("-----Test setLesObservations()----");
        chouette1.setLesObservations(test2);
        chouette1.setLesObservations(null);


        System.out.println("-----Test retireObs()----");
        System.out.println(chouette1.retireObs(0));
        chouette1.retireObs(-1);

        System.out.println("-----Test videObs()----");
        chouette1.videObs();

        System.out.println("-----Test nbObs()----");
        System.out.println(chouette1.nbObs());


        Observateur obs4 = new Observateur(1, "Doe", "John");
        
        obsChouette1.ajouteObservateur(obs4);
        obsChouette1.ajouteObservateur(null);
        obsChouette1.getTypeObs();
        obsChouette1.setTypeObs(TypeObservation.SONORE_VISUELLE);
        obsChouette1.setTypeObs(null);
        System.out.println("fin");
    }

    public static void test_ObsGCI_NidGCI(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        Lieu test = new Lieu(5.0, 5.0);

        Observateur obs = new Observateur(7, "Leroux", "Andreas");
        observateurs.add(obs);

        System.out.println("-----Test ObsGCI et NidGCI-----");

        System.out.println("-----Test ObsGCI constructeur-----");
        

        ObsGCI obsGCI1 = new ObsGCI(1, new Date(1), new Time(1), test, observateurs, ContenuNid.OEUF, 3);
        ObsGCI obsGCI2 = new ObsGCI(-1, null, null, null, null, null, (Integer) null);

        System.out.println("-----Test ObsGCI getNature()----");
        System.out.println(obsGCI1.getNature());
        System.out.println(obsGCI2.getNature());

        System.out.println("-----Test ObsGCI setNature()----");
        obsGCI1.setNature(ContenuNid.POUSSIN);
        obsGCI1.setNature(null);

        System.out.println("-----Test ObsGCI getDate()----");
        obsGCI1.getDate();
        obsGCI2.getDate();

        System.out.println("-----Test ObsGCI setDate()----");
        obsGCI1.setDate(new Date(1));
        obsGCI1.setDate(null);

        System.out.println("-----Test ObsGCI getHeure()----");
        obsGCI1.getHeure();
        obsGCI2.getHeure();

        System.out.println("-----Test ObsGCI setHeure()----");
        obsGCI1.setHeure(new Time(1));
        obsGCI1.setHeure(null);

        System.out.println("-----Test ObsGCI getLieu()----");
        obsGCI1.getLieu();
        obsGCI2.getLieu();

        System.out.println("-----Test ObsGCI setLieu()----");
        obsGCI1.setLieu(new Lieu(5.0, 5.0));
        obsGCI1.setLieu(null);

        System.out.println("-----Test ObsGCI getLesObservateurs()----");
<<<<<<< HEAD

=======
        obsGCI1.getLesObservateurs();
        obsGCI2.getLesObservateurs();
    }
>>>>>>> 5ac2a5035432e1fc2c09d1e6cd984070034e4651
}
