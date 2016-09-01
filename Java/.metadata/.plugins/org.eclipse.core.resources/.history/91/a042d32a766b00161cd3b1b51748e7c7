package exercise01;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Exercise01 {
public static void main(String[] args) throws FileNotFoundException, IOException
{
	 
	
		String lineOfText="";
		String substring="";
		int choice;
		Scanner scan=new Scanner(System.in);
		System.out.println("Press 1 to enter from console.Press 2 to read from file");
		choice=scan.nextInt();
		if(choice==1)
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the line of text");
		lineOfText=input.readLine();
		
        System.out.println("Enter the substring to find");
		substring=input.readLine();
		
		}
		else if(choice==2)
		{
			String filename;
			System.out.println("Enter the file name");
			filename=scan.next();
			try{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			if((lineOfText= reader.readLine())==null)
			{
				System.out.println("empty file");
			}
			substring=reader.readLine();
			}
			catch(FileNotFoundException e)
			{
			System.out.println("no such file");
			}
       
		}
		else
		{
			System.out.println("incorrect choice");
			return;
			
		}

		if(isFound(lineOfText,substring))
          System.out.println("Found substring");
        else
		  System.out.println("Did not find substring");
		
		
	}
		

public static boolean isFound(String lineOfText, String substring)
{
int i,j=0;
//iterate through the line of text
while(j<= lineOfText.length()-substring.length())
{
    //iterate through the substring
for(i=0;i<substring.length();i++)
{
	if(lineOfText.charAt(i+j)!=substring.charAt(i))
	{    
	break;
	}

	else
		return true;				   
}
j++;
}
return false;
}



}






	
	    
		






