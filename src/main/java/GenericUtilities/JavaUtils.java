package GenericUtilities;

import java.util.Random;

public class JavaUtils {
	public int getRandomNumber() {
		Random r=new Random();
		int random=r.nextInt();
		return random;			
	}
}
