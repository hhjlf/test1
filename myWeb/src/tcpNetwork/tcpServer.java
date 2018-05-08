package tcpNetwork;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class tcpServer{
	private ServerSocket serverSocket;
	public static HashMap<String, tcpServerThread> clientList = new HashMap <String, tcpServerThread>();

	public tcpServer(){
		try{
			serverSocket = new ServerSocket(4444);
			System.out.println("Server Start");
			while(true){
				Socket socket = serverSocket.accept();
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println(inetAddress.getHostAddress()+" is accept");
				tcpServerThread t = new tcpServerThread(socket, clientList);
				t.start();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		new tcpServer();
	}
}