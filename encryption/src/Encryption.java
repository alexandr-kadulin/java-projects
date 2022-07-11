import java.util.*;

public class Encryption {
	
	private Scanner scanner;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private char[] letters;
	
	Encryption() {
		
		scanner = new Scanner(System.in);
		list = new ArrayList<Character>();
		shuffledList = new ArrayList<Character>();
		character = ' ';
		
		newKey();
		question();
	}
	
	private void question() {
		
		while (true) {
			System.out.println("************************************************");
			System.out.println("Select an option");
			System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
			
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch (response) {
			
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
				
			default:
				System.out.println("There is no such option");
			}
		}
	}
	
	private void newKey() {
		
		character = ' ';		
		list.clear();
		shuffledList.clear();
		
		for (int i = 32; i < 127; i ++) {
			list.add(Character.valueOf(character));
			character ++;
		}
		
		shuffledList = new ArrayList<Character>(list);
		
		Collections.shuffle(shuffledList);
		
		System.out.println("New key has been generated");
	}
	
	private void getKey() {
		
		System.out.println("Key: ");
		
		for (Character item : list) {
			System.out.print(item);
		}
		
		System.out.println();
		
		for (Character item : shuffledList) {
			System.out.print(item);
		}
		
		System.out.println();
	}
	
	private void encrypt() {
		
		System.out.println("Enter a message to be encrypted: ");
		
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (letters[i] == list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		
		System.out.println("Encrypted: ");
		
		for (char k : letters) {
			System.out.print(k);
		}
		
		System.out.println();
	}
	
	private void decrypt() {
		
		System.out.println("Enter a message to be decrypted: ");
		
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < shuffledList.size(); j++) {
				if (letters[i] == shuffledList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
			}
		}
		
		System.out.println("Decrypted: ");
		
		for (char k : letters) {
			System.out.print(k);
		}
		
		System.out.println();
	}
	
	private void quit() {
		
		System.out.println("Exit");
		System.exit(0);
	}
}
