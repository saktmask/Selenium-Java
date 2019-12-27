package Learning;

import java.util.ArrayList;
import java.util.List;

public class LearnList {

	public static void main(String[] args) {
		
		String text="Amazon Private Limited";
		String temp="";
		List<Character> li=new ArrayList<>();
		/*li.add(text.replace(" ", ""));*/
		char[] ch=text.toCharArray();
		int len=ch.length;
		System.out.println(len);
		for(int i=len-1;i>=0;i--)
		{
			li.add(ch[i]);
			temp=temp+ch[i];
			
		}
		System.out.println(temp.replace(" ", ""));
	}

}
