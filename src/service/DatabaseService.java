package service;

import managers.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseService {
    private DatabaseService(){

    }
    public static PreparedStatement getStatament(String sql){

        Connection con = DatabaseConnectionManager.getInstance().createConnection();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            return statement;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        return null;
    }

}
