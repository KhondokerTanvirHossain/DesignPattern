package DesignPatterns.BehavioralDesignPatterns.TemplateMethod.src;

abstract class GameAI {
    public void turn() {
        collectResources();
        buildStructures();
        buildUnits();
        attack();
    }

    public void collectResources() {
        System.out.println("Collecting resources...");
    }

    public abstract void buildStructures();
    public abstract void buildUnits();

    public void attack() {
        String enemy = closestEnemy();
        if (enemy == null) {
            sendScouts("map.center");
        } else {
            sendWarriors(enemy);
        }
    }

    public String closestEnemy() {
        // Logic to find closest enemy
        return "Enemy1";
    }

    public abstract void sendScouts(String position);
    public abstract void sendWarriors(String position);
}

class OrcsAI extends GameAI {
    public void buildStructures() {
        System.out.println("Orcs building structures...");
    }

    public void buildUnits() {
        System.out.println("Orcs building units...");
    }

    public void sendScouts(String position) {
        System.out.println("Orcs sending scouts to " + position);
    }

    public void sendWarriors(String position) {
        System.out.println("Orcs sending warriors to " + position);
    }
}

class MonstersAI extends GameAI {
    public void collectResources() {
        System.out.println("Monsters don't collect resources.");
    }

    public void buildStructures() {
        System.out.println("Monsters don't build structures.");
    }

    public void buildUnits() {
        System.out.println("Monsters don't build units.");
    }

    public void sendScouts(String position) {
        System.out.println("Monsters don't send scouts.");
    }

    public void sendWarriors(String position) {
        System.out.println("Monsters don't send warriors.");
    }
}

public class Main {
    public static void main(String[] args) {
        GameAI gameAI = new OrcsAI();
        gameAI.turn();

        gameAI = new MonstersAI();
        gameAI.turn();
    }
}
