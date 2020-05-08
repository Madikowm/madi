package sample;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
        throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort +"/" +dbName +
                "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection=DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void signUpUser(User user){
        String insert = "INSERT " + Const.USER_TABLE+"("+Const.USERS_FULLNAME+","+Const.USERS_USERNAME+","+
                Const.USERS_PASSWORD+","+Const.USERS_GENDER+")"
                +"VALUES(?,?,?,?)";


        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFullname());
            prSt.setString(2, user.getUsername());
            prSt.setString(3, user.getPassword());
            prSt.setString(4, user.getGender());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "select * from users where username =? AND password =?";

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
