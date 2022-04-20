package MyClass;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class tmp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("網址 = ");
		String urlString = scanner.next();
		
		try {
			URL url = new URL("https://pdfmyurl.com/?url=" + urlString);
			URLConnection connection =  url.openConnection();
			connection.connect();
			
			BufferedOutputStream bout = 
					new BufferedOutputStream(
							new FileOutputStream("dir1/brad.pdf"));
			
			BufferedInputStream bin = new BufferedInputStream(connection.getInputStream());
			byte[] buf = new byte[4*1024];
			int len;
			while ( (len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			bin.close();
			
			bout.flush();
			bout.close();
			System.out.println("download OK");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}

}