package exercise02;

public class Adder
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
