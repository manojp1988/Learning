package com.jonam;

public class StaticMethodTest {

	static int count;
	
	public static void raiseCounter(){
		for(int i=0; i<1000; i++){
			count++;
		}

		System.out.println(count);
	}
}
