package Databaze.Logika;

import com.sun.xml.internal.bind.v2.TODO;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Engine {

    public Engine() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
    }
    // TODO: 30.12.16 vyřešit problém připojeni hibernate a připojení k databázi.
}
