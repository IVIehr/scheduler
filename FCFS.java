import java.util.*;

public class FCFS extends Scheduler {
    public FCFS(ArrayList<Task> tasks) {
        queue = new LinkedList<>();
        queue.addAll(tasks);
    }

    @Override
    public void schedule() {
        while (!queue.isEmpty() || currentTask != IDLE) {
            time++;
            if (currentTask == IDLE) {
                currentTask = queue.poll();
            }
            currentTask.setRemainingTime(currentTask.getRemainingTime() - 1);
            printState();
            if (currentTask.getRemainingTime() == 0) {
                currentTask = IDLE;
            }
        }
    }
}
