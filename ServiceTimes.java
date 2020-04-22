import java.util.Random;
public class ServiceTimes{
	public static void main(String[] args) {
		int[] serviceTimes = new int[100];
		double sum = 0;
		Random rand = new Random();
		for (int i=0; i<100; i++) {
			serviceTimes[i]=2+rand.nextInt(5-1); // generate random service time min of 2 and max of 5
			sum = sum + serviceTimes[i]; // add service time to the sum
		}
		double avg = sum/100; // avg of all 100 process service times
		System.out.println("Average service time: " + avg);
	}
}