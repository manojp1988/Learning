package com.jonam;

public class MainApp {

	public static void main(String[] args) {

		Runner r1 = new Runner();
		Runner r2 = new Runner();

		r1.start();
		r2.start();
	}

}

class Runner extends Thread{

	@Override
	public void run() {
		int count = 0;
		StaticMethodTest.raiseCounter();
	}
	
}