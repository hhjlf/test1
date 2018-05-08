package tcpNetwork;

import java.io.Serializable;

public class ProtocolMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	int protocol;
	String sender;
	String receiver;
	String message;

	public ProtocolMessage() {
		this.protocol = 0;
		this.receiver = "";
		this.sender = "";
		this.message = "";
	}
	
	public ProtocolMessage(int protocol, String receiver, String sender, String message){
		this.protocol= protocol;
		this.sender= sender;
		this.receiver= receiver;
		this.message= message;
	}
	
	public void setProtocol(int protocol){ this.protocol= protocol; }
	public void setSender(String ID_sender){ this.sender= ID_sender; }
	public void setReceiver(String ID_receiver){ this.receiver= ID_receiver; }
	public void setMessage(String message){ this.message= message;}
	
	public int getProtocol(){ return protocol;	}
	public String getSender(){	return sender;	}
	public String getReceiver(){	 return receiver;	}
	public String getMessage(){ return message; }
}