package Demo1;

import javax.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import java.sql.*;
import java.util.*;
import javax.naming.*;

public class Main {
    public static DataSource createDataSource(
        String vendor,          String user,       String password,
        String databaseName,    String driverType, String networkProtocol,
        int portNumber,         String serverName) 
                                                    throws SQLException {
      
    if (vendor.equals("oracle")) {
        // create Oracle's DataSource
        // ........
        return null;
    }
    else if (vendor.equals("mssql")) {
        // create MSSQL's DataSource
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(databaseName);
        ds.setServerName(serverName);
        //ds.setPortNumber(portNumber);
        return ds;
    }
    else {    return null;    }
    }
    private static Context getFileSystemContext(String directoryName)
                                            throws javax.naming.NamingException {
        //
        // Set up environment for creating initial context
        //
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.fscontext.RefFSContextFactory");
        env.put(Context.PROVIDER_URL, "file:" + directoryName);
        Context context = new InitialContext(env);
        return context;
    }
    public static void main(String[] args) throws NamingException, SQLException {

        // Context
        Context contxt=getFileSystemContext("H:\\");

        // create an MSSQL DataSource with specific username/password
        DataSource ds = createDataSource("mssql","xxxx","****",
        "Northwind", "", "", 1433, "localhost");


        contxt.bind("jdbc/mySQLDS1", ds);

        //......

//     Context context = getFileSystemContext("H:\\");
//     DataSource myDS = (DataSource) context.lookup("jdbc/myFirstDS");
//     Connection con  = myDS.getConnection();

//      System.out.println(con.getCatalog());
//
//      DatabaseMetaData meta = con.getMetaData();
//      System.out.println("Driver name: "
//        + meta.getDriverName());
//      System.out.println("Driver version: "
//        + meta.getDriverVersion());
//      System.out.println("Server name: "
//        + meta.getDatabaseProductName());
//      System.out.println("Server version: "
//        + meta.getDatabaseProductVersion());
//      System.out.println("Connection URL: "
//        + meta.getURL());
//      System.out.println("Login name: "
//        + meta.getUserName());
//
//      con.close();
    }
}
