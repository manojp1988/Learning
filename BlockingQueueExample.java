package concurrent;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {
	public static void main(String[] args) throws InterruptedException {
		
		DelayedElement<String> dElement = new DelayedElement<String>("A",1000);
		DelayQueue<DelayedElement> queue = new DelayQueue<DelayedElement>();
		queue.put(dElement);
		System.out.println("started");
		System.out.println(queue.take());
		
		
	}
}

class DelayedElement<T> implements Delayed {
	
	@Override
	public String toString() {
		return "DelayedElement [data=" + data + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8368911884027035810L;
	long startTime;

	T data;
	
	public DelayedElement(T data, long startTime) {
		this.data = data;
		this.startTime = System.currentTimeMillis() + startTime;
	}

	public int compareTo(Delayed o) {
		if(startTime < ((DelayedElement<?>)o).startTime) return -1;
		if(startTime > ((DelayedElement<?>)o).startTime) return 1;
		else return 0;
	}

	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

}