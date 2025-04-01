package framework.gamification;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {

    private String name;
    private int points = 0;
    private ArrayList<String> badges = new ArrayList<>();

    public User(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return this.points;
    }

    public void addPoints(int numberOfPoints) {
        this.points += numberOfPoints;
    }

    public void removePoints(int numberOfPoints) {
        this.points -=  numberOfPoints;
    }

    public ArrayList<String> getBadges() {
        return badges;
    }

    public void addBadge(String badge) {
        this.badges.add(badge);
    }

    public void removeBadge(String badge) {
        this.badges.remove(badge);
    }

    public boolean hasBadge(String badge) {
        return this.badges.contains(badge);
    }
}
