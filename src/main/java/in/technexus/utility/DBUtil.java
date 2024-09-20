package in.technexus.utility;

import java.sql.*;

public class DBUtil {
    private static Connection conn;

    public static void openConnection(String dbUrl, String username, String password){
        if(conn == null){
            try{
                conn = DriverManager.getConnection(dbUrl, username, password);
                System.out.println("Tech Nexus Connection opened");

            } catch (SQLException e) {
                System.out.println("Error in opening connection");
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                System.out.println("Error in closing connection");
                e.printStackTrace();
            }
        }
    }

    public static Connection provideConnection(){
        return conn;
    }

    public static void closeResultSet(ResultSet rs) {
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error in closing result set");
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement st) {
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                System.out.println("Error in closing Statement/PreparedStatement");
                e.printStackTrace();
            }
        }
    }
}
