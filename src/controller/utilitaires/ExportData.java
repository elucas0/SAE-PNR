package controller.utilitaires;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import com.opencsv.CSVWriter;

/**
 * ExportData is a class that allows to export data from a database to a csv file.
 */
public class ExportData {

    /**
     * Export a table from a database to a csv file.
     * @param nomTable the name of the table to export.
     * @throws SQLException if an error occurs while connecting to the database.
     * @throws IOException if an error occurs while writing the csv file.
     * @throws ClassNotFoundException if the class of the driver is not found.
     */
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

    /**
     * Export every table from a database to a csv file.
     * @throws SQLException if an error occurs while connecting to the database.
     * @throws IOException if an error occurs while writing the csv file.
     * @throws ClassNotFoundException if the class of the driver is not found.
     */
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