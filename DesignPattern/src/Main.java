import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Are you 0.exit 1.Admin 2.User");
            int actor = sc.nextInt();
            if (actor == 0)
                break;
            if (actor == 1){
                System.out.println("Admin Name :");
                String adminName = sc.next();
                System.out.println("Admin Password :");
                String adminPassword = sc.next();
                boolean check = Admin.checkAdmin(adminName, adminPassword);
                if(check == true){
                    Admin admin = Admin.Admin(adminName, adminPassword);
                    System.out.println("Logging As Admin Successful");
                }else{
                    System.out.println("Logging As Admin Failed!");
                }
            }
        }
    }
}
