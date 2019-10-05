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
	private static String retype;
    protected static String ok = "3";
    private static boolean checkID = false;
    String tcpcardNumber=newtcplisten.tcpcardNumber;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://120.108.111.137:3306/105021043?characterEncoding=utf-8";
    String user = "root", passwd = "h3041723";
	
    public void  run() {
    	
    	try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, passwd);
            Statement st = con.createStatement();

                String s = " SELECT * FROM Member";//Member
                PreparedStatement ps = con.prepareStatement(s);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                	if (tcpcardNumber.substring(32, 43).equals(rs.getString("ID"))&&rs.getString("Type").equals("已凍結")) {
                		rename = rs.getString("Name");
                		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                        Date date = new Date();
                        String strDate = sdFormat.format(date);
                        String s2 = "INSERT INTO Record (Name,Time,State,ID) VALUES(?,?,'已凍結','"+tcpcardNumber.substring(32, 43)+"')";
                        PreparedStatement ps2 = con.prepareStatement(s2);
                        ps2.setString(1, rename);
                        ps2.setString(2, strDate);
                        ps2.executeUpdate();
                        checkID = true;
                        break;
                	}         

                    
                    
                	else if (tcpcardNumber.substring(32, 43).equals(rs.getString("ID"))&& rs.getString("Type").equals("已註冊")) {
                            ok = "1";
                            rename = rs.getString("Name");
                            SwingUtilities.invokeLater(new Runnable()////��?��?����?����?�����??��蹎��?�����??��謘extField���蕭??��
                            {
                                public void run()
                                {
//                                    tcpcardNumber="";
                                }
                            });
                            	tcpTestClass tc=new tcpTestClass();
                                tc.run();
                                SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                Date date = new Date();
                                String strDate = sdFormat.format(date);
                                String s4 = "INSERT INTO Record (Name,Time,State,ID) VALUES(?,?,'已註冊','"+tcpcardNumber.substring(32, 43)+"')";
                                PreparedStatement ps4 = con.prepareStatement(s4);
                                ps4.setString(1, rename);
                                ps4.setString(2, strDate);
                                ps4.executeUpdate();
                                ok="3";
                                checkID = true;
//                            showPass.setForeground(Color.BLUE);
//                            showPass.setText("??��?�蕭��?��?��?�����??�蕭謍�?�蕭謍�?��?��?��??��?��??�??��?��?��?��?��??��蕭!!");
//                            TestClass tc = new TestClass();
//                            tc.run();
//                            try{
//                            	Thread.sleep(1000);
//                            	showPass.setText("");//消除??�示
//                            }catch(Exception e){}
                            break;
                        }   
                    
                	
                }
            	if(checkID==false) {
            		if(!tcpcardNumber.substring(32, 43).equals(" (M16)Egres")) {
            			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                        Date date = new Date();
                        String strDate = sdFormat.format(date);
                        String s2 = "INSERT INTO Record (Name,Time,State,ID) VALUES('Unknown',?,'未註冊','"+tcpcardNumber.substring(32, 43)+"')";
                        PreparedStatement ps2 = con.prepareStatement(s2);
                        ps2.setString(1, strDate);
                        ps2.executeUpdate();
            		}	
            	}                       


            
            con.close();
        } catch (Exception e) {
//        	System.out.print(e);
        }
        checkID = false;
    }
}