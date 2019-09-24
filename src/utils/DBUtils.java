package utils;

import java.sql.*;

public class DBUtils {
    private static String url = DBConfig.getValue("url");
    private static String username = DBConfig.getValue("username");
    private static String psw = DBConfig.getValue("password");
    private static String driver = DBConfig.getValue("driver");
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnecion() throws SQLException {
        Connection conn = DriverManager.getConnection(url,username,psw);
        return conn;
    }
    public static void closeConnecion(ResultSet rs,Statement stmt,Connection conn){
        try {
            if(rs!=null){
                rs.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
