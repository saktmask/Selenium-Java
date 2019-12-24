package assignments;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// Declare a String text with the following value
		String text = "Tes12Le79af65";
		// Declare a int variable sum
		int sum = 0;

		//build a logic to get sum of all the digits from the given string

		/*
		 * Method 1
		 * Pseudo Code
		 * a) using replaceAll(), replace all the non-digits into ""
		 * b) Now, convert the String into array
		 * c) Iterate over the array and get each character
		 * d) Using Character.getNumericValue(), Change the char into int
		 * e) Add the values to sum & print
		 * 
		 */
		/*//Method1
		String text1=text.replaceAll("[1-9]", "");
		System.out.println("Updated String: "+text1);
		char[] ch = text1.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			//System.out.println(Character.getNumericValue(ch[i]));
			sum=sum+Character.getNumericValue(ch[i]);
		}
		System.out.println(sum);*/

		/*
		 * Method 2
		 * Pseudo Code
		 * 
		 * a) Iterate an  array over the String
		 * b) Get each character and check if it is a number using Character.isDigit()
		 * c) Now covert char to int using Character.isDigit() and add it to sum
		 * d) Now Print the value
		 */	

		//Method2
		int len=text.length();
		for (int i = 0; i < len; i++) {
			char ch=text.charAt(i);
			if(!Character.isDigit(ch))
			{
				sum=sum+Character.getNumericValue(ch);
				System.out.println(Character.getNumericValue(ch));
			}
		}
		System.out.println(sum);
	}

}
