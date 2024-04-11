package SOLID.LiskovSubstitution.src;

import java.util.List;
import java.util.Arrays;

// BEFORE
/*
class Document {
    String data;
    String filename;

    void open() {
        // Open the document
    }

    void save() {
        // Save the document
    }
}

class ReadOnlyDocument extends Document {
    @Override
    void save() {
        throw new UnsupportedOperationException("Unable to save read-only file.");
    }
}

class Project extends Document {
    List<Document> documents;

    void openAll() {
        for (Document doc : documents) {
            doc.open();
        }
    }

    void saveAll() {
        for (Document doc : documents) {
            if (!(doc instanceof ReadOnlyDocument)) {
                doc.save();
            }
        }
    }
}
*/

// AFTER
class Document {
    String data;
    String filename;

    void open() {
        System.out.println("Reading document: " + filename);
    }
}

class WritableDocument extends Document {
    void save() {
        System.out.println("Writing document: " + filename);
    }
}

class Project extends Document {
    List<Document> allDocs;
    List<WritableDocument> writableDocs;

    void openAll() {
        for (Document doc : allDocs) {
            doc.open();
        }
    }

    void saveAll() {
        for (WritableDocument doc : writableDocs) {
            doc.save();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Project project = new Project();
        Document doc1 = new Document();
        doc1.filename = "doc1";
        WritableDocument doc2 = new WritableDocument();
        doc2.filename = "doc2";

        project.allDocs = Arrays.asList(doc1, doc2);
        project.writableDocs = Arrays.asList(doc2);

        project.openAll();
        project.saveAll();
    }
}