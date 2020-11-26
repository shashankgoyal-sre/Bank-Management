package DbConnection;

import java.util.Hashtable;

import com.email.durgesh.Email;

public class Test {

	public static void main(String[] args) {
	
/*	try {
		int a=10;
		
		Email email=new Email("chandigarhmohali38","chandigarh@38");
		email.setContent("chandigarhmohali38@","Welcome to our Bank");
		email.setSubject("This is for testing");
		
        //email.setContent(a,"text/html");
		
        email.setContent("j<br>"+a+"","text/html");
        
       //email.setContent("<br>","text/html");
       //email.setContent("j","text/html");
		email.addRecipient("shashanksre8@gmail.com");
		email.send();
	} catch (Exception e) {
		System.out.println("Exception:"+e);
	}*/
		int otp=(int)(Math.random()*1000000);
		String otp1=Integer.toString(otp);
		
		System.out.println(otp);
         System.out.println(otp1);		
		
		
	
	}

}
