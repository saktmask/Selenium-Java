package assignments;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {
		
		 /* Pseudo code 
		 * a) Split the String into array and iterate over it 
		 * b) Initialize another loop to check whether the word is there in the array 
		 * c) if it is available then increase and count by 1. 
		 * d) if the count > 1 then replace the word as "" 
		 * e) print the each word
		 */
		// Use the declared String text as input
		String text = "We learnt java basics as part of java sessions in week1";
		// Initialize an integer variable as count
		int count = 0;

		String[] test_array=text.split(" "); 
		int len=test_array.length;

		for(int i=0;i<len-1;i++){
			
			count=0;
			for(int j=i+1;j<len;j++){
				
				if(test_array[i].equals(test_array[j])){
			
					count++;
				}
			}
			if(count>=1){
				test_array[i]=test_array[i].replace(test_array[i],"");
			}
		}
		for(int i=0;i<=len-1;i++){
			System.out.print(test_array[i]+" ");
		}
	}
}
