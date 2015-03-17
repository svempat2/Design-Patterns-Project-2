package primeService.util;

/**
 *
 * @author Sandeep
 */

public class Debug
{

    private static int deBugValue;
        
    private static volatile Debug instance = null;
        
        private Debug() 
        { 

        }
             
        public static Debug getInstance() 
        {
           
           if(instance==null)
           { 
            synchronized (Debug.class)
            {
                if (instance == null) 
                {
                    instance = new Debug();
                }
            }
           }
            
            return instance;
        }

    /**
     * static method to set the vaalue for thr deBugValue
     *
     * @param A Integer
     */
    public void setValue(int deBug_Value)
    {
        deBugValue=deBug_Value;
    }

    /**
     * This method used to take deBug Level value and message to be 
     * printed and prints the input message if it is at required
     * debug level
     *
     * @param A Integer and a String 
     */
    public void printMessage(int deBugLevel,String message)
    {

        if((deBugLevel==deBugValue)&(deBugValue!=0))
        {
            System.out.println(message);
        }
    }
    
    /**
     * A default method for all classes for testing purpose
     *
     * @return It returns a String 
     */
    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }
}

