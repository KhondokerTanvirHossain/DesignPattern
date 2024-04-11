package SOLID.InterfaceSegregation.src;

// BEFORE
/*
interface CloudProvider {
    void storeFile(String name);
    String getFile(String name);
    void createServer(String region);
    String listServer(String region);
    String getCDNAddress();
}

class Amazon implements CloudProvider {
    public void storeFile(String name) {
        System.out.println("Amazon storing file: " + name);
    }

    public String getFile(String name) {
        System.out.println("Amazon getting file: " + name);
        return name;
    }

    public void createServer(String region) {
        System.out.println("Amazon creating server in region: " + region);
    }

    public String listServer(String region) {
        System.out.println("Amazon listing servers in region: " + region);
        return region;
    }

    public String getCDNAddress() {
        System.out.println("Amazon getting CDN address");
        return "Amazon CDN address";
    }
}

class Dropbox implements CloudProvider {
    public void storeFile(String name) {
        System.out.println("Dropbox storing file: " + name);
    }

    public String getFile(String name) {
        System.out.println("Dropbox getting file: " + name);
        return name;
    }

    public void createServer(String region) {
        throw new UnsupportedOperationException("Dropbox doesn't support this operation");
    }

    public String listServer(String region) {
        throw new UnsupportedOperationException("Dropbox doesn't support this operation");
    }

    public String getCDNAddress() {
        throw new UnsupportedOperationException("Dropbox doesn't support this operation");
    }
}
*/

// AFTER
interface CloudStorageProvider {
    void storeFile(String name);
    String getFile(String name);
}

interface CloudHostingProvider {
    void createServer(String region);
    String listServer(String region);
}

interface CDNProvider {
    String getCDNAddress();
}

class Amazon implements CloudStorageProvider, CloudHostingProvider, CDNProvider {
    public void storeFile(String name) {
        System.out.println("Amazon storing file: " + name);
    }

    public String getFile(String name) {
        System.out.println("Amazon getting file: " + name);
        return name;
    }

    public void createServer(String region) {
        System.out.println("Amazon creating server in region: " + region);
    }

    public String listServer(String region) {
        System.out.println("Amazon listing servers in region: " + region);
        return region;
    }

    public String getCDNAddress() {
        System.out.println("Amazon getting CDN address");
        return "Amazon CDN address";
    }
}

class Dropbox implements CloudStorageProvider {
    public void storeFile(String name) {
        System.out.println("Dropbox storing file: " + name);
    }

    public String getFile(String name) {
        System.out.println("Dropbox getting file: " + name);
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Amazon amazon = new Amazon();
        Dropbox dropbox = new Dropbox();

        amazon.storeFile("file1");
        amazon.getFile("file1");
        amazon.createServer("us-west-2");
        amazon.listServer("us-west-2");
        amazon.getCDNAddress();

        dropbox.storeFile("file2");
        dropbox.getFile("file2");
    }
}