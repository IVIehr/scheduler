import java.util.Queue;

public abstract class Scheduler {
    protected static Task IDLE = new Task("idle", 0);

    protected Queue<Task> queue;
    protected int time;
    protected Task currentTask = IDLE;

    public abstract void schedule();

    public void printState() {
        System.out.println("------------------------------");
        System.out.println("time : " + time);
        System.out.println("current task: " + currentTask.getName());

        System.out.print("queue : ");
        for (Task t : queue) {
            System.out.print(t.getName() + " ");
        }

        System.out.println();
    }
}
