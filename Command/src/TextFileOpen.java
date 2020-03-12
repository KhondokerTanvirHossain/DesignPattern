public class TextFileOpen implements TextFileOperation {

    private TextFile textFile;

    public TextFileOpen(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.Open();
    }
}
