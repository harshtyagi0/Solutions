package MessageServer;

import java.util.*;

public class MessageQueue {
	private MessageGreater M = new MessageGreater();
	private Queue<String> MessageQ = new PriorityQueue<>();
	
	public void putMessage(String s) {
		MessageQ.add(s);
		sendMessage();
	}

	protected void sendMessage() {
		
		M.StringToByte(MessageQ.poll());

	}

	public void showMessage() {
		System.out.println(M.ByteTOString());
	}

	public int queueSize() {
		return MessageQ.size();
	}
}