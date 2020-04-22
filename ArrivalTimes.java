import java.util.Random;
public class ArrivalTimes {
	public static void main(String[] args) {
		int[] interArrivalTimes = new int[100];
		Random rand = new Random();
		double sum = 0;
		// Loop that iterates 100 times
		for (int i = 0; i<100; i++) {
			interArrivalTimes[i] = 4+rand.nextInt(8-3); // Generate a random arrival time and store it in the array
			sum = sum + interArrivalTimes[i]; // add all arrival time to the sum
			System.out.println("Process "+i+" Arrival time: "+sum); // print out arrival time of process
			System.out.println("Inter-arrival Time:" + interArrivalTimes[i]); // Print out each arrival time
		}
		double avg = sum/100;
		System.out.print("Average arrival time is: " + avg);
	}
}