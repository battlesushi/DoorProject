package DoorApp;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class tcpTestClass
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
	tcplistenToDB tcpinput=new tcplistenToDB();
	String ok = tcpinput.ok;
	
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

