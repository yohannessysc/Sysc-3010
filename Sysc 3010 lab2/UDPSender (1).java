import java.net.*;
import java.util.Scanner;

public class UDPSender {

	public static void main(String[] args) 
   {
	      // Check the arguments
	      if( args.length != 3 )
	      {
	         System.out.println( "usage: java UDPSender host port" ) ;
	         return ;
	      }
	      DatagramSocket socket = null ;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host  = InetAddress.getByName( args[0] ) ;
	         int port          = Integer.parseInt( args[1] ) ;
		 int messageNumber = Integer.parseInt( args[2]) ; 
	         socket = new DatagramSocket() ;
     
	         Scanner in;
	         in = new Scanner (System.in);
	         String message = null;
                 DatagramSocket socket2 = new DatagramSocket( 1002 ) ;
                 
	         while (true)
	         {
				
	        		 System.out.println("ENTER to quit ");
				 for(int i=1; i<=messageNumber;i++){
	        		 message = "Message" + i;
	        		 if (messageNumber==0) break;
	        		 byte [] data = message.getBytes() ;
	        		 DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	        		 socket.send( packet ) ;
                                 System.out.println("Waiting for ACK");
                                 socket2.receive( packet ) ;
                                 
}
break;
	         } 
	         System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}

