package SOLID.DependencyInversion.src;

// BEFORE
/*
class MySQLDatabase {
    void insert() {
        System.out.println("MySQLDatabase inserting...");
    }

    void update() {
        System.out.println("MySQLDatabase updating...");
    }

    void delete() {
        System.out.println("MySQLDatabase deleting...");
    }

    void read(String date) {
        System.out.println("MySQLDatabase reading data of date: " + date);
    }
}

class BudgetReport {
    private MySQLDatabase database;

    BudgetReport(MySQLDatabase database) {
        this.database = database;
    }

    void open(String date) {
        database.read(date);
    }

    void save() {
        database.update();
    }
}
*/

// AFTER
interface Database {
    void read(String date);
    void update();
}

class MySQLDatabase implements Database {
    public void read(String date) {
        System.out.println("MySQLDatabase reading data of date: " + date);
    }

    public void update() {
        System.out.println("MySQLDatabase updating...");
    }
}

class MongoDBDatabase implements Database {
    public void read(String date) {
        System.out.println("MongoDBDatabase reading data of date: " + date);
    }

    public void update() {
        System.out.println("MongoDBDatabase updating...");
    }
}

class BudgetReport {
    private Database database;

    BudgetReport(Database database) {
        this.database = database;
    }

    void open(String date) {
        database.read(date);
    }

    void save() {
        database.update();
    }
}

public class Main {
    public static void main(String[] args) {
        Database mysqlDatabase = new MySQLDatabase();
        Database mongoDatabase = new MongoDBDatabase();

        BudgetReport budgetReportMySQL = new BudgetReport(mysqlDatabase);
        budgetReportMySQL.open("2022-01-01");
        budgetReportMySQL.save();

        BudgetReport budgetReportMongo = new BudgetReport(mongoDatabase);
        budgetReportMongo.open("2022-01-01");
        budgetReportMongo.save();
    }
}