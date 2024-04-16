package DesignPatterns.BehavioralDesignPatterns.Memento.src;

class Editor {
    private String text;
    private int curX, curY, selectionWidth;

    public void setText(String text) {
        this.text = text;
    }

    public void setCursor(int x, int y) {
        this.curX = x;
        this.curY = y;
    }

    public void setSelectionWidth(int width) {
        this.selectionWidth = width;
    }

    public Snapshot createSnapshot() {
        return new Snapshot(this, text, curX, curY, selectionWidth);
    }
}

class Snapshot {
    private Editor editor;
    private String text;
    private int curX, curY, selectionWidth;

    public Snapshot(Editor editor, String text, int curX, int curY, int selectionWidth) {
        this.editor = editor;
        this.text = text;
        this.curX = curX;
        this.curY = curY;
        this.selectionWidth = selectionWidth;
    }

    public void restore() {
        editor.setText(text);
        editor.setCursor(curX, curY);
        editor.setSelectionWidth(selectionWidth);
    }
}

class Command {
    private Snapshot backup;

    public void makeBackup(Editor editor) {
        backup = editor.createSnapshot();
    }

    public void undo() {
        if (backup != null) {
            backup.restore();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Command command = new Command();

        editor.setText("Hello, World!");
        command.makeBackup(editor);
        System.out.println("Saved snapshot of editor state.");

        editor.setText("Hello, Memento!");
        System.out.println("Changed editor state.");

        command.undo();
        System.out.println("Restored editor state from snapshot.");
    }
}
