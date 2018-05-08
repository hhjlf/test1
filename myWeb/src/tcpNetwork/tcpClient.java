package tcpNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class tcpClient extends Thread {
	private Socket socket = null;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	private ProtocolMessage pm = new ProtocolMessage();
	private BufferedReader br = null;
	private String str = null;
	private String ID = null;
	private String receiver = null;
	public tcpClient() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			//socket = new Socket("localhost", 4444);
			socket = new Socket("192.168.0.25" ,4444);
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("What is You are name? : ");
			ID = br.readLine();
			pm.setSender(ID);
			pm.setProtocol(Protocol.ACCEPT);
			oos.writeObject(pm);
			System.out.println("What is the name what you want to talk : ");
			receiver = br.readLine();
			this.start();
			readMessage();
		} catch (IOException e) {
			close();
		} catch (Exception e) {
			close();
		}
	}
	
	public void receiveMessage(ProtocolMessage pm) {
		System.out.println(pm.getSender()+" : "+pm.getMessage());
	}

	public void sendMessage(ProtocolMessage pm) throws Exception {
		pm.setProtocol(Protocol.SEND_MESSAGE);
		oos.writeObject(pm);
	}

	public void close() {
		try {if(socket!=null)socket.close();} catch (IOException e) {}
	}
	public synchronized void run() {
		try {
			while(true) {
				pm = (ProtocolMessage) ois.readObject();
				switch(pm.getProtocol()){
					case Protocol.SEND_MESSAGE:								sendMessage(pm); break;
					case Protocol.RECEIVE_MESSAGE:							receiveMessage(pm); break;
					default:	 System.out.println("잘못된 프로토콜입니다");
				}
			}
		}catch(Exception e) {
			close();
		}
	}
	
	public void readMessage() throws Exception {
		while(true) {
			System.out.println("Input message : ");
			str = br.readLine();
			pm.setMessage(str);
			sendMessage(pm);
		}
	}
	
	public static void main(String[] args) {
		new tcpClient();
	}
}