/**
 * DoList class manages a simple to-do list functionality.
 * It includes methods to add, remove, display tasks, and mark them as complete or incomplete.
 */

package src;
import java.util.LinkedList;

public class DoList {

    protected LinkedList<String> tasks;
    protected int currentSize;
    protected LinkedList<Boolean> status;

    public DoList() {
        this.tasks = new LinkedList<>();
        this.currentSize = 0;
        this.status = new LinkedList<>();
    }

    public void addTask(String task) {

        this.tasks.add(task);
        this.status.add(false);
        this.currentSize++;
    }

    public void removeTask(int taskNumber) {
        this.tasks.remove(taskNumber - 1);
        this.status.remove(taskNumber - 1);
    }

    public void displayTaskAll() {
        int count = 1;
        for (String task : this.tasks) {
            System.out.println(count+" "+task);
            count++;
        }
    }

    public void markComplete(int taskNumber) {
        this.status.set(taskNumber-1,true);
    }

    public void markIncomplete(int taskNumber) {
        this.status.set(taskNumber-1,false);
    }

}
