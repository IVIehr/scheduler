import java.util.ArrayList;
import java.util.LinkedList;

public class RR extends Scheduler {
    private static final int QUANTUM = 2;

    public RR(ArrayList<Task> tasks) {
        queue = new LinkedList<>();
        queue.addAll(tasks);
        for (Task t : queue) {
            t.setRemainingTime(QUANTUM);
        }
    }

    @Override
    public void schedule() {
        while (!queue.isEmpty() || currentTask != IDLE) {
            time++;
            if (currentTask == IDLE) {
                currentTask = queue.poll();
            }
            currentTask.setRemainingTime(currentTask.getRemainingTime() - 1);
            currentTask.setExecutedTime(currentTask.getExecutedTime() + 1);
            printState();
            if (currentTask.getRemainingTime() == 0) {
                int totalRemainingTime = currentTask.getDuration() - currentTask.getExecutedTime();
                if (totalRemainingTime > 0) {
                    currentTask.setRemainingTime(Integer.min(QUANTUM, totalRemainingTime));
                    queue.add(currentTask);
                }
                currentTask = IDLE;
            }
        }
    }
}
