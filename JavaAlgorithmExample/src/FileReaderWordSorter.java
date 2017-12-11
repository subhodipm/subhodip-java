/*
 *  Write A multi-threaded Java program that takes a text file 
 *  as input and prints the count of the occurrences of each word sorted in descending order. 
 *  For example the output should be similar to:
 *
 * 25035: [the]
 * 16081: [a]
 * 9439: [is]
 * 7759: [and]
 * 6182: [to]
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FileReaderWordSorter {
	
	public static boolean ASC = true;
	public static boolean DESC = false;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new FileReader("/Users/subhodipmukherjee/FileGen/1504787580789_textfile.txt"));
		//String inputLine = null;

		Map<String,Integer> conMap = new ConcurrentHashMap<String,Integer>();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		
		while (true){
			String inputLine = bufferedReader.readLine();
			if(inputLine == null){
				break;
			}
			@SuppressWarnings("unused")
			Future<?> future = executor.submit(new Callable<Void>(){

				@Override
				public Void call() throws Exception {
					String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");
					for(String word:words){
						if("".equals(word)) {
							continue;
						}
						//System.out.println("word found:"+word.toLowerCase());
						Integer occurrance = conMap.get(word.toLowerCase());
						if(occurrance == null){
							conMap.put(word.toLowerCase(), 1);
							continue;
						}
						conMap.put(word.toLowerCase(), occurrance+1);
					}
					return null;
				}
				
			});
		}
		
/*		while ((inputLine = bufferedReader.readLine()) != null) {
            String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");
            @SuppressWarnings("unused")
			Future<?> future = executor.submit(new Callable<Void>(){

				public Void call() {
					for(String word:words){
						if("".equals(word)) {
							continue;
						}
						//System.out.println("word found:"+word.toLowerCase());
						Integer occurrance = conMap.get(word.toLowerCase());
						if(occurrance == null){
							conMap.put(word.toLowerCase(), 1);
							continue;
						}
						conMap.put(word.toLowerCase(), occurrance+1);
					}
					return null;
				}
            	
            });
		}
*/		
		
		executor.shutdown();//all tasks are accepted
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bufferedReader.close();

		Map<String, Integer> sortedMapDesc = sortMapByComparator(conMap, DESC);
		printMap(sortedMapDesc);
	}
	/*
	 * This method is a helper method to sort the map in asc or desc order based on the value
	 */
    private static Map<String, Integer> sortMapByComparator(Map<String, Integer> unsortMap, final boolean order){

        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Here Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>(){
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
                if (order){
                    return o1.getValue().compareTo(o2.getValue());
                }
                else{
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        // Maintaining insertion order
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
	
    /*
	 * This method is a helper method to print the final map
	 */

    public static void printMap(Map<String, Integer> map){
        for (Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getValue()+": [" + entry.getKey() + "]");
        }
    }

}
