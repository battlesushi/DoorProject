
package DoorApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_connect {

    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver"; 
        String url = "jdbc:mysql://localhost:3306/doorcontrol"; 
        String user = "root";
        String passwd = "0000"; 
        
        Class.forName(driver); 
        Connection con = DriverManager.getConnection(url, user, passwd);
        System.out.println("資料庫連線成功"); 
                
        //輸入語法
                
        con.close();
    }
    
}
