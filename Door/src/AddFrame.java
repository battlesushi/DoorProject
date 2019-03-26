package DoorApp;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AddFrame extends JFrame {
	private JLabel lb1 = new JLabel("Ë´ãËº∏?Ö•ID??äÂç°???");
	private JLabel lb2 = new JLabel("ID");
	private JLabel lb3 = new JLabel("?ç°???");
	private JTextField tf = new JTextField();
	private JTextField tf2 = new JTextField();
	private JButton bt1 = new JButton("Á¢∫Ë??");
	private JButton bt2 = new JButton("??ñÊ??");
	private Container cp;
	private Panel pan = new Panel(new GridLayout(1, 3, 1, 1)); 
	private Panel pan2 = new Panel(new GridLayout(2, 2, 1, 1));

	public AddFrame() {
		init();
	}

	private void init() {
		cp = this.getContentPane();
		this.setBounds(100, 100, 500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp.setLayout(new BorderLayout(5, 5));
		cp.add(pan, BorderLayout.SOUTH);
		pan.add(bt1);
		pan.add(bt2);// Á¢∫Ë?çÊ?âÈ?ïÁ?ÑË®≠ÁΩ?
		lb1.setFont(new Font(null, Font.BOLD, 24));
		cp.add(lb1, BorderLayout.NORTH);// Ë®≠ÁΩÆ?ñ∞Â¢ûË?ñÁ?óÁ?ÑÊ?ôÈ??
		cp.add(pan2, BorderLayout.CENTER);
		pan2.add(lb2);
		pan2.add(tf);
		pan2.add(lb3);
		pan2.add(tf2);// Ëº∏ÂÖ•id??äÂ?ÜÁ¢º??ÑË®≠ÁΩ?
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}

		});// ??ñÊ?àÊ?âÈ?ïÁ?ÑÂ?üËÉΩ
                
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
                            String driver = "com.mysql.jdbc.Driver"; 
                            String url = "jdbc:mysql://localhost:3306/doorcontrol"; 
                            String user = "root";
                            String passwd = "0000";
				try {
                                    Class.forName(driver); 
                                    Connection con = DriverManager.getConnection(url, user, passwd);
                                    //?ñ∞Â¢ûË?ûÊ??
                                    Statement st = con.createStatement();
                                    String n=tf.getText();
                                    String k=tf2.getText();

                                    String s = "INSERT INTO member (name,card) VALUES(?,?)";
                                    PreparedStatement ps=con.prepareStatement(s);

                                    ps.setString(1, n);
                                    ps.setString(2, k);
                                    ps.executeUpdate();

                                    con.close();
                                } catch (SQLException ex) {
                                Logger.getLogger(AddFrame.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(AddFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}

		});// ??ñÂ?óid??äÂ?ÜÁ¢º
	}
        public static void main(String args[]){
            AddFrame mf=new AddFrame();
            mf.setVisible(true);
        }

}
