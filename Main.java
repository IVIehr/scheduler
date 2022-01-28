import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter the allocation strategy (FCFS/SJF/RR/HRRN):");
        String allocationStrategy = scan.next();
        System.out.print("Enter the number of tasks:");
        int tasksNumber = scan.nextInt();

        System.out.println("Enter name, duration and the arrival time of each task:");
        for (int i = 0; i < tasksNumber; i++) {
            String name = scan.next();
            int duration = scan.nextInt();
            int arrivalTime = scan.nextInt();
            Task task = new Task(name, duration, arrivalTime);
            tasks.add(task);
        }

        Scheduler scheduler;
        switch (allocationStrategy) {
            case "SJF" -> scheduler = new SJF(tasks);
            case "HRRN" -> scheduler = new HRRN(tasks);
            case "RR" -> scheduler = new RR(tasks);
            default -> scheduler = new FCFS(tasks);
        }
        scheduler.schedule();
    }
}
