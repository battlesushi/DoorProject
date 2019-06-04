package DoorApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingUtilities;

public class tcplistenToDB {
	private static String rename;
    protected static String ok = "3";
    String tcpcardNumber=newtcplisten.tcpcardNumber;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://120.108.111.137:3306/105021043?characterEncoding=utf-8";
    String user = "root", passwd = "h3041723";
	
    public void  run() {
    	
    	try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, passwd);
            Statement st = con.createStatement();

            
                String s = " SELECT * FROM Member";
                PreparedStatement ps = con.prepareStatement(s);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if (tcpcardNumber.substring(32, 43).equals(rs.getString("ID"))) {
                        ok = "1";
                        rename = rs.getString("Name");
                        SwingUtilities.invokeLater(new Runnable()////��?��?����?����?�����??��蹎��?�����??��謘extField���蕭??��
                        {
                            public void run()
                            {
//                                tcpcardNumber="";
                            }
                        });
                        tcpTestClass tc=new tcpTestClass();
                        tc.run();
//                        showPass.setForeground(Color.BLUE);
//                        showPass.setText("??��?�蕭��?��?��?�����??�蕭謍�?�蕭謍�?��?��?��??��?��??�??��?��?��?��?��??��蕭!!");
//                        TestClass tc = new TestClass();
//                        tc.run();
//                        try{
//                        	Thread.sleep(1000);
//                        	showPass.setText("");//消除??�示
//                        }catch(Exception e){}
                        break;
                    }
                    
                    
                }
                if (ok.equals("1")) {
                    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                    Date date = new Date();
                    String strDate = sdFormat.format(date);
                    String s2 = "INSERT INTO Record (Name,Time,State,ID) VALUES(?,?,'已註冊','"+tcpcardNumber.substring(32, 43)+"')";
                    PreparedStatement ps2 = con.prepareStatement(s2);
                    ps2.setString(1, rename);
                    ps2.setString(2, strDate);
                    ps2.executeUpdate();
                    ok="3";
                } else {
                	SwingUtilities.invokeLater(new Runnable()////��?��?����?����?�����??��蹎��?�����??��謘extField���蕭??��
                            {
                                public void run()
                                {
//                                    tcpcardNumber="";
                                }
                            });
//                    showPass.setForeground(Color.RED);
//                    showPass.setText("??��?�蕭��?��?����?��?��?��?��?�����蕭��蝴���??��?�蕭���??�?��?��??��?��??��?��?��?��?�蕭蹎刻?��??���?�蕭謕�?�!!");
                }
            
            con.close();
        } catch (Exception e) {
        }
    	
    }
}