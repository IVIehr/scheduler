public class Task {
    private String name;
    private int duration;
    private int remainingTime;
    private int executedTime;
    private int arrivalTime;
    private int turnAroundTime;

    public Task(String name, int duration) {
        setName(name);
        setDuration(duration);
        remainingTime = duration;
        executedTime = 0;
    }

    public Task(String name, int duration, int arrivalTime) {
        setName(name);
        setDuration(duration);
        remainingTime = duration;
        executedTime = 0;
        this.arrivalTime = arrivalTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getExecutedTime() {
        return executedTime;
    }
    public void setExecutedTime(int executedTime) {
        this.executedTime = executedTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }
}
