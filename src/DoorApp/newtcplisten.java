package DoorApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//  ww w.  j a v a 2 s  . c  om
public class newtcplisten {
	protected static String tcpcardNumber="";
  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(8031, 100,
        InetAddress.getByName("192.168.1.100"));
    System.out.println("Server started  at:  " + serverSocket);
    tcplistenVcode vcode=new tcplistenVcode();
    vcode.setVisible(true);
    while (true) {
      System.out.println("Waiting for a  connection...");

      final Socket activeSocket = serverSocket.accept();

      System.out.println("Received a  connection from  " + activeSocket);
      Runnable runnable = () -> handleClientRequest(activeSocket);
      new Thread(runnable).start(); // start a new thread
    }
  }

  public static void handleClientRequest(Socket socket) {
    try{
      BufferedReader socketReader = null;
      BufferedWriter socketWriter = null;
      socketReader = new BufferedReader(new InputStreamReader(
          socket.getInputStream()));
      socketWriter = new BufferedWriter(new OutputStreamWriter(
          socket.getOutputStream()));

      String inMsg = null;
      while ((inMsg = socketReader.readLine()) != null) {
    	tcpcardNumber=inMsg;
    	tcplistenToDB tcpTodb=new tcplistenToDB();
    	tcpTodb.run();
    	tcpTodb.tcpcardNumber="";
        System.out.println("Received from  client: " + inMsg);

        String outMsg = inMsg;
        socketWriter.write(outMsg);
        socketWriter.write("\n");
        socketWriter.flush();
      }
      socket.close();
    }catch(Exception e){
      e.printStackTrace();
    }

  }
}