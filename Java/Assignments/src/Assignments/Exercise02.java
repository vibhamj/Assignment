package Assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Exercise02 extends Adder{
public static void main(String[] args) throws IOException
{

	String value1, value2;
	int radix;
	int countOfNumbers, addOrSubtract;
	String temp;
	
	Scanner scan=new Scanner(System.in);
	
	System.out.println("Press 1 to add. Press 2 to substract");
	addOrSubtract=scan.nextInt();
	if(addOrSubtract!=1&& addOrSubtract!=2)
	{
		System.out.println("invalid input");
				return;
	}
	System.out.println("Press 2 to add or subtract binary numbers. Press 8 for octal numbers. Press 16 for hexadecimal numbers");
	radix=scan.nextInt();
	if(radix!=2&& radix!=8&&radix!=16)
	{
		System.out.println("invalid input");
				return;
	}
	System.out.println("Enter the count of numbers");
	countOfNumbers=scan.nextInt();
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	int count=0;
	temp=scan.next();
	
		count++;

	while(count!=countOfNumbers)
	{
		value1=scan.next();
		count++;
		temp=performOperation(addOrSubtract,temp,value1,radix);
	}
	System.out.println(temp);
	}


static String performOperation(int addOrSubtract,String value1,String value2,int radix)
{
	if(addOrSubtract==1)
	{
	switch(radix)
	{
	case 2: BinaryAdder ba=new BinaryAdder();
	return ba.add(value1, value2, radix);
	case 8: OctaAdder oa=new OctaAdder();
	return oa.add(value1, value2, radix);
	case 16: HexAdder ha=new HexAdder();
	return ha.add(value1,value2,radix);
	default: return "";
	}
	}
	else if(addOrSubtract==2)
	{
	switch(radix)
	{
	case 2: BinaryAdder ba=new BinaryAdder();
	return ba.subtract(value1, value2, radix);
	case 8: OctaAdder oa=new OctaAdder();
	return oa.subtract(value1, value2, radix);
	case 16: HexAdder ha=new HexAdder();
	return ha.subtract(value1,value2,radix);
	default: return "";
	}
}
	else System.out.println("invalid operation choice");
	return "";
}
}

class Adder
{
	protected String add(String value1, String value2, int radix)
	{
		try{
			
		Integer result=Integer.parseInt(value1,radix) + Integer.parseInt(value2,radix);
		
			
			return (result.toString());
		
		
		}
		catch(Exception e)
		{
			System.out.println("number not in format"+e);
		}
		return "";
	}
	
	protected String subtract(String value1, String value2, int radix)
	{
		try{
			
		Integer result=Integer.parseInt(value1,radix) - Integer.parseInt(value2,radix);
		
		//System.out.println(Integer.parseInt(value1,radix));
		System.out.println(result);
		return result.toString();
		
		}
		catch(Exception e)
		{
			System.out.println("number not in format"+ e);
		}
		return "";
	}
	
}

class BinaryAdder extends Adder
{
	protected String add(String value1, String value2, int radix)
	{
		String value= super.add(value1, value2, radix);
		String result=Integer.toBinaryString(Integer.valueOf(value));
	    return result;
	}
	protected String subtract(String value1, String value2, int radix)
	{
		String value= super.subtract(value1, value2, radix);
		String result=Integer.toBinaryString(Integer.valueOf(value));
	    return result;
	}
}

class OctaAdder extends Adder
{
	protected String add(String value1, String value2, int radix)
	{
		String value= super.add(value1, value2, radix);
		String result=Integer.toOctalString(Integer.valueOf(value));
		return result;
	}
	protected String subtract(String value1, String value2, int radix)
	{
		String value= super.subtract(value1, value2, radix);
		String result=Integer.toOctalString(Integer.valueOf(value));
		return result;
	}
}

class HexAdder extends Adder
{
	protected String add(String value1, String value2, int radix)
	{
		String value= super.add(value1, value2, radix);
		String result=Integer.toHexString(Integer.valueOf(value));
		return result;
	}
	protected String subtract(String value1, String value2, int radix)
	{
		String value= super.subtract(value1, value2, radix);
		String result=Integer.toHexString(Integer.valueOf(value));
		return result;
	}
}