package project3;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int hitPoints;
    private int speed;

    private ArrayList<Move> movesList = new ArrayList<>();

    public Pokemon(String name, int hitPoints, int speed) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.speed = speed;
    }

    public void addMove(Move move) {
        movesList.add(move);
    }

    public void setHitPoints(int newHP) {
        hitPoints = newHP;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Move> getMovesList() {
        return movesList;
    }

    public String getPokemonInfo() {
        return String.format("Name: %s\nHit Points: %d\nSpeed: %d\n", name, hitPoints, speed);
    }

    public Move getMoveByName(String name) {
        Move moveFound = null;
        for (Move move : movesList) {
            if (move.getMoveName().equals(name)) {
                moveFound = move;
            }
        }
        return moveFound;
    }
}
