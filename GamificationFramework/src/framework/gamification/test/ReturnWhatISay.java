package framework.gamification.test;

import framework.gamification.FailedExecutionException;
import framework.gamification.Task;

public class ReturnWhatISay implements Task {

    private Object whatISay;

    public ReturnWhatISay(Object whatISay) {
        this.whatISay = whatISay;
    }

    public Object execute() throws FailedExecutionException {
        return "done";
    }
}
