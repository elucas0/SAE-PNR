package controller.utilitaires;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import com.opencsv.CSVWriter;

public class ExportData {

    public static void writeCSV(String nomTable) throws SQLException, IOException, ClassNotFoundException {

        CSVWriter writer = new CSVWriter(new FileWriter(nomTable + ".csv"));
        Boolean includeHeaders = true;

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        PreparedStatement i = c.prepareStatement("SELECT * FROM " + nomTable  + "");
        ResultSet rs = i.executeQuery();

        writer.writeAll(rs, includeHeaders);

        writer.close();
    }

    public static void exportAll() throws SQLException, IOException, ClassNotFoundException {
        writeCSV("aobserve");
        writeCSV("lieu");
        writeCSV("lieu_vegetation");
        writeCSV("nid_gci");
        writeCSV("chouette");
        writeCSV("obs_batracien");
        writeCSV("obs_chouette");
        writeCSV("obs_gci");
        writeCSV("obs_hippocampe");
        writeCSV("obs_loutre");
        writeCSV("observateur");
        writeCSV("observation");
        writeCSV("vegetation");
        writeCSV("zonehumide");
    }
}