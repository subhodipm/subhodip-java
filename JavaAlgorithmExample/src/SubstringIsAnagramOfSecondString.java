import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Two string are considered and check whether Anagram of the second string is 
//present in the first string as part of it (Substring)
//e.g. 'atctv' 'cat' will return true as 'atc' is anagram of cat
//Similarly 'battex' is containing an anagram of 'text' as 'ttex'

public class SubstringIsAnagramOfSecondString {
	
	public static boolean isAnagram(String str1, String str2){
		//System.out.println(str1+"::" + str2);
		Character[] charArr = new Character[str1.length()];
		
		for(int i = 0; i < str1.length(); i++){
			char ithChar1 = str1.charAt(i);
			charArr[i] = ithChar1;
		}
		for(int i = 0; i < str2.length(); i++){
			char ithChar2 = str2.charAt(i);
			for(int j = 0; j<charArr.length; j++){
				if(charArr[j] == null) continue;
				if(charArr[j] == ithChar2){
					charArr[j] = null;
				}
			}
		}
		for(int j = 0; j<charArr.length; j++){
			if(charArr[j] != null)
				return false;
		}
		return true;
	}
	
	public static boolean isSubStringAnagram(String firstStr, String secondStr){
		int secondLength =  secondStr.length();
		int firstLength =  firstStr.length();
		if(secondLength == 0) return true;
		if(firstLength < secondLength || firstLength == 0) return false;
		//System.out.println("firstLength:"+ firstLength +" secondLength:" + secondLength+ 
				//" firstLength - secondLength:" + (firstLength - secondLength));

		for(int i = 0; i < firstLength - secondLength +1; i++){
			if(isAnagram(firstStr.substring(i, i+secondLength),secondStr )){
				return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args) {
		System.out.println("isSubStringAnagram(xyteabc,bca): "+ isSubStringAnagram("xyteabc","ate"));

	}

}
