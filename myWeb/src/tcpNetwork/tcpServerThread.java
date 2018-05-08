package tcpNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;



public class tcpServerThread extends Thread{
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private HashMap <String, tcpServerThread>clientList = null;
	private ProtocolMessage pm = new ProtocolMessage();
	
	
	public tcpServerThread(Socket socket, HashMap<String, tcpServerThread> clientList){
		this.socket = socket;
		this.clientList = clientList;
	}

	public synchronized void run(){
		try{
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			while(true){
				pm = (ProtocolMessage) ois.readObject();
				switch(pm.getProtocol()){
					case Protocol.SEND_MESSAGE:								sendMessage(pm); break;
					case Protocol.RECEIVE_MESSAGE:							receiveMessage(pm); break;
					case Protocol.ACCEPT:											accept(pm); break;
					default:	 System.out.println("잘못된 프로토콜입니다");
				}
			}
		}catch(IOException e){
			close();
		} catch (ClassNotFoundException e) {
			close();
		} catch (Exception e) {
			close();
		}
	}
	
	public void accept(ProtocolMessage pm) throws Exception {
		clientList.put(pm.getSender(), this);
	}

	public void sendMessage(ProtocolMessage pm) throws Exception {
		tcpServerThread t = clientList.get(pm.getReceiver());
		pm.setProtocol(Protocol.RECEIVE_MESSAGE);
		t.send(pm);
	}
	
	public void receiveMessage(ProtocolMessage pm) throws Exception {
		System.out.println(pm.getMessage());
	}
	
	public void send(ProtocolMessage pm) throws Exception {
		oos.writeObject(pm);
	}
	
	public void close() {
		try {socket.close();} catch (IOException ee) {	}
	}
}