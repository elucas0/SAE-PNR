package controller.utilitaires;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import com.opencsv.CSVWriter;

public class ExportData {

    public void writeCSV(String nomTable) throws SQLException, IOException, ClassNotFoundException {

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
}
