package Basic_to_dolist;


import java.util.ArrayList;
import java.util.Scanner;

public class TO_doList {
    private final ArrayList<Task> tasks;
    private final Scanner scanner;

    // Constructor
    public TO_doList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Task class to store task details
    private class Task {
        String description;
        boolean isComplete;

        Task(String description) {
            this.description = description;
            this.isComplete = false;
        }

        @Override
        public String toString() {
            return (isComplete ? "[✓] " : "[ ] ") + description;
        }
    }

    // Method to add a new task
    private void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();
        if (!description.isEmpty()) {
            tasks.add(new Task(description));
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Task description cannot be empty!");
        }
    }

    // Method to view all tasks
    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list!");
            return;
        }
        System.out.println("\nYour To-Do List:");
        System.out.println("---------------");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("---------------");
    }

    // Method to mark a task as complete
    private void markTaskComplete() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to mark as complete: ");
            try {
                int taskNum = Integer.parseInt(scanner.nextLine()) - 1;
                if (taskNum >= 0 && taskNum < tasks.size()) {
                    tasks.get(taskNum).isComplete = true;
                    System.out.println("Task marked as complete!");
                } else {
                    System.out.println("Invalid task number!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    // Method to delete a task
    private void deleteTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to delete: ");
            try {
                int taskNum = Integer.parseInt(scanner.nextLine()) - 1;
                if (taskNum >= 0 && taskNum < tasks.size()) {
                    tasks.remove(taskNum);
                    System.out.println("Task deleted successfully!");
                } else {
                    System.out.println("Invalid task number!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    // Method to display menu and get user choice
    private void displayMenu() {
        System.out.println("\nTo-Do List Application");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Complete");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    // Method to run the application
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    markTaskComplete();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    running = false;
                    System.out.println("Thank you for using the To-Do List Application!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    // Main method
    public static void main(String[] args) {
        TO_doList todoList = new TO_doList();
        todoList.run();
    }
}


