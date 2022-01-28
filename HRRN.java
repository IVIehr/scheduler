import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HRRN extends Scheduler {

    public HRRN(ArrayList<Task> tasks) {
        queue = new PriorityQueue<>(Comparator.comparingInt(Task::getArrivalTime));
        queue.addAll(tasks);
    }

    public double responseRatio(Task task, int time) {
        task.setTurnAroundTime(time - task.getArrivalTime());
        return 1.0 + (task.getTurnAroundTime() * 1.0 / task.getDuration());
    }

    @Override
    public void schedule() {
        while (!queue.isEmpty() || currentTask != IDLE) {
            time++;
            if (currentTask == IDLE) {
                double maxHRRN = -1.0;
                Task max = queue.peek();

                for (Task t : queue) {
                    if (responseRatio(t, time) > maxHRRN) {
                        maxHRRN = responseRatio(t, time);
                        max = t;
                    }
                }
                queue.remove(max);
                currentTask = max;
            }

            currentTask.setRemainingTime(currentTask.getRemainingTime() - 1);
            printState();
            if (currentTask.getRemainingTime() == 0) {
                currentTask = IDLE;
            }
        }
    }
}
