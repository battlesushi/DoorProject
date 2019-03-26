package DoorApp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;
import DoorApp.SerialClass;
import DoorApp.SerialClass;
import java.io.IOException;

public class TestClass
{
//public static BufferedReader input;
public static OutputStream output;

public static synchronized void writeData(String data) {
System.out.println("Sent: " + data);
try {
output.write(data.getBytes());
} catch (Exception e) {
System.out.println("could not write to port");
}
}

public void run(){
	try
	{
	SerialClass obj = new SerialClass();
	int c=0;
	obj.initialize();
	//input = SerialClass.input;
	//output = SerialClass.output;
	DoorJFrame dfinput=new DoorJFrame();
	String ok = dfinput.ok;
	
	//InputStreamReader Ir = new InputStreamReader(System.in);
	//BufferedReader Br = new BufferedReader(Ir);
	while (c==0)
	{
	c = Integer.parseInt(ok);

	switch(c)
	{
	case 1:
	writeData("1");;
	break;

	case 2:
	writeData("0");
	break;

	}
	}

	//String inputLine=input.readLine();
	//System.out.println(inputLine);

	obj.close();

	}
	catch(Exception e){}

	}
}

