/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoorApp;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class tcplistenVcode extends javax.swing.JFrame {

    private String rename;
    protected String ok = "0";

    public tcplistenVcode() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vcode = new javax.swing.JTextField();
        showPass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.BorderLayout(0, 10));

        vcode.setFont(new java.awt.Font("新細明體", 0, 36));
        vcode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vcodeActionPerformed(evt);
            }
        });
        getContentPane().add(vcode, java.awt.BorderLayout.CENTER);

        vcode.getDocument().addDocumentListener(new DocumentListener() {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://120.108.111.137:3306/105021043?characterEncoding=utf-8";
            String user = "root", passwd = "h3041723";
            public void changedUpdate(DocumentEvent e) {
                runPass();
            }

            public void removeUpdate(DocumentEvent e) {
                runPass();
            }

            public void insertUpdate(DocumentEvent e) {
                runPass();
            }

            public void runPass() {

                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, passwd);
                    Statement st = con.createStatement();

                    if (vcode.getText().length()>=4) { // 驗證碼長度=4
                        if(vcode.getText().length()==4){//驗證碼
                            String s = " SELECT * FROM VerificationCode";
                            PreparedStatement ps = con.prepareStatement(s);
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()) {

                                if (vcode.getText().equals(rs.getString("Vcode"))) {
                                    ok = "2";
                                    rename = rs.getString("LineName");
                                    SwingUtilities.invokeLater(new Runnable()////��?��?����?����?�����??��蹎��?�����??��謘extField���蕭??��
                                    {
                                        public void run()
                                        {
                                            vcode.setText("");
                                        }
                                    });
                                    showPass.setForeground(Color.BLUE);
                                    showPass.setText("驗證正確!!");
                                    String s2 = "UPDATE `VerificationCode` SET `Vcode`=48763";
                                    PreparedStatement ps2 = con.prepareStatement(s2);
                                    ps2.executeUpdate();
//                                try{
//                                	Thread.sleep(1000);
//                                	showPass.setText("");//消除??�示
//                                }catch(Exception e){}
                                    break;
                                }
                            }
                        }
                        if(ok.equals("2")){//2=驗證碼
                            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                            Date date = new Date();
                            String strDate = sdFormat.format(date);
                            String s3 = "INSERT INTO Record (Name,Time,State) VALUES(?,?,'已註冊')";
                            PreparedStatement ps3 = con.prepareStatement(s3);
                            ps3.setString(1, rename);
                            ps3.setString(2, strDate);
                            ps3.executeUpdate();
                            ok="0";
                        } else {
                            SwingUtilities.invokeLater(new Runnable()////��?��?����?����?�����??��蹎��?�����??��謘extField���蕭??��
                            {
                                public void run()
                                {
                                    vcode.setText("");
                                }
                            });
                            showPass.setForeground(Color.RED);
                            showPass.setText("驗證失敗!!");
                        }

                    }
                    con.close();
                } catch (Exception e) {
                }
            }
        });

        showPass.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        showPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(showPass, java.awt.BorderLayout.PAGE_END);

        jLabel1.setFont(new java.awt.Font("新細明體", 0, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("請輸入驗證碼");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vcodeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tcplistenVcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tcplistenVcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tcplistenVcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tcplistenVcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tcplistenVcode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel showPass;
    private javax.swing.JTextField vcode;
    // End of variables declaration//GEN-END:variables
}
