package Week5;
import java.util.*;
public class MapPrinterMain {
	public static void main(String [] args) {
		Map<String, String> contact = new HashMap<>();
		contact.put("Alice", "555-1234");
		contact.put("Robert", "555-6789");
		
		MapPrinter map1 = new MapPrinter();
		System.out.println("----Keys----");
		map1.printKeys(contact);
		System.out.println("----Values----");
		map1.printValues(contact);
		System.out.println("----Pairs----");
		map1.printPairs(contact);
		
	}
}
