import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class Sieve2 {

	private static int LAST_NUM = 100000;
	private ArrayList<Integer> primes = new ArrayList<Integer>(), numbers = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Sieve2 sieve = new Sieve2();
		sieve.init();
		sieve.findPrimes();
	}
	
	// Method for the start of the program that will fill the numbers list with all the numbers between and including 2 and LAST_NUM
	public void init() {
		for (int i = 2; i <= LAST_NUM; i++) {
			numbers.add(i);
		}
	}
	
	public void findPrimes() {
		long start = System.currentTimeMillis();
		
		while (numbers.size() > 0) {
			int num = numbers.get(0);
			Iterator<Integer> iter = numbers.iterator();
			while (iter.hasNext()) {
				Integer item = iter.next();
				if (item.intValue() % num == 0) {
					iter.remove();
				}
			}
			primes.add(num);
		}
		long total = System.currentTimeMillis() - start;
		System.out.println(primes.size()); //outputs how many primes were found so it can be verified it found them all
		System.out.println((int)Math.floor(total / 60000.0) + " mins " + (int)(Math.ceil(total / 1000.0) % 60) + " seconds"); //outputs the time in minutes and seconds
		System.out.println("Milliseconds total: " + total); //outputs how many milliseconds it took
	}
}

