import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Config.BaseConfig;
@Test
public class DataBaseAccessSQL {
    public  Connection connection;

    public  Connection connectSQL() throws SQLException, ClassNotFoundException {
        try {
            Connection connection = DriverManager.getConnection(BaseConfig.jdbcUrl,BaseConfig.DBuserName,BaseConfig.DBpassword);
            connection.createStatement();
            System.out.println("successfully connected!");

            this.connection=connection;
            return connection;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public Connection getInstance(){
        return this.connection;
    }
}
