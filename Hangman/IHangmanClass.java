package eg.edu.alexu.csd.datastructure.hangman.cs66;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random; 
public class IHangmanClass implements IHangman{
	private String[] b;
	private char[] plord;
	private String Secwr;
	private int counter=0;
	private int maxTry;
	public static String[] readFILE() throws IOException {
		File file = new File("C:\\Users\\Mohamed\\eclipse-workspace\\dictionary.txt\\");
		FileReader FU = new FileReader(file);
		BufferedReader BUf = new BufferedReader(FU);
		Scanner reader = new Scanner(file);
		String s;int i=0;
		String [] y=null;
		while((s=BUf.readLine())!=null) {y=s.split(" ");i+=y.length;}
		String [] sr= new String[i];
		for(int j=0;j<i;j++) {sr[j]=reader.next();}
		BUf.close();
		reader.close();
		return sr;
	}


	public void setDictionary(String[] words)  {b =words;
	}
    public String selectRandomSecretWord() {Random gen = new Random();
    try {
		b=readFILE();
	} catch (IOException e) {
		// TODO Auto-generated catch block
	}
    int rad=gen.nextInt(b.length);
    Secwr=b[rad];
    plord=new char[Secwr.length()];
	for(int i=0;i<Secwr.length();i++) {plord[i]='-';}
    return b[rad];
	}
	public String guess(Character c) throws Exception{
		if((Secwr != null)&&(!Secwr.matches("^[a-zA-Z]*$"))&&(!Secwr.equals("")))
		{
			throw new Exception("Buggy secretword detected");
		}
		if(c==null) {return Secwr;}
	char []array=new char[Secwr.length()];
	Secwr.getChars(0, Secwr.length(), array, 0);
	int n=1;
	for(int j=0; j<array.length;j++) {if(Character.toLowerCase(c)==Character.toLowerCase(array[j])){
		plord[j]=c;n=0;}}
	if(n==1) {maxTry--;}
    if(maxTry==0) {return null;}
    String g="";
    for(int cn = 0;cn<plord.length;cn++) {g+=plord[cn];}
    if(!g.contains("-")) {return null;}
	return g.toLowerCase();
}
	
	public void setMaxWrongGuesses(Integer max) {if((max==null)||(max==0)) {maxTry=1;}
	else
		maxTry=max;
	}
}