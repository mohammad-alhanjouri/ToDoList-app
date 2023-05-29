import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaskList {
    int idNext=1;

    ArrayList<Task> tasks = new ArrayList<Task>(); // create an instance of an ArrayList that can store objects of the Task class.

    /*
    When We Scan String Then Int We Have Some Problems Because The Pointer Back After Scanning NextLine
     */
    Scanner scString = new Scanner(System.in);
    Scanner scInt = new Scanner(System.in);

    // adding a task method
    public void addTask() {
        System.out.println("===== Add a new task =====");
        System.out.println("Enter Task title: ");
        String title = scString.nextLine();
        System.out.println("Enter Task date: ");
        Date date = new Date();
        System.out.print("Day: ");
        date.setDay(scInt.nextInt());
        System.out.print("Month: ");
        date.setMonth(scInt.nextInt());
        System.out.print("Year: ");
        date.setYear(scInt.nextInt());
        Task task = new Task(idNext, title, false, date);
        tasks.add(task);
        idNext++;
        System.out.println("Task added successfully!");

    }

    public void editTask() {
        System.out.println("===== Edit a task =====");
        System.out.println("Enter Task ID: ");
        int id = scInt.nextInt();
        System.out.println("Enter the new title: ");
        String newTitle = scString.nextLine();
        System.out.println("Enter the new date: ");
        Date newDate = new Date();
        System.out.print("Day: ");
        newDate.setDay(scInt.nextInt());
        System.out.print("Month: ");
        newDate.setMonth(scInt.nextInt());
        System.out.print("Year: ");
        newDate.setYear(scInt.nextInt());
        Task task = new Task(id,newTitle,false,newDate);
        tasks.set(id-1,task);
//        tasks.get(id);
//        task.setTitle(newTitle);
//        task.setDueDate(newDate);
        System.out.printf("Task %d edited successfully!", id);

    }

    public void removeTask() {
        System.out.println("===== Remove a task =====");
        System.out.println("Enter Task ID: ");
        int id= scInt.nextInt();
        tasks.remove(id-1);
        System.out.printf("Task %d deleted successfully!", id);
    }

    public void listTasks() {
        System.out.println("===== Display all tasks =====");
        System.out.println("ID\t\tDescription\t\t\tDate\t\tCompleted Check\n");
        for (int i=0; i< tasks.size(); i++){
            System.out.printf("%d\t%s\t%s\t%s\n",tasks.get(i).getID(),tasks.get(i).getTitle(),tasks.get(i).getDueDate(),tasks.get(i).isCompleted()?"Completed": "Not Completed");
        }

    }

    public void sortByDate() {
//        nested for loop is to compare adjacent tasks and swap them
        for (int i = 0; i < tasks.size() - 1; i++) { // outer loop controls the number of iterations
            for (int j = 0; j < tasks.size() - i - 1; j++) { // inner loop compares each pair of adjacent tasks
                if (tasks.get(j).getDueDate().getYear() > tasks.get(j + 1).getDueDate().getYear()
                        || (tasks.get(j).getDueDate().getYear() == tasks.get(j + 1).getDueDate().getYear()
                        && tasks.get(j).getDueDate().getMonth() > tasks.get(j + 1).getDueDate().getMonth())
                        || (tasks.get(j).getDueDate().getMonth() == tasks.get(j + 1).getDueDate().getMonth()
                        && tasks.get(j).getDueDate().getDay() > tasks.get(j + 1).getDueDate().getDay())) {

                    // Swap tasks[j] and tasks[j + 1]
                    Task temp = tasks.get(j);
                    tasks.set(j, tasks.get(j + 1));
                    tasks.set(j + 1, temp);
                }
            }
        }
        System.out.println("Tasks sorted by date successfully!");

    }


    public void isCompleted() {
        System.out.println("Enter Task ID: ");
        int id = scInt.nextInt();
        Task task = tasks.get(id-1);
        task.setCompleted(true);
        tasks.set(id-1, task);
        System.out.printf("Task %d marked as completed! \n", id);
    }



    public void run() {
        System.out.println("1. Add a new task\n2. Edit a task\n3. Remove an existing task\n" +
                "4. Mark a task as completed\n5. List all tasks\n6. Sort tasks by date\n7. Exit" +
                "\nEnter your choice: ");
        Scanner s = new Scanner(System.in);
        int ch = s.nextInt();
        switch (ch) {
            case 1:
                addTask();
                cleanScreen();
                run();
                break;

            case 2:
                editTask();
                cleanScreen();
                run();
                break;

            case 3:
                removeTask();
                cleanScreen();
                run();
                break;

            case 4:
                isCompleted();
                cleanScreen();
                run();
                break;

            case 5:
                listTasks();
                cleanScreen();
                run();
                break;

            case 6:
                sortByDate();
                cleanScreen();
                run();
                break;

            case 7:
                System.out.println("Exiting the program... ");
                System.exit(7);
                break;


            default:
                System.out.println("Invalid choice");
                run();
        }
    }

    public void cleanScreen(){
        System.out.println("Click Enter to back to main menu.. ");
        String sp= scString.nextLine();
        if (sp== " ")
            run();

    }
}
