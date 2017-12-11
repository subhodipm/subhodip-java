/**
Let A be a non-empty zero-indexed array consisting of N integers. 
A sum-distance of a pair of indices (P,Q), for 0<=P<=Q<N, is the value
A[P] + A[Q] + (Q -P).

For example, for the following array A: 
A[0] = 1
A[1] = 3
A[2] = -3

there are the following pair of indices: (0,0),(1,1),(2,2),(0,1),(1,2),(0,2), 
for each of which the sum-distance is defined as follows:

for (0,0) it is A[0] + A[0] + (0 - 0)
= 1 + 1 + 0 = 2,
for (1,1) it is A[1] + A[1] + (1 - 1)
= 3 + 3 + 0 = 6,
for (2,2) it is A[2] + A[2] + (2 - 2)
= (-3) + (-3) + 0 = -6,
for (0,1) it is A[0] + A[1] + (1 - 0)
= 1 + 3 + 1 = 5,
for (1,2) it is A[1] + A[2] + (2 - 1)
= 3 + (-3) + 1 = 1,
for (0,2) it is A[0] + A[2] + (2 - 0)
= 1 + (-3) + 2 = 0

Write a function 
		class Something { public int solution (int[] A);}

that given a zero-indexed array A consisting of N integers, 
returns the maximum sum-distance value for this array.

In the above example the function should return 6 for indices (1,1).

Given the following array A = {-8, 4, 0, 5, -3, 6} 
the function should return 4 + 6 + 5 - 1 = 14.

 */

/**
 * @author Subhodip Mukherjee
 *
 */
public class MaximumSumDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] Arr = {-8,4,0,5,-3,6};
		System.out.println("my result = "  + solution(Arr));

	}
    public static int solution(int[] Arr) {
    	
    	int sumOfP = Integer.MIN_VALUE;
        int sumOfQ = Integer.MIN_VALUE;
        for(int i = 0; i < Arr.length; i++){
        	sumOfP = Math.max(Arr[i] - i, sumOfP);
            sumOfQ = Math.max(Arr[i] + i, sumOfQ);
        }
        return sumOfP + sumOfQ;
    }

}
