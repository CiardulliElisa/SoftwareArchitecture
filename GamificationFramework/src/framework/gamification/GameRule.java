package framework.gamification;

public interface GameRule {

    public void executeBefore();

    public void executeAfter(Task task, Object result);

    public void executeWhenException(Task task, Exception ex);
}
