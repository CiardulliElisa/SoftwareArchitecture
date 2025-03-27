package framework.gamification;

public class AddBadgeWhenOK implements GameRule{
    @Override
    public void executeBefore() {

    }

    @Override
    public void executeAfter(Task task, Object result) {
        if(("ok").equals(result)) {
            UserRegistry.getCurrentUser().addBadge("OKPerson");
        }
    }

    @Override
    public void executeWhenException(Task task, Exception ex) {

    }
}
