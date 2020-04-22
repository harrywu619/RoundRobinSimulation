public class RoundRobin {
	public static void main(String[] args) {
		int[] serviceTimes = {75,40,25,20,45};
		int[] initialServiceTimes = {75,40,25,20,45};
		int[] arrivalTimes = {0,10,10,80,85};
		int[] startTimes = new int[5];
		int[] endTimes = new int[5];
		int[] initialWaitTimes = new int[5];
		int[] totalWaitTimes = new int[5];
		boolean[] pass = {Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE};
		int totalTime = 0;
		int quantum = 15;
		int i = 0;
		while (totalTime < 205) {
			if(serviceTimes[i] == initialServiceTimes[i] && totalTime >= arrivalTimes[i]) { // start time of process is when it's first served
				startTimes[i] = totalTime;
			}
			if (totalTime >= arrivalTimes[i]) {
				if (serviceTimes[i] >= quantum) { // if service time is equal or greater to quantum, the quantum subtracts from process service time
					totalTime = totalTime + quantum; // add quantum to total process time
					serviceTimes[i] = serviceTimes[i] - quantum;
					System.out.print("[P"+(i+1)+"]"+(totalTime));
				}
				else if (serviceTimes[i]<15 && pass[i] == Boolean.TRUE) { // if service time < 15, it takes the remaining service time
					totalTime = totalTime + serviceTimes[i]; // add it to the total process time
					serviceTimes[i] = 0;
					System.out.print("[P"+(i+1)+"]"+(totalTime));
				}
				if (serviceTimes[i] == 0 && pass[i] == Boolean.TRUE) { // endtime = when the process finishes or when its service time reaches 0
					endTimes[i]=totalTime;
					pass[i] = Boolean.FALSE; // pass check is turned to false since we no longer need to check this process after it ends
				}
			}
			i++;
			if (i==5) { // go back to process 1 when the end is reached
				i=0;
			}
		}
		System.out.println("");
		// calculating initial/total wait times for each process and outputting them
		for (int j = 0; j<5; j++) {
			initialWaitTimes[j] = startTimes[j]-arrivalTimes[j];
			totalWaitTimes[j] = endTimes[j] - initialServiceTimes[j] - arrivalTimes[j];
			System.out.println("Start Time for Process "+(j+1)+": " + startTimes[j]);
			System.out.println("End Time for Process "+(j+1)+": " + endTimes[j]);
			System.out.println("Initial Wait Time for Process "+(j+1)+": " + initialWaitTimes[j]);
			System.out.println("Total Wait Time for Process "+(j+1)+": " + totalWaitTimes[j]);
		}
	}
}