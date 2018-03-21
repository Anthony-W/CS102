
public class Main
{

	public static void main(String[] args)
	{
		System.out.println(loop(1024));
	}

	
	private static double loop(float n)
	{
		float sum = 0;
		/*
		for (float i = 1/(2*n); i <= 1-1/(2*n); i += 1/n)
		{
			for (float j = 1/(2*n); j <= 1-1/(2*n); j += 1/n)
			{
				System.out.println(i + ", " + j);
				sum += calculate(i,j, n);
			}
		}
		*/
		float x, y;
		for (float i = 1; i <= n; i++)
		{
			for (float j = 1; j <= n; j++)
			{
				x = (i/n)-1/(2*n);
				y = (j/n)-1/(2*n);
				System.out.println(x + ", " + y);
				sum += calculate(x,y, n);
			}
		}
		
		return sum;
	}
	
	private static double calculate(double x, double y, double n)
	{
		return Math.sqrt(1 + x * Math.pow(Math.E, -y)) / (n*n);
	}
}
