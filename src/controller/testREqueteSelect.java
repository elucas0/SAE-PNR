package controller;

public class testREqueteSelect {
    PreparedStatement i = c.prepareStatement("SELECT * FROM lieu WHERE coord_Lambert_X = ? AND coord_Lambert_Y = ?");
    i.setString(1, lambertX.getText());
    i.setString(2, lambertY.getText());
    ResultSet r = i.executeQuery();

    if(r.next()){}
    else{
        String querry1 = "INSERT INTO lieu VALUES(" + lambertX.getText() + "," + lambertY.getText() + ");";
        s.executeUpdate(querry1);
    }

    PreparedStatement i = c.prepareStatement("SELECT * FROM nid_gci WHERE (idNid = ?) AND nomPlage = ? AND raisonArretObservation = ? AND nbEnvol = ? AND protection = ? AND bagueMale = ? AND bagueFemelle = ?");
    //i.setString(1, idNid.getText());
    i.setString(2, nomPlage.getText());
    i.setString(3, raisonArret.getPromptText());
    i.setString(4, nomEnvols.getText());
    i.setString(5, estProtege.getPromptText());
    i.setString(6, bagueMale.getText());
    i.setString(7, bagueFemelle.getText());
    ResultSet r = i.executeQuery();

    if(r.next()){}
    else{
        String querry1 = "INSERT INTO nid_gci VALUES(" + nomPlage.getText() + "," + raisonArret.getPromptText() + "," + nomEnvols.getText() + "," + estProtege.getPromptText() + "," + bagueMale.getText() + "," + bagueFemelle.getText() + ");";
        s.executeUpdate(querry1);
    }


    PreparedStatement i = c.prepareStatement("SELECT * FROM chouette WHERE numIndividu = ? AND espece = ? AND sexe = ? ");
    i.setString(1, numIndividu.getText());
    i.setString(2, espece.getText());
    i.setString(3, sexe.getPromptText());
    ResultSet r = i.executeQuery();

    if(r.next()){}
    else{
        String querry1 = "INSERT INTO chouette VALUES(" + numIndividu.getText() + "," + espece.getPromptText() + "," + sexe.getText() + ");";
        s.executeUpdate(querry1);
    }
}
