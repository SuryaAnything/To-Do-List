/**
 * AccountInfo class represents user account information and extends DoList functionalities.
 * It manages user details including name, UserID, and password.
 * Provides methods for creating, cloning, and verifying user accounts.
 */
package src;
import java.util.Objects;
import java.util.Scanner;
public class AccountInfo extends DoList {

    private final String name;
    private final int UserID;
    private final String password;
    public AccountInfo(String name) {
        super();
        this.name = name;
        this.UserID = Math.abs(name.hashCode());
        this.password = enterPassword();
    }

    public AccountInfo(AccountInfo old) {
        this.name = old.name;
        super.tasks = old.tasks;
        super.currentSize = old.currentSize;
        super.status = old.status;
        this.password = old.password;
        this.UserID = old.UserID;
    }

    private static String enterPassword() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Create new password : ");
        return scan.next();
    }

    public int getUserID() {
        return UserID;
    }

    public String getName() {
        return name;
    }

    public boolean checkPassword(String pass) {
        return Objects.equals(this.password, pass);
    }
}
