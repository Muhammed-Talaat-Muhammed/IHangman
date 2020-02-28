package eg.edu.alexu.csd.datastructure.hangman.cs66;

import java.util.Scanner;

public class Test {
	  
	public static void main(String[] args){
		IHangmanClass cls = new IHangmanClass();
       cls.setMaxWrongGuesses(10);String y;
       y=cls.selectRandomSecretWord();
       Scanner sc = new Scanner(System.in);
       String wrd="";
       while(wrd!=null) {
    	   System.out.println("The character is :");
    	   char v = sc.next().charAt(0);
    	   try {
			wrd=cls.guess(v);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			break;
		}
    	   System.out.println(wrd);
    	   }
	}

}