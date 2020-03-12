import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecuter {
    private final List<TextFileOperation> textFileOperations = new ArrayList<>();
    public String executeOperation(TextFileOperation operation){
        textFileOperations.add(operation);
        return operation.execute();
    }
}
