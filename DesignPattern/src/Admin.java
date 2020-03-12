public class Admin extends Actor {
    private static Admin adminInstance = null;
    public Admin(){}

    private Admin(String adminName, String adminPassword) {
        super();
        setName(adminName);
        setPassword(adminPassword);
    }

    public static Admin Admin(String name, String password) {

        if (adminInstance == null){
            synchronized (Admin.class){
                if (adminInstance == null){
                    adminInstance = new Admin(name, password);
                }
            }
        }
        return adminInstance;
    }
    public static boolean checkAdmin(String adminName, String adminPassword){
        if(adminName.equals("Admin") && adminPassword.equals("admin"))
            return true;
        else
            return false;
    }
}
