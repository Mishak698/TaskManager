import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private boolean isCompleted;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return "Nadpis: " + title + "\nPopis: " + description + "\nDodělano: " + isCompleted;
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();
            System.out.println("Ukol označen za hotový: " + task.getTitle());
        } else {
            System.out.println("Error");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Žádné úkoly nejsou zadané");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("Úkol " + (i + 1) + ":\n" + tasks.get(i) + "\n");
            }
        }
    }
}

public class tms {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Přidat úkol");
            System.out.println("2. Označit úkol za hotový");
            System.out.println("3. Zobrazit úkoly");
            System.out.println("4. Exit");
            System.out.print("výběr: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Zadejte jmeno úkolu: ");
                String title = scanner.nextLine();
                System.out.print("Zadejte popis: ");
                String description = scanner.nextLine();
                Task task = new Task(title, description);
                taskManager.addTask(task);
                System.out.println("Úkol přidán.");
            } else if (choice == 2) {
                System.out.print("Vyberte číslo úkolu ");
                int index = scanner.nextInt();
                taskManager.markTaskAsCompleted(index - 1);
            } else if (choice == 3) {
                taskManager.displayTasks();
            } else if (choice == 4) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Error");
            }

            System.out.println();
        }

        scanner.close();
    }
}
