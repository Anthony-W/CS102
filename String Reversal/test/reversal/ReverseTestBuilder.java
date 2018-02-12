package reversal;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class ReverseTestBuilder
{
    private static final int NUM_TESTS = 100;

    protected Random _rng;                 // Random number generation
    protected Map<String, String> _map;    // Map of test cases
    public Map<String, String> getTests() { return _map; }

    public ReverseTestBuilder()
    {
        _rng = new Random(0);
        _map = new TreeMap<String, String>();

        // Construct test map
        build();
    }

    /**
     * Generate the set of all test cases: random and semi-redundant
     */
    private void build()
    {
        final int MAX_LENGTH = 30;
        
        _map.put("", "");
        
        genRandom(NUM_TESTS, MAX_LENGTH);
        genRedundant(NUM_TESTS, MAX_LENGTH);
    }

    /**
     * Generate the set of random strings.
     * @param n -- the number of random Strings to generate
     * @param MAX -- the maximum length of the generated strings; the minimum length is 1. 
     */
    private void genRandom(int n, int MAX)
    {
        // generate n random strings of up to the MAX length
        for (int i = 0; i < n; i++)
        {
            String str = genRandomIndividual(_rng.nextInt(MAX - 1) + 1);

            _map.put(str, r(str));
        }
    }
    
    /**
     * Generate the set of semi-redundant strings (uses only a few characters).
     * @param n -- the number of random Strings to generate
     * @param MAX -- the maximum length of the generated strings; the minimum length is 1. 
     */
    private void genRedundant(int n, int MAX)
    {
        // generate n random strings of up to the MAX length
        for (int i = 0; i < n; i++)
        {
            String str = genRedundantIndividual(_rng.nextInt(MAX - 1) + 1);

            _map.put(str, r(str));
        }
    }

    /**
     * Generate a random individual of length n.
     * @param n -- length of resulting string.
     * @return random string.
     */
    private String genRandomIndividual(int n)
    {
        final int LOW_ASCII = 33;   // '!'  includes upper and lower case characters
        final int HIGH_ASCII = 125; // '}'
        
        return generateIndividual(n, LOW_ASCII, HIGH_ASCII);
    }

    /**
     * Generate a semi-redundant individual of length n.
     * @param n -- length of resulting string.
     * @return random string.
     */
    private String genRedundantIndividual(int n)
    {
        final int LOW_ASCII = 97;   // 'a'
        final int HIGH_ASCII = 102; // 'f'
        
        return generateIndividual(n, LOW_ASCII, HIGH_ASCII);
    }

    /**
     * Generates a random string containing characters between [low, high)
     * @param n -- number of random characters
     * @param low -- lower bound ASCII value for random character generation
     * @param high -- upper bound ASCII value for random character generation
     * @return String of length n containing random characters in the given range
     */
    private String generateIndividual(int n, int low, int high)
    {
        String s = "";

        for (int i = 0; i < n; i++)
        {
            s += (char)(low + _rng.nextInt(high - low));
        }

        return s;
    }

    /**
     * @return String based representation of the testing map.
     */
    public String toString()
    {
        String retS = "";
        for (Map.Entry<String, String> pair : _map.entrySet())
        {
            retS += "|" + pair.getKey() + "| |" + pair.getValue() + "|" + "\n";
        }
        return retS;
    }
    
    private String r(String s) { return s.isEmpty() ? "" : r(s.substring(1)) + s.charAt(0); }
}
