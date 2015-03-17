package primeService.server;

import primeService.util.Debug;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 *
 * @author sandeep
 *
 */

public class AllPrimeQueries 
{
        private static volatile AllPrimeQueries instance = null;
        private Map<String,String> hl;//= new ConcurrentHashMap<String, String>();
        

        /**
         *
         *
         * constructor for AllPrimeQueries
         *
         */

        private AllPrimeQueries() 
        { 
            hl = new ConcurrentHashMap<String, String>();
            Debug.getInstance().printMessage(2,"Constructors for AllPrimeQueries");

        }
        

        /**
         *
         * @return AllPrimeQueries object
         *
         *
         */

        public static AllPrimeQueries getInstance() 
        {
           
           if(instance==null)
           { 
            synchronized (AllPrimeQueries.class)
            {
                if (instance == null) 
                {
                    instance = new AllPrimeQueries();
                }
            }
           }
            
            return instance;
        }


        /**
         *
         * @return void
         *
         *
         */
        
        public void sendMessage(String clientName, String number)
        {
            String exist_param = null;
            //System.out.println(clientName+" "+number);
            if(hl.containsKey(clientName)) 
            {
                exist_param = hl.get(clientName);
                exist_param= exist_param+" "+number;
            }
            else
            {
               //System.out.println(clientName+" entered into notexistng "+number);
                exist_param = number;    
            }                
            
            hl.put(clientName,exist_param);
             
        }
    
        public String toString() {
	
            String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	
            return retValue;
    
        }


        /**
         *
         *
         *
         * @return String
         *
         */

        public String getClientDetails(String clientName)
        {
            String details = null;
            if(hl.containsKey(clientName))
            {
                //System.out.println(clientName+" entered into existng clientdetails ");
                details = clientName + " " + hl.get(clientName);
            }
            else
            {
                //System.out.println(clientName+" entered into not existng clientdetails ");
                details = clientName+" doesn't exists";
            }
            
            return details;
        }

        /**
         *
         * @return void
         */
        
        public void printAllClientDetails()
        {
            if(!hl.isEmpty())
            {
                Set<String> setOfKeys = hl.keySet();
                Iterator<String> iterator = setOfKeys.iterator();
                while (iterator.hasNext())
                {
                    String key = (String)iterator.next();                       
                    String value = (String)hl.get(key);                       
                    System.out.println( key + " " + value);
                }
            }
        }

}
