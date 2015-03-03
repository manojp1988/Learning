/*
In java, network connections, database urls  etc uses string as
parameter. So that even if the reference is changed after assign the
value to the connection, the underlying method who uses the method will
not change..

This provides security..
*/

public class StringImmutable {
	public static void main(String[] args) {
		String s = "ABC";
		StringBuffer sb = new StringBuffer("ABC");
		Thread t = new Thread(new ThreadSample(sb));
		t.start();
		sb.append(" Fool!!");
	}
}
class ThreadSample implements Runnable {
	StringBuffer url;
	public ThreadSample(StringBuffer url) {
		super();
		this.url = url;
	}
	public void run() {
		new Connection().makeConnection(url);
	}
}
class Connection {
	public void makeConnection(StringBuffer con) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Making connection ..." + con);
	}
}