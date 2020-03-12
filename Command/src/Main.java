public class Main {
    public static void main(String[] args) {
        TextFileOperationExecuter executer = new TextFileOperationExecuter();
        String str = executer.executeOperation(new TextFileOpen(new TextFile("text_file_name")));
        System.out.println(str);
    }
}
