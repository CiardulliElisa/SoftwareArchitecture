package framework.gamification;

public interface Task {
    public Object execute() throws FailedExecutionException;
}
