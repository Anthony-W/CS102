import static org.junit.Assert.*;

import org.junit.Test;

public class ULintTest
{

	@Test
	public void test()
	{
		ULint num = new ULint(38456351);
		ULint num2 = new ULint(38456351);
		System.out.println(num.compareTo(num2));
	}

}
