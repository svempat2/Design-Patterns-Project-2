package primeService.driver;
import primeService.server.ServerDriver;
import primeService.server.ServerInterface;
import primeService.socket.PrimeServerSocket;
import primeService.socket.PrimeClientSocket;
import primeService.client.ClientInterface;
import primeService.client.ClientDriver;
import primeService.util.Debug;


/**
 *
 * @author Sandeep
 */
public class PrimeDriver
{

    /**
     * Main method to drive the client and the server menu 
     *
     */

	public static void main(String args[]) throws Exception
    {

		if(args.length < 2) {
			System.err.println("Usage:  FIXME\n");
			System.exit(1);
		}


        if(args[0].equals("server"))
        {
            if(args.length<2)
            {
                System.err.println("For Server there should be 2 command line arguments .\n 1. server \n 2. Portnumber\n");
                System.exit(1);
            }

            ServerInterface sd = new ServerDriver(Integer.parseInt(args[1]));
            sd.driveServer();


        }
        else if(args[0].equals("client"))
        {
            if(args.length<4)
            {
                System.err.println("For Client there should be 4 command line arguments .\n 1. Client \n 2. Portnumber\n 3.Host \n 4.debug\n");
                System.exit(1);
            }


        try
        {
            Debug.getInstance().setValue(Integer.parseInt(args[3]));
        }
        catch(NumberFormatException nfe)
        {
            System.err.println(nfe);
            System.exit(1);
        }

            ClientInterface cd = new ClientDriver(Integer.parseInt(args[1]),args[2]);
            cd.driveClient();

        }
        else
        {
			System.err.println("Command line argument 1 should be either 'server' or 'client' \n");
			System.exit(1);
        }

    }
}




