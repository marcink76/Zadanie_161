package pl.schronisko.demo.database;

import org.springframework.stereotype.Component;
import pl.schronisko.demo.model.Animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class WriteSQL {

    public void writeSQL(Animal animal) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String serverUrl = "jdbc:mysql://sql.coni.nazwa.pl:3306/coni_schronisko";
        String user = "coni_schronisko";
        String pass = "MarciN_12345";

        String sql = "INSERT INTO animals (name, description, species, image ) VALUES (\""+ animal.getName()+ "\",\"" + animal.getDescription()+ "\",\"" + animal.getSpecies()+ "\",\"" + animal.getPhotoPath()+ "\");";

        try {
            connection = DriverManager.getConnection(serverUrl, user, pass);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(WriteSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }


    }
}
