package core09a;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter Line 1");
	
		String first = 	scanner.nextLine();
		System.out.println("Enter Line 2");
		String second = scanner.nextLine();
		
		 int a= Integer.parseInt(first.replaceAll("[^0-9]", ""));
		 int b= Integer.parseInt(second.replaceAll("[^0-9]", ""));
		 
		 if (a<b){System.out.println(b);}
		 else{System.out.println(a);}
		
		Instrument one = new Guitar(22,"Guitar",3);
		one.play();
		
		Instrument two = new Drums(21,"Drums",3);
		two.play();
		
		Instrument three = new Piano(21,"piano",3);
		three.play();
		
		Instrumentalist instr = new Instrumentalist();
		
		instr.perfomance(one);
		
		Instrument [] intstruments ={one,two,three};
		instr.performedAll(intstruments);
		
		
		String name = "some21232fbsl";
		
		System.out.println(name.charAt(2));
		System.out.println(name.contains("123"));
		System.out.println(name.startsWith("some"));
		System.out.println(name.startsWith("2", 4)); //chu e 2 na 5 pozucii;
		System.out.println(name.substring(5));
		System.out.println(name.substring(5,11));
		System.out.println(name.toUpperCase());
		System.out.println(name.toLowerCase());
		
		System.out.println(name.replaceAll("o", "aa"));
		System.out.println(name.replaceAll("[^0-9]", "oooo")); //Все відмінне від нуля по 9 буде замінено
		System.out.println(name.replaceAll("[^A-Za-z]", "oooo")); // Всі букви заберуться.
		
		String info = "my name is sasha";
		
		String[] strings = info.split(" ");
			
		for(String s: strings){
			System.out.println(s);
		}
		
	}

}
