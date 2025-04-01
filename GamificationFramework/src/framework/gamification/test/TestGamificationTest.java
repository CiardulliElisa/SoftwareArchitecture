package framework.gamification.test;

import framework.gamification.AddBadgeWhenOK;
import framework.gamification.GamificationFacade;
import framework.gamification.User;
import framework.gamification.UserRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TestGamificationTest {

    @Test
    public void simpleUserRegistry() {
        // what I'm doing
        User user = new User("guerra");
        UserRegistry.setCurrentUser(user);

        //What I want to verify
        User retrievedUser = UserRegistry.getCurrentUser();
        assertEquals("guerra", retrievedUser.getName());
    }

    @Test
    public void addPointWhenExecute() {
        User user = new User("guerra");
        UserRegistry.setCurrentUser(user);

        GamificationFacade facade = GamificationFacade.getInstance();
        facade.setGameRule(null, DummyTask.class);

        facade.execute(new DummyTask());
        facade.execute(new DummyTask());

        User retrievedUser = UserRegistry.getCurrentUser();
        assertEquals(20, retrievedUser.getPoints());
    }

    @Test
    public void addBadgeWhenExecute() {
        User user = new User("guerra");
        UserRegistry.setCurrentUser(user);

        GamificationFacade facade = GamificationFacade.getInstance();
        facade.setGameRule(new AddBadgeWhenOK(), ReturnWhatISay.class);

        facade.execute(new ReturnWhatISay("not ok"));
        assertFalse(user.hasBadge("OK Person"));

        facade.execute(new ReturnWhatISay("ok"));
        assertTrue(user.hasBadge("OKPerson"));
    }
}
