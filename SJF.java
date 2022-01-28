import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SJF extends Scheduler {
    public SJF(ArrayList<Task> tasks) {
        queue = new PriorityQueue<>(Comparator.comparingInt(Task::getDuration));
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
