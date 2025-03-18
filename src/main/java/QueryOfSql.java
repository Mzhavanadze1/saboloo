import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryOfSql {

    public String getToken() throws SQLException, ClassNotFoundException {
        DataBaseAccessSQL dataBaseAccessSQL = new DataBaseAccessSQL();
        String query_GetToken = """
                exec CredoBnk.dbo.GetSystemAuthorizationToken
                """;
        dataBaseAccessSQL.connectSQL();
        dataBaseAccessSQL.getInstance().createStatement();
        PreparedStatement preparedStatement = dataBaseAccessSQL.connection.prepareStatement(query_GetToken);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("token");




    }

}
