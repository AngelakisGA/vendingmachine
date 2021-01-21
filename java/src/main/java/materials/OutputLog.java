package materials;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class OutputLog {
	public static void main(String[] args) throws FileNotFoundException {
		
		File newFileFolder = new File("out.txt");
		LocalDateTime theDateTime = LocalDateTime.now();
		System.out.println("Date And Time");
		System.out.println(theDateTime.getYear());
		System.out.println(theDateTime.getMonth());
		System.out.println(theDateTime.getDayOfMonth());
		System.out.println(theDateTime.getHour());
		System.out.println(theDateTime.getMinute());
		
		String messageToAndyAndSean = "Hey guys. We tried! Womp Womp!";
		
		PrintWriter writer = new PrintWriter(newFileFolder.getAbsoluteFile());
		writer.print(theDateTime + " " + messageToAndyAndSean + " ");
		writer.flush();
		writer.close();
	}
}
