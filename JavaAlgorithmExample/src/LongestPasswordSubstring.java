/*You would like to set a password for an email account. However, there are two
restrictions on the format of the password. It has to contain at least one
uppercase character and it cannot contain any digits.

You are given a string S consisting of N alphanumerical characters. You would
like to ﬁnd the longest substring of S that is a valid password. A substring is
deﬁned as a contiguous segment of a string.

For example, given "a0Ba", the substrings that are valid passwords are "B" and
"Ba". Note that "aBa" is not a substring and "a0B" is not a valid password.

Write a function:

class Solution { public int solution(String S); }

that, given a non-empty string S consisting of N characters, returns the length
of its longest substring that is a valid password. If there is no such substring,
your function should return -1.

For example, given "a0Ba", your function should return 2, as explained above.
Given "a0bb", your function should return -1, since there is no substring that
satisﬁes the restrictions on the format of a valid password.

Assume that:

- N is an integer within the range [1..200];
- string S consists only of alphanumerical characters (a-z and/or A-z and/or 0-9).

In your solution, focus on correctness. The performance of your solution will
not be the focus of the assessment.

*/

/**
 * @author Subhodip Mukherjee
 *
 */

public class LongestPasswordSubstring {

	public static void main(String[] args) {
		int i = solution("arrrrRR0uuuuuuuuuuBa");
		System.out.println(i);
	}
    public static int solution(String S) {
    	int start = 0;
    	int longestStartIndex = 0;
	    int end = 0;
	    int index = 0;
	    int longestLength = Integer.MIN_VALUE;
	    boolean foundUpper = false;
	    
	    
/*	    while(index <= S.length()){
	    	if(index == S.length() || Character.isDigit(S.charAt(index))){
	    		if(foundUpper && index > start && index - start > longestLength){
	    			longestLength = index -start;
	    			longestStartIndex = start;
	    			end = index;
	    		}
	    		start = index +1;
	    		foundUpper = false;
	    	}
	    	else if(Character.isUpperCase(S.charAt(index))){
	    		foundUpper = true;
	    	}
	    	index++;
	    }
*/	    while(index <= S.length()) {
	        if (index == S.length() || Character.isDigit(S.charAt(index))) {
	            if (foundUpper && index > start && index - start > longestLength) {
	                longestLength = index - start;
	                end = index;
	                longestStartIndex = start;
	            }
	            start = index + 1;
	            foundUpper = false;
	        } else if (Character.isUpperCase(S.charAt(index))) {
	            foundUpper = true;
	        }
	        index++;
	    }
        String longestPassSubStr = S.substring(longestStartIndex, end);
	    System.out.println(longestPassSubStr);
	    if( longestPassSubStr.length() == 0) return -1;
	    return longestPassSubStr.length();
    }

}
