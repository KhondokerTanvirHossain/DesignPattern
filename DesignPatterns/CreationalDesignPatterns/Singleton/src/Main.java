package DesignPatterns.CreationalDesignPatterns.Singleton.src;

// The Database class defines the `getInstance` method that lets clients access the same instance of a database connection throughout the program.
class Database {
    // The field for storing the singleton instance should be declared static.
    private static Database instance;

    // The singleton's constructor should always be private to prevent direct construction calls with the `new` operator.
    private Database() {
        // Some initialization code, such as the actual connection to a database server.
        // ...
    }

    // The static method that controls access to the singleton instance.
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Finally, any singleton should define some business logic which can be executed on its instance.
    public void query(String sql) {
        // For instance, all database queries of an app go through this method. Therefore, you can place throttling or caching logic here.
        // ...
        System.out.println("Executing query: " + sql);
    }
}

public class Main {
    public static void main(String[] args) {
        Database foo = Database.getInstance();
        foo.query("SELECT ...");
        // ...

        Database bar = Database.getInstance();
        bar.query("SELECT ...");
        // The variable `bar` will contain the same object as the variable `foo`.

        if (foo == bar) {
            System.out.println("foo and bar are the same instance, demonstrating the Singleton pattern.");
        }
    }
}