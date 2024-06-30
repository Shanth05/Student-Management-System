package student.management.system;

import java.sql.Connection;
import java.sql.DriverManager;

    public class DbConfig {
        private static DbConfig instance;
        
        
        private DbConfig(){
           
        }
        
    public static synchronized DbConfig getInstance(){
           
            if(instance == null){
               instance = new DbConfig();
           }
           return instance;
           }
        
        public Connection dbConnection() throws Exception {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sms"; /*create connection */
            String user="root";
            String password="4158";
            Connection con = DriverManager.getConnection(url, user, password); /* excecute statement */
            return con;
        }          
    }

