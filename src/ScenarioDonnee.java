import java.util.ArrayList;

import donnee.*;

import java.sql.*;


/**
 * Class that tes all the classes in the package donnee
 */
public class ScenarioDonnee {

    /**
     * The class' main method. Test all the classes
     * @param args some arguments
     */
    public static void main(String[] args) {
        testObsBatracien();
        testObsLoutre();

        test_Chouette_obsChouette();
        testObsHippocampe();
        testObservationLieu();
        test_ObsGCI_NidGCI();

    }

    /**
     * test the class ObsBatracien
     */
    public static void testObsBatracien(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        Observateur obs4 = new Observateur(1, "LeBars", "Floraian");
        observateurs.add(obs4);
        int[] obs = {1, 2, 3, 4};
        Lieu lieu = new Lieu(785, 154);
        ObsBatracien batracien = null;
        ObsBatracien batracienErreur;
        try{
            batracien = new ObsBatracien(1, new Date(1), new Time(1) , lieu, observateurs, obs, EspeceBatracien.PELODYTE);

            batracienErreur = new ObsBatracien(0, null, null, null, null, null, null);
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

    /**
     * Test the class ObsLoutre
     */
    public static void testObsLoutre(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        Lieu lieu = new Lieu(785, 154);
        ObsLoutre loutre = null;
        
        try{
            loutre = new ObsLoutre(1, new Date(1), new Time(1) , lieu, observateurs,IndiceLoutre.POSITIF);
            ObsLoutre loutreErreur = new ObsLoutre(0,null, null, null, null, null);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(loutre.getIndice());
        loutre.setIndice(IndiceLoutre.NEGATIF);
        System.out.println("CHANGEMENT AVEC LES SET");
        System.out.println(loutre.getIndice());
    }


    /**
     * Test the classes Chouette and ObsChouette
     */
    public static void test_Chouette_obsChouette(){

        System.out.println("-----Test ObsChouette et Chouette-----");

        System.out.println("-----Test Chouette constructeur-----");

        Chouette chouette1 = null;
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
        ObsChouette obsChouette1 = null;
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
    }

    
    /**
     * Test the class ObsGCI and NidGCI
     */
    public static void test_ObsGCI_NidGCI(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        Lieu test = new Lieu(5.0, 5.0);

        Observateur obs = new Observateur(7, "Leroux", "Andreas");
        observateurs.add(obs);

        System.out.println("-----Test ObsGCI et NidGCI-----");

        System.out.println("-----Test ObsGCI constructeur-----");
        
        ObsGCI obsGCI1 = null;
        ObsGCI obsGCI2 = null;
        try{

            obsGCI1 = new ObsGCI(1, new Date(1), new Time(1), test, observateurs, ContenuNid.OEUF, 3);
            obsGCI2 = new ObsGCI(-1, null, null, null, null, null, -3);
    
        }catch(Exception e){

            e.getMessage();
        }

        System.out.println("-----Test ObsGCI getNature()----");
        System.out.println(obsGCI1.getNature());

        System.out.println("-----Test ObsGCI setNature()----");
        obsGCI1.setNature(ContenuNid.POUSSIN);
        obsGCI1.setNature(null);

        System.out.println("-----Test ObsGCI getDate()----");
        obsGCI1.getDate();

        System.out.println("-----Test ObsGCI setDate()----");
        obsGCI1.setDate(new Date(1));
        obsGCI1.setDate(null);

        System.out.println("-----Test ObsGCI getHeure()----");
        obsGCI1.getHeure();

        System.out.println("-----Test ObsGCI setHeure()----");
        obsGCI1.setHeure(new Time(1));
        obsGCI1.setHeure(null);

        System.out.println("-----Test ObsGCI getLieu()----");
        obsGCI1.getLieu();

        System.out.println("-----Test ObsGCI setLieu()----");
        obsGCI1.setLieu(new Lieu(5.0, 5.0));
        obsGCI1.setLieu(null);

        System.out.println("-----Test ObsGCI getLesObservateurs()----");
        obsGCI1.getLesObservateurs();
    }


    /**
     * Test the class ObsHippocampe
     */
    public static void testObsHippocampe(){
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        Observateur obs4 = new Observateur(1, "Legrand", "Leo");
        observateurs.add(obs4);
        Lieu lieu = new Lieu(785, 154);
        Time heure = new Time(1);
        Date date = new Date(1);

        ObsHippocampe hippocampe = null;
        ObsHippocampe hippocampeErreur;
        try{
            hippocampe = new ObsHippocampe(1, date, heure , lieu, observateurs, 10,  Peche.PETIT_FILET,EspeceHippocampe.HIPPOCAMPUS_HIPPOCAMPUS, Sexe.MALE);
            hippocampeErreur = new ObsHippocampe(0, null, null, null, null, 0, null, null, null);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(hippocampe.getEspece());
        System.out.println(hippocampe.getSexe());
        System.out.println(hippocampe.getTaille());
        System.out.println(hippocampe.getTypePeche());
        System.out.println(hippocampe.getEstGestant());
        hippocampe.setEspece(EspeceHippocampe.HIPPOCAMPUS_HIPPOCAMPUS);
        hippocampe.setSexe(Sexe.MALE);
        hippocampe.setTaille(10);
        hippocampe.setTypePeche(Peche.PETIT_FILET);
        hippocampe.setEstGestant(true);


        System.out.println("CHANGEMENT AVEC LES SET");
        System.out.println(hippocampe.getEspece());
        System.out.println(hippocampe.getSexe());
        System.out.println(hippocampe.getTaille());
        System.out.println(hippocampe.getTypePeche());
        System.out.println(hippocampe.getEstGestant());
    }


    /**
    * Test the class Observateur and Lieu
     */
	public static void testObservationLieu(){
		//Create list of observers
		ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
		ArrayList<Observateur> observateurs2 = new ArrayList<Observateur>();


		 /**
    	  * Test the class Observateur 
          */
        try{
            Observateur obs1 = new Observateur(1, "LeBars", "Florian");

            Observateur obsErreur = new Observateur(0, null, null);
        }
        catch(Exception e){
            e.printStackTrace();
        }
	    Observateur obs2 = new Observateur(1, "Posselt", "Timothée");
	    Observateur obs3= new Observateur(2, "LeGrand", "Leo");
        observateurs.add(obs2);
        observateurs2.add(obs3);	
       	

       	/**
    	 * Test the class Lieu 
        */
        
        try{
            Lieu pcf = new Lieu(47.7500922, -3.3604015);

            Lieu lieuErreur = new Lieu(0, 0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Lieu stg = new Lieu(48.7081906, 44.5153353);



		System.out.println("-----Test getter Lieu----");
        System.out.println(stg.getCoordX());
        System.out.println(stg.getCoordY());
		System.out.println("-----Test setter Lieu----");
		stg.setCoordX(246);
        stg.setCoordY(358);
        System.out.println(stg.getCoordX());
        System.out.println(stg.getCoordY());


        System.out.println("-----Test getter observateur----");
        System.out.println(obs2.getId());
        System.out.println(obs2.getNom());
        System.out.println(obs2.getPrenom());
         System.out.println("-----Test setter observateur----");
        obs2.setId(4);
        obs2.setNom("Phillipe");
        obs2.setPrenom("Maël");
        System.out.println(obs2.getId());
        System.out.println(obs2.getNom());
        System.out.println(obs2.getPrenom());

    }


}
