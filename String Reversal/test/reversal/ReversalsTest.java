package reversal;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import reversal.IterativeReversal;
import reversal.QueueReversal;
//import reversal.RecursiveReversal;
import reversal.ReverseString;
//import reversal.StackReversal;
//import reversal.TreeMapReversal;
//import reversal.VectorReversal;

public class ReversalsTest
{
    protected ReverseTestBuilder _builder;
    protected boolean _emit;

    @Before
    public void setUp()
    {
        _builder = new ReverseTestBuilder();
        _emit = false;
    }

    /**
     * Main testing routine for reversals
     * @param rObj -- A ReverseString object: implements a reverse(String) method
     */
    private void test(ReverseString rObj)
    {
        System.out.print(rObj.getClass().getSimpleName() + "...");

        int index = 0;
        for (Map.Entry<String, String> pair : _builder.getTests().entrySet())
        {
            if (_emit) System.out.println("\t" + "Testing (" + (index++) + "): |" + pair.getKey() + "| |" + pair.getValue() + "|");
            
            if (!rObj.reverse(pair.getKey()).equals(pair.getValue()))
            {
                //System.out.println("Test Failed (" + pair.getKey() + ");   found   " + pair.getValue());
            	System.out.println("Test Failed (" + pair.getValue() + ");   found   " + rObj.reverse(pair.getKey()));
            }
            
            assertEquals(rObj.reverse(pair.getKey()), pair.getValue());
        }
        System.out.println("completed");
    }

    @Test
    public void testReverseIter()
    {
        test(new IterativeReversal());
    }

    @Test
    public void testReverseRecur()
    {
        test(new RecursiveReversal());
    }
    
    @Test
    public void testReverseStack()
    {
        test(new StackReversal());
    }

    @Test
    public void testReverseQueue()
    {
        test(new QueueReversal());
    }
    
    @Test
    public void testReverseVector()
    {
        test(new VectorReversal());
    }
   
    @Test
    public void testReverseTreeMap()
    {
//        test(new TreeMapReversal());
    }
}
