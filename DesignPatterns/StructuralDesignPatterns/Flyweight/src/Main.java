package DesignPatterns.StructuralDesignPatterns.Flyweight.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Flyweight class
class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(String canvas, int x, int y) {
        System.out.println("Drawing a " + this.name + " tree of color " + this.color + " and texture " + this.texture + " on canvas at coordinates (" + x + ", " + y + ")");
    }
}

// Flyweight Factory
class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;
        if(!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(name, color, texture));
            System.out.println("Creating a new TreeType: " + name + ", " + color + ", " + texture);
        }
        return treeTypes.get(key);
    }
}

// Contextual class
class Tree {
    private int x, y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(String canvas) {
        type.draw(canvas, this.x, this.y);
    }
}

// Client class
class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void draw(String canvas) {
        for(Tree tree : trees) {
            tree.draw(canvas);
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.plantTree(1, 2, "Oak", "Green", "Rough");
        forest.plantTree(2, 3, "Pine", "Dark Green", "Smooth");
        forest.plantTree(3, 4, "Oak", "Green", "Rough");
        forest.draw("Canvas1");
    }
}
