package MessageServer;

import java.nio.ByteBuffer;

public class MessageGreater {

	int smallBlockSize = 4 * 1024;
	int mediumBlockSize = 128 * 1024;

	private ByteBuffer Message = ByteBuffer.allocate(smallBlockSize);
	private ByteBuffer MessageLarge = ByteBuffer.allocate(mediumBlockSize);

	int count = 0;

	protected void StringToByte(String text) {
		String t = text + "\n";
		int cap = (t.length() * 2) + 2;
		int textCap = (text.length() * 2) + 2;
		if (Message.remaining() < cap) {
			System.out.println(Message.capacity() + "" + Message.remaining());
			int offSetLarge = MessageLarge.capacity()-MessageLarge.remaining();
			MessageLarge.put(offSetLarge, Message, position(MessageLarge), Message.capacity());
			MessageLarge.put(Message);
			System.out.println("Size Incremented");
			System.out.println(Message.capacity() + "" + Message.remaining());
			Message.clear();
		}
		int OffSet = Message.capacity() - Message.remaining();
		System.out.println(Message.remaining());
		Message.asCharBuffer().put(t, position(Message), text.length());
		count++;
		System.out.println(count);
		System.out.println(Message.remaining());
	}

	protected String ByteTOString() {
		char c;
		StringBuffer sb = new StringBuffer();
		if (MessageLarge.capacity() != Message.remaining()) {
			while ((c = MessageLarge.getChar()) != 0)
				sb.append(c);
			MessageLarge.clear();
		} else {
			while ((c = Message.getChar()) != 0)
				sb.append(c);
			Message.clear();
		}
		return sb.toString();
	}
	
	protected int position(ByteBuffer b) {
		char c;
		int count=0;
		while ((c = b.getChar()) != 0)
			count++;
		return count;
	}
}