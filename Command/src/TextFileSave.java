public class TextFileSave implements TextFileOperation {

    TextFile textFile;

    public TextFileSave(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.Save();
    }
}
