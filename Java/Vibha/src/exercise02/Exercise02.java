package exercise02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import exercise.Exercise;
import exercise02.Adder.*;

public class Exercise02 extends Exercise{
	static String outputString;
	static String[] list;
	static int addOrSubtract;
	static int radix;
public Exercise02()
{
	
//Adds and Subtracts binary, octal or hexadecimal numbers 	
}
@Override
public void getInput()
{
	int countOfNumbers;
	ArrayList<String> temp=new ArrayList<>();
	
	Scanner scan=new Scanner(System.in);
	
	System.out.println("Press 1 to add. Press 2 to substract");
	addOrSubtract=scan.nextInt();
	if(addOrSubtract!=1&& addOrSubtract!=2)
	{	
				outputString= "invalid input";
	}
	System.out.println("Press 2 to add or subtract binary numbers. Press 8 for octal numbers. Press 16 for hexadecimal numbers");
	radix=scan.nextInt();
	if(radix!=2&& radix!=8&&radix!=16)
	{
				outputString="invalid input";
	}
	System.out.println("Enter the count of numbers");
	countOfNumbers=scan.nextInt();
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	int count=0;
	temp.add(scan.next());
	
		count++;

	while(count!=countOfNumbers)
	{
		temp.add(scan.next());
		count++;
	}
	
	list=temp.toArray(new String[0]);
	
}
@Override
public void execute()
{
	
	String val=list[0];
	
	for(int count=1;count<list.length;count++)
	{
		val=performOperation(val,list[count]);
	}
	outputString=val;
}
public static String performOperation(String value1,String value2)
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
	return "";
	
}


@Override
public void writeOutput()
{
	write(outputString);
}
}




