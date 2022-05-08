package MessageServer;

public class Test {
	public static void main(String[] args) {
		MessageQueue MQ = new MessageQueue();
		MQ.putMessage("GoodEvening");
		MQ.putMessage("WhatsUp");
		int s = MQ.queueSize();
		MQ.showMessage();
	}
}