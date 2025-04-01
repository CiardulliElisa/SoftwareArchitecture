package framework.gamification;

public class AddPointsRule implements GameRule {

    private int numberOfPoints;

    public AddPointsRule(int points) {
        this.numberOfPoints = points;
    }

    public void executeBefore() {
        UserRegistry.getCurrentUser().addPoints(numberOfPoints);
    }


    public void executeAfter(Task task, Object result) {}


    public void executeWhenException(Task task, Exception ex) {}
}
