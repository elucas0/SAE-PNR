import traitement.*;
import donnee.*;
import java.sql.*;

public class ScenarioTraitement {
    public static void main(String[] args) {
        Lieu lieu = new Lieu(48.862725, 2.287592);
        Lieu lieu2 = new Lieu(45.7578137, 4.8320114);
        //Observation obs = new Observation(1, new Date(1), new Time(1), lieu, )
        Sommet sommet = new Sommet(1, lieu, new Date(1), EspeceObservee.LOUTRE);
        Sommet sommet2 = new Sommet(2, lieu2, new Date(1), EspeceObservee.LOUTRE);

        sommet.calculeDist(sommet2);
    }
    
}
