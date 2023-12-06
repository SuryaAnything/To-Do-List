/**
 * UserChoice class provides a console-based user interface for managing user accounts and to-do lists.
 * It contains a main method that displays a menu-driven system to create users, log in, and manage tasks.
 */
package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserChoice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<AccountInfo> list = new ArrayList<>();
        boolean run = true;
        while (run) {
            System.out.println("Enter 1 to enter a new User");
            System.out.println("Enter 2 to display Users");
            System.out.println("Enter 3 to login");
            System.out.println("Enter 0 to exit");
            int loginInfo = scan.nextInt();
            switch (loginInfo) {
                case 1: {
                    System.out.print("Enter name : ");
                    AccountInfo newUser = new AccountInfo(scan.next());
                    System.out.println("Your userId is : " + newUser.getUserID());
                    list.add(newUser);
                    break;
                }

                case 2: {
                    System.out.println("UserID\t\tUser name");
                    for (AccountInfo obj : list) {
                        System.out.println(obj.getUserID() + "\t" + obj.getName());
                    }
                    break;
                }

                case 0: {
                    run = false;
                }

                case 3: {
                    System.out.print("Enter userID : ");
                    int id = scan.nextInt();
                    AccountInfo info = findUserID(list,id);
                    if(info!=null) {
                        System.out.print("Enter your password : ");
                        String pass = scan.next();
                        if (!info.checkPassword(pass)) {
                            System.out.println("Wrong Password");
                        } else {
                            getInfoForTasks(new AccountInfo(info));
                        }
                    }
                }
            }
        }
    }

    private static void getInfoForTasks(AccountInfo info) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        while(run) {
            System.out.println("Enter 1 to add a new task");
            System.out.println("Enter 2 to display all task and their status");
            System.out.println("Enter 3 to display all incomplete tasks");
            System.out.println("Enter 4 to display all completed tasks");
            System.out.println("Enter 5 to remove a task");
            System.out.println("Enter 6 to mark a task as complete");
            System.out.println("Enter 0 to exit");
            int choice = scan.nextInt();

            switch (choice) {
                case 0: run = false;
                break;
                case 1: {
                    System.out.println("Enter task");
                    String task = scan.next();
                    info.addTask(task);
                    break;
                }
                case 2: {
                    info.displayTaskAll();
                    break;
                }
                case 3: {
                    int count = 0;
                    for (int i=0; i<info.currentSize; i++) {
                        if(!info.status.get(i)) {
                            System.out.println(count+1+" "+info.tasks.get(i));
                            count++;
                        }
                    }
                    break;
                }
                case 4: {
                    int count = 0;
                    for(int i=0; i<info.currentSize; i++) {
                        if(info.status.get(i)) {
                            System.out.println(count+1+ " "+info.tasks.get(i));
                            count++;
                        }
                    }
                    break;
                }
                case  5: {
                    System.out.println("Enter task number to remove");
                    int revTask = scan.nextInt();
                    info.removeTask(revTask);
                    info.currentSize--;
                    break;
                }
                case 6: {
                    System.out.println("Enter which task to mark as complete");
                    int com = scan.nextInt();
                    info.markComplete(com);
                    break;
                }
            }

        }
    }

    private static AccountInfo findUserID(List<AccountInfo> list, int id) {
        for (AccountInfo info : list) {
            if(info.getUserID()==id) {
                return info;
            }
        }
        System.out.println("User Not found");
        return null;
    }
}
