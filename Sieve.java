import java.util.ArrayList;
import java.util.function.Predicate;

public class Sieve {

	private static int LAST_NUM = 100000;
	private ArrayList<Integer> primes = new ArrayList<Integer>(), numbers = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Sieve sieve = new Sieve();
		sieve.init();
		sieve.findPrimes();
	}
	
	// Method for the start of the program that will fill the numbers list with all the numbers between and including 2 and LAST_NUM
	public void init() {
		for (int i = 2; i <= LAST_NUM; i++) {
			numbers.add(i);
		}
	}
	
	//generates a Java 1.8 Predicate that will return true for numbers that are a multiple of num
	public Predicate<Integer> isMultipleOf(Integer num) {
        return i -> i % num == 0;
    }
	
	public void findPrimes() {
		long start = System.currentTimeMillis();
		
		while (numbers.size() > 0) { //will keep checking numbers until they are all either removed or determined to be prime
			int num = numbers.get(0); //grabs the first unsorted number in the numbers list that should be prime
			numbers.removeIf(isMultipleOf(num)); //removes all the multiples of the number
			primes.add(num); //adds the number to the primes list
		}
		
		long total = System.currentTimeMillis() - start;
		System.out.println(primes.size()); //outputs how many primes were found so it can be verified it found them all
		System.out.println((int)Math.floor(total / 60000.0) + " mins " + (int)(Math.ceil(total / 1000.0) % 60) + " seconds"); //outputs the time in minutes and seconds
		System.out.println("Milliseconds total: " + total); //outputs how many milliseconds it took
	}
}
