package DoorApp;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class record {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String record[] = new String[3];
		for(int i=0;i<record.length;i++){
			record[i]="";
		}
		while(true){
			String ID = scn.next();
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			Date date = new Date();
			String strDate = sdFormat.format(date);
			record[0]= "ID"+ID+"  Time"+strDate;
			for(int i=0;i<record.length;i++){
				if(record[i].equals("")){				 
				}else{
					System.out.println(record[i]);
				}
			}
			for(int i =record.length-1;i>0;i--){
				record[i]=record[i-1];
			}
		}
	}	
}

