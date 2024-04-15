package DesignPatterns.BehavioralDesignPatterns.ChainOfResponsibility.src;

import java.util.ArrayList;
import java.util.List;

// Handler interface
interface HelpHandler {
    void showHelp();
}

// Base component class
abstract class Component implements HelpHandler {
    String tooltipText;
    Container container;

    @Override
    public void showHelp() {
        if (tooltipText != null) {
            System.out.println(tooltipText);
        } else if (container != null) {
            container.showHelp();
        }
    }
}

// Container class
abstract class Container extends Component {
    List<Component> children = new ArrayList<>();

    public void add(Component child) {
        children.add(child);
        child.container = this;
    }
}

// Button class
class Button extends Component {
    public Button(String tooltipText) {
        this.tooltipText = tooltipText;
    }
}

// Panel class
class Panel extends Container {
    String modalHelpText;

    public Panel(String modalHelpText) {
        this.modalHelpText = modalHelpText;
    }

    @Override
    public void showHelp() {
        if (modalHelpText != null) {
            System.out.println(modalHelpText);
        } else {
            super.showHelp();
        }
    }
}

// Dialog class
class Dialog extends Container {
    String wikiPageURL;

    public Dialog(String wikiPageURL) {
        this.wikiPageURL = wikiPageURL;
    }

    @Override
    public void showHelp() {
        if (wikiPageURL != null) {
            System.out.println("Opening wiki page: " + wikiPageURL);
        } else {
            super.showHelp();
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Dialog dialog = new Dialog("http://wiki.example.com/dialog");
        Panel panel = new Panel("This panel does...");
        Button okButton = new Button("This is an OK button that...");
        Button cancelButton = new Button("This is a Cancel button that...");

        panel.add(okButton);
        panel.add(cancelButton);
        dialog.add(panel);

        // Simulate F1 key press
        okButton.showHelp();
    }
}