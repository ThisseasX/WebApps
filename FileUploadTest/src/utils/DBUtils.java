package utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils {

    public static Connection getConnection() throws SQLException, NamingException {
        DataSource ds = InitialContext.doLookup("java:jboss/datasources/DBTest");
        return ds.getConnection();
    }
}
