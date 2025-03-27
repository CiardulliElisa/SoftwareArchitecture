package framework.gamification.test;

import framework.gamification.FailedExecutionException;
import framework.gamification.Task;

public class DummyTask implements Task {

    public Object execute() throws FailedExecutionException {
        return "done";
    }
}
