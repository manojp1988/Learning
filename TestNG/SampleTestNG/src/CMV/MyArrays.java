package CMV;


public class MyArrays {
	
	private MyArrays(){}

	public static int getMinimum(int[] array, int startIndex, int endIndex){
		int minimumVal = Integer.MAX_VALUE;
		for(int i=startIndex; i==endIndex || i<array.length;i++){
			if(array[i] < minimumVal){
				minimumVal = array[i];
			}
		}
		return minimumVal;
	}
}
