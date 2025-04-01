package framework.gamification;

import java.util.HashMap;
import java.util.Map;

public class GamificationFacade {

    // singleton stuff
    private static GamificationFacade instance = new GamificationFacade();

    public static GamificationFacade getInstance() {
        return instance;
    }

    private GamificationFacade() {}


    //framework stuff
    private Map<Class<? extends Task>, GameRule> rules = new HashMap<>();

    public void setGameRule(GameRule rule, Class<? extends Task> taskClass) {
        rules.put(taskClass, rule);
    }

    public Object execute(Task task) throws FailedExecutionException {
        //get the game rule for the task
        GameRule rule = rules.get(task.getClass());

        //execute the before part of the game rule
        rule.executeBefore();

        // execute the task
        try {
            Object result = task.execute();
            rule.executeAfter(task, result);
            return result;
        } catch (FailedExecutionException e){
            //??? somewhere execute the exception part of the game rule
            e.printStackTrace();
        }
        return null;
    }
}
