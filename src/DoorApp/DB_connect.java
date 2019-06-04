
package DoorApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_connect {

    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://120.108.111.137:3306/105021043?characterEncoding=utf-8";
        String user = "root", passwd = "h3041723"; 
        
        Class.forName(driver); 
        Connection con = DriverManager.getConnection(url, user, passwd);
        System.out.println("資料庫連線成功");
                
        //輸入語�??
                
        con.close();
    }
    
}
