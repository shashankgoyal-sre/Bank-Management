package DbConnection;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		//String s=sc.nextLine();
		 
StringBuilder st=new StringBuilder();
st.append(sc.nextLine());
		
		//String y="";
		char ch;
		
		for(int i=0;i<=st.length()-1;i++)
		{
			
			ch=st.charAt(i);
			
			int x=ch;
			
			if(ch=='a' || ch== 'i'|| ch=='e' || ch=='o'|| ch=='u')
			{
		  ch=(char)(x+1);
		 // y=y+ch;
		  st.setCharAt(i, ch);
			}
			else
			{
				st.setCharAt(i, ch);
			}
		}
		
		System.out.println(st);
		
	}

}
