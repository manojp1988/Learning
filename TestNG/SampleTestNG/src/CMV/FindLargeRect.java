package CMV;

public class FindLargeRect {

	final static int CONST = 1;

	public static void main(String[] args) {

		System.out.println(findLargestRectangleByArea(new int[]{7,5,2,8,9}));
	}

	public static int findLargestRectangleByArea(int[] array){
		int maxArea=0;
		
		for(int i=0; i<array.length; i++){
			if((array[i]* CONST)>maxArea){
				maxArea = array[i]*CONST;
			}
			for(int j=0; j<i; j++){
				
				int startIndex = j;
				int endIndex = i;
				
				int minimumValue = MyArrays.getMinimum(array, startIndex, endIndex);
				if((minimumValue * (i-j+1) * CONST) > maxArea){
					maxArea = minimumValue * (i-j+1) * CONST;
				}
				
			}
		}
		return maxArea;
	}
}
