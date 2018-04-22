import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Gabriele La Greca
 * 
 */
public class WordCount {

    public Map<String, Integer> phrase(String ph) {
        StringBuffer buff = new StringBuffer();
        boolean flag = false;

        for (char ch : ph.toCharArray()) {

            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                buff.append(Character.toLowerCase(ch));
                flag = true;
                continue;
            }
            
            buff.append((ch == "'".charAt(0) && flag) ? ch : ' ');
            flag = false;
        }

        return countWords(buff.toString().split(" "));                            
    }

    private Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> map = new HashMap<>(words.length * 3);
        
        for (String x : words) {

            if (x.length() > 0 && !x.contains(" ")) {
                
                if (!map.containsKey(x)) {
                    map.put(x, 1);
                    continue;
                }

                map.replace(x, map.get(x) + 1);
            }
        }

        return map;
    }
}