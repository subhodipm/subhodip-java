
public class LongestSubStringMatchingInput {

	public static void main(String[] args) {
		findLongestSubArray(new int[]{1,5,7,2,3,1,1,2,1,6,1,5,7,2,3},12);

	}

	private static void findLongestSubArray(int[] inputArray, int inputInt) {
		
		int finalCnt = 0;
		String arr = "";
		
		int sum = inputArray[0];
		int start  = 0;
		for(int i = 1; i < inputArray.length; i++){
			sum = sum + inputArray[i];
			while (sum > inputInt && start <= i - 1){
				sum = sum - inputArray [start];
				start ++;
			}
			if(sum == inputInt){
				String dummyArr = "";
				int count = 0;
				for(int j = start; j<= i; j++){
					count ++;
					dummyArr = dummyArr + inputArray[j] + " ";
				}
				if (finalCnt < count){
					arr = dummyArr;
					finalCnt = count;
				}
				//System.out.println(count+ ":" +dummyArr);
			}
		}
		if (finalCnt > 0){
			System.out.println(finalCnt+ ":" + arr);
		}
	}



}
