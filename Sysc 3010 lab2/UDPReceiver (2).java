
import java.net.*;

public class UDPReceiver {

	private final static int PACKETSIZE = 100 ;

	public static void main( String args[] )
	{
            String data2= "";
	      // Check the arguments
	      if( args.length != 1 )
	      {
	         System.out.println( "usage: UDPReceiver port" ) ;
	         return ;
	      }
	      try
	      {
	         // Convert the argument to ensure that is it valid
	         int port = Integer.parseInt( args[0] ) ;
                
	         // Construct the socket
	         DatagramSocket socket = new DatagramSocket( port ) ;
                 DatagramSocket socket2 = new DatagramSocket() ;
	         for( ;; )
	         {
		        System.out.println( "Receiving on port " + port ) ;

		        DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
	            socket.receive( packet ) ;

                    data2 = "ACK: " + new String(packet.getData()).trim();
                    byte [] data = data2.getBytes() ;
	            System.out.println( packet.getAddress() + " " + packet.getPort() + "ACK: " + new String(packet.getData()).trim() ) ;
                    DatagramPacket packet2 = new DatagramPacket( data, data.length, packet.getAddress(), 1002) ;
                    socket2.send( packet2 ) ;
	        }  
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
  }
}

