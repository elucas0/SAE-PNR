package controller;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxExpr.Identifier;

import java.sql.*;
import modele.donnee.*;
import modele.*;

public class QueryGet {


    public ArrayList<ObsBatracien> getObsBatracien(){

        ArrayList<ObsBatracien> ret = new ArrayList<ObsBatracien>();
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement querry = c.createStatement();
            ResultSet observations = querry.executeQuery("SELECT * FROM observation LIMIT 25;");
            ResultSet res;
            ResultSet res2;
            ResultSet res3;
            ArrayList<Observateur> observateur = new ArrayList<>();
            ArrayList<Integer> idObservateurs = null; 
            Observation obs;

            int idObs;
            Date date;
            Time heure;
            Lieu lieuObs;

            while(observations.next()){

                System.out.println("passe");

                idObs = observations.getInt("idObs");
                System.out.println("passe");
                date = observations.getDate("dateObs");
                heure = observations.getTime("heureObs");
                lieuObs = new Lieu(observations.getDouble("lieu_Lambert_X"), observations.getDouble("lieu_Lambert_Y"));
                
                res = querry.executeQuery("SELECT lobservateur FROM aobserve WHERE lobservation = " + idObs + " LIMIT 25");
                System.out.println("passe");

                observateur = new ArrayList<Observateur>();
                idObservateurs = new ArrayList<Integer>();

                while(res.next()){

                    idObservateurs.add(res.getInt("lobservateur"));
                }
                System.out.println("passe lobservateur");

                for(int i : idObservateurs){

                    res = querry.executeQuery("SELECT nom, prenom FROM observateur WHERE idObservateur = " + i);
                    Observateur obs1 = new Observateur(i, res.getString("nom"), res.getString("prenom"));
                    observateur.add(obs1);
                }
                System.out.println("passe idObservateur");


                res = querry.executeQuery("SELECT * FROM obs_batracien WHERE obsB = "  + idObs);

                while(res.next()){

                    int[] resObs = {res.getInt("nombreAdultes"), res.getInt("nombreAmplexus"), res.getInt("nombrePonte"), res.getInt("nombreTetard")};
                    EspeceBatracien espece = EspeceBatracien.CALAMITE;

                    if(res.getString("espece").equals("calamite") ){
                        espece = EspeceBatracien.CALAMITE;


                    }else if(res.getString("espece").equals("pelodyte") ){
                        espece = EspeceBatracien.PELODYTE;

                    }
                    
                    ObsBatracien batracien = new ObsBatracien(idObs, date, heure, lieuObs, observateur, resObs, espece);
                    ret.add(batracien);

                }

                res.close();
                System.out.println("finit");




            }
            observations.close();
            c.close();
            querry.close();


        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        return ret;



    }


}
