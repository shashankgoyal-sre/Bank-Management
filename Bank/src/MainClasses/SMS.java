package MainClasses;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.*;
public class SMS {

	
public String send(String messages,String number)
	{
		try {
			// Construct data
			String apiKey = "apikey=" +"CoK22QT+BF4-T0iCQLQtJkkJRFynGl9oaxJQG5FmG0";
			String message = "&message=" + messages;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" +number;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Long.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
			
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
		return "Error "+e;
			
		}
	}
	
	
	public static void main(String args[])
	{
		SMS s=new SMS();
		//System.out.println(s.SMS());
	}
	
	
	
	
	
	
}
