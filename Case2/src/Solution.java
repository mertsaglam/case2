import java.io.*; 
import java.math.*; 
import java.security.*; 
import java.text.*; 
import java.util.*; 
import java.util.concurrent.*; 
import java.util.function.*; 
import java.util.regex.*; 
import java.util.stream.*; 
import static java.util.stream.Collectors.joining; 
import static java.util.stream.Collectors.toList;

class Result { 
    public static int uniqueWolfs(List<Integer> arr) { 
 // Gelistirmeyi bu alana yapiniz 
        //new hashmap
        Map<Integer, Integer> counts = new HashMap<>();
        //count the occurences in the arr 
        for(int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) +1);
        }
        System.out.println("counts" + counts);
        //find the max occurence
        int maxCount = Collections.max(counts.values());
        //create a new arraylist if there exist another max occurence
        List<Integer> mostRepeated = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            //if maxcount are equal 
            if (entry.getValue() == maxCount) {
                mostRepeated.add(entry.getKey());
            }
        }

        int minValue = Collections.min(mostRepeated);

        // Return the result
        return minValue;
        

        
    }
        
        
} 
public class Solution { 
    public static void main(String[] args) throws IOException { 
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/out.txt")); 
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim()); 
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList()); 
        int result = Result.uniqueWolfs(arr); 
        bufferedWriter.write(String.valueOf(result)); 
        bufferedWriter.newLine(); 
        bufferedReader.close(); 
        bufferedWriter.close(); 
    } 
}