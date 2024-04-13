package DesignPatterns.StructuralDesignPatterns.Decorator.src;

interface DataSource {
    void writeData(String data);
    String readData();
}

class FileDataSource implements DataSource {
    public FileDataSource(String filename) {
    }

    public void writeData(String data) {
        System.out.println("Writing data to file: " + data);
    }

    public String readData() {
        System.out.println("Reading data from file");
        return "data";
    }
}

class DataSourceDecorator implements DataSource {
    protected DataSource wrappee;

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    public void writeData(String data) {
        wrappee.writeData(data);
    }

    public String readData() {
        return wrappee.readData();
    }
}

class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    public void writeData(String data) {
        System.out.println("Encrypting data");
        super.writeData(data);
    }

    public String readData() {
        System.out.println("Decrypting data");
        return super.readData();
    }
}

class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public void writeData(String data) {
        System.out.println("Compressing data");
        super.writeData(data);
    }

    public String readData() {
        System.out.println("Decompressing data");
        return super.readData();
    }
}

public class Main {
    public static void main(String[] args) {
        DataSource source = new FileDataSource("somefile.dat");
        source.writeData("salaryRecords");
        source = new CompressionDecorator(source);
        source.writeData("salaryRecords");
        source = new EncryptionDecorator(source);
        source.writeData("salaryRecords");
    }
}