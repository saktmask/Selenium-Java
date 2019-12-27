package assignments;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {

		String input = "PayPal India";
		input=input.replace(" ", "");
		char[] ch=input.toCharArray();

		Map<Character, Integer> m= new LinkedHashMap<>();

		for (char c : ch) {
			if(m.containsKey(c)){
				m.put(c, m.get(c)+1);
			}
			else{
				m.put(c, 1);
			}
		}
		System.out.println(m);

		for (Entry<Character, Integer> eachEntry : m.entrySet()) {
			if(eachEntry.getValue()<=1){
				System.out.print(eachEntry.getKey());
			}
		}
	}
}
