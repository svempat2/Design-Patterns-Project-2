package primeService.util;

//import java.lang.boolean;



/**
 *
 * @author sandeep
 *
 */
public class CheckPrime
{
    static int number;

    /**
     *
     * constructor for CheckPrime
     *
     * @param int
     */

    public CheckPrime(int numberIN)
    {
        number=numberIN;
    }


    /**
     *
     *
     * @return boolean
     */

    public static boolean IsPrime()
    {
            for (int i = 2; i < number; i++)
            {
                if (number % i == 0 && i != number)
                    return false;
            }
            
            return true;
    }
    
    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }
}
