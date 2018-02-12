public class PowerFunction
{
	public static int power(int x, int y)
	{
		if (y == 1) return x;
		
		return x * power(x, y-1);
	}
}

