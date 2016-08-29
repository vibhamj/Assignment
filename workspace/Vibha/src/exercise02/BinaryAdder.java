package exercise02;

public class BinaryAdder extends Adder
{
	@Override
	protected final String add(String value1, String value2, int radix)
	{
		String value= super.add(value1, value2, radix);
		String result=Integer.toBinaryString(Integer.valueOf(value));
	    return result;
	}
	@Override
	protected final String subtract(String value1, String value2, int radix)
	{
		String value= super.subtract(value1, value2, radix);
		String result=Integer.toBinaryString(Integer.valueOf(value));
	    return result;
	}
}
