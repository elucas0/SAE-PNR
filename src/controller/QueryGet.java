package controller;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxExpr.Identifier;

import java.sql.*;
import modele.donnee.*;
import modele.*;

public class QueryGet {

    public ArrayList<Observation> getObservations(int limite){

        if(limite >= 1){


        }else{

            System.err.println("getObservations : limite must be >= 0");
        }

        ArrayList<Observation> ret = new ArrayList<Observation>();

        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement querry = c.createStatement();
            PreparedStatement querry2 = c.prepareStatement("SELECT * FROM ?");
            //String[] tablesObs = {"obsChouette", "obsGci", "obsLoutre", "obsHippocampe"};
            ResultSet observations = querry.executeQuery("SELECT * FROM observation LIMIT 10");

            querry2.setString(1, "obs_batracien");
            ResultSet obsB = querry2.executeQuery();
            
            querry2.setString(1, "aobserve");
            ResultSet aobserve = querry2.executeQuery();

            querry2.setString(1, "observateur");
            ResultSet observateur = querry2.executeQuery();

            ArrayList<Observateur> observateurs;
            boolean trouve;
            boolean trouve2;
            int idObs2;

            int idObs;
            Date date;
            Time heure;
            Lieu lieu;

            while (observations.next()){

                trouve = false;

                idObs = observations.getInt("idObs");
                observateurs = new ArrayList<Observateur>();



                while((!trouve) && (obsB.next())){

                    idObs2 = obsB.getInt("obsB");
                    if(idObs == idObs2){

                        trouve = true;
                    }
                }


                if(trouve){

                    date = observations.getDate("dateObs");
                    heure = observations.getTime("heureObs");
                    lieu = new Lieu(observations.getDouble("lieu_Lambert_Y"), observations.getDouble("lieu_Lambert_Y"));
                    trouve2 = false;

                    while((aobserve.next()) && (!trouve2)){

                        int idObservateur = -1;

                        if(aobserve.getInt("lobservation") == idObs){

                            idObservateur = aobserve.getInt("lobservateur");
                        }

                        if(idObservateur >= 0){

                            while((observateur.next())){
                                if(observateur.getInt("idObservateur") == idObservateur){

                                    int idObservateurs = observateur.getInt("idObservateur");
                                    String nom = observateur.getString("nom");
                                    String prenom = observateur.getString("prenom");

                                    observateurs.add(new Observateur(idObservateur, nom, prenom));
                                }

                            }
                        }
                    }
                }
            }



            


        } catch (SQLException e) {
            e.printStackTrace();
        }

        

        return ret;
    }    


    public ArrayList<Observation> getObsBatracien(){

        ArrayList<Observation> ret = new ArrayList<Observation>();
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement querry = c.createStatement();
            ResultSet observations = querry.executeQuery("SELECT * FROM observateur LIMIT 25");
            ResultSet res;
            ResultSet res2;
            ResultSet res3;
            ArrayList<Observateur> observateur = new ArrayList<>();
            ArrayList<Integer> idObservateurs; 

            int idObs;
            Date date;
            Time heure;
            Lieu lieuObs;


            while(observations.next()){

                idObs = observations.getInt("idObs");
                res = querry.executeQuery("SELECT * FROM obs_batracien WHERE obsB = " + idObs);

                if(!res.next()){

                    date = observations.getDate("dateObs");
                    heure = observations.getTime("heureObs");
                    lieuObs = new Lieu(observations.getDouble("lieu_Lambert_X"), observations.getDouble("lieu_Lambert_Y"));                   
                    res2 = querry.executeQuery("SELECT lobservateur FROM aobserve WHERE lobservation = " + idObs);
                    idObservateurs = new ArrayList<Integer>();

                    while(res2.next()){

                        idObservateurs.add(res2.getInt("lobservateur"));
                    }

                    res3 = querry.executeQuery("SELECT nom, prenom FROM observateur WHERE idObservateur = " + idObs);
                    observateur = new ArrayList<>();
                    for(int i : idObservateurs){

                        while()

                        
                    }

                    

                }else{


                }
            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        return ret;



    }


}
