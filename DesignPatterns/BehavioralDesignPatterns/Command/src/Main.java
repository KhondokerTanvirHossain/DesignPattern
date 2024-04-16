package DesignPatterns.BehavioralDesignPatterns.Command.src;

// Java code to explain Command Design Pattern

import java.util.Stack;

// Command Interface
interface Command {
    void execute();
    void undo();
}

// Concrete Command Classes
class CopyCommand implements Command {
    private Application app;
    private Editor editor;

    public CopyCommand(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    @Override
    public void execute() {
        app.clipboard = editor.getSelection();
    }

    @Override
    public void undo() {
        // No undo operation for CopyCommand
    }
}

class CutCommand implements Command {
    private Application app;
    private Editor editor;
    private String backup;

    public CutCommand(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    @Override
    public void execute() {
        backup = editor.getText();
        app.clipboard = editor.getSelection();
        editor.deleteSelection();
    }

    @Override
    public void undo() {
        editor.setText(backup);
    }
}

// Concrete Command Classes
class PasteCommand implements Command {
    private Application app;
    private Editor editor;
    private String backup;

    public PasteCommand(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    @Override
    public void execute() {
        System.out.println("Executing PasteCommand");
        backup = editor.getText();
        editor.replaceSelection(app.clipboard);
    }

    @Override
    public void undo() {
        System.out.println("Undoing PasteCommand");
        editor.setText(backup);
    }
}

// Receiver Classes
class Application {
    String clipboard;
    Editor activeEditor;
    CommandHistory history;

    // Initialize history in the constructor
    Application() {
        this.history = new CommandHistory();
    }

    void executeCommand(Command command) {
        System.out.println("Executing command");
        if (command != null) {
            command.execute();
            history.push(command);
        }
    }

    void undo() {
        System.out.println("Undoing command");
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}

class Editor {
    String text;

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }

    String getSelection() {
        // Return selected text
        return "";
    }

    void deleteSelection() {
        // Delete selected text
    }

    void replaceSelection(String text) {
        // Replace selected text with input text
    }
}

// Command History Class
class CommandHistory {
    private Stack<Command> history = new Stack<>();

    void push(Command command) {
        history.push(command);
    }

    Command pop() {
        return history.pop();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        Editor editor = new Editor();
        Command copyCommand = new CopyCommand(app, editor);
        Command cutCommand = new CutCommand(app, editor);
        Command pasteCommand = new PasteCommand(app, editor);

        // Execute commands
        app.executeCommand(copyCommand);
        app.executeCommand(cutCommand);
        app.executeCommand(pasteCommand);

        // Undo last command
        app.undo();
    }
}