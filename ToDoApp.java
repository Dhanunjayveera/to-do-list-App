import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

public class ToDoApp 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to ToDoList App..!!!");

        System.out.println();

        System.out.println("These are the Commands");

        System.out.println();

        System.out.println("Add, Remove, Show, sort, Exit");

        ArrayList<String> list = new ArrayList<>();

        loadTasks(list);

        while(true)
        {
            System.out.println("Enter command");
            String command = sc.nextLine();

            if(command.equals("add"))
            {
                System.out.println("Enter new task.");

                String new_task = sc.nextLine();

                list.add(new_task);
            }
            else if(command.equals("remove"))
            {
                System.out.println("Enter task name to remove");

                String delete_task = sc.nextLine();

                if(list.contains(delete_task))
                {
                    list.remove(delete_task);
                }
                else 
                {
                    System.out.println("Given task is not in the list");
                }
            }
            else if(command.equals("show"))
            {
                if(list.size() == 0)
                {
                    System.out.println("List is already Empty");
                }
                else 
                {
                    System.out.println("The complete list is: ");

                    for(int i=0; i<list.size(); i++)
                    {
                        System.out.println((i+1) + ".  " + list.get(i) + " ");
                    }
                    System.out.println();
                    System.out.println();
                }
            }
            else if(command.equals("sort"))
            {
                Collections.sort(list);

                System.out.println("The sorted list is: ");

                System.out.println(list);
            }
            else if(command.equals("exit"))
            {
                System.out.println("Exiting the Todolist App");
                break;
            }
            else 
            {
                System.out.println("Enter valid command");
            }

            System.out.println();
        }

        saveData(list);
    }

    public static void saveData(ArrayList<String> list)
    {
        File file = new File("tasks.txt");

        try 
        {
            FileWriter writer = new FileWriter(file, true);

            for(int i=0; i<list.size(); i++)
            {
                writer.write(list.get(i) + "\n");
            }
            
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Error : "+e.getMessage());
        } 
    }

    public static void loadTasks(ArrayList<String> list)
    {
        File file = new File("tasks.txt");

        if(file.exists())
        {
            try 
            {
                Scanner scanner = new Scanner(file);

                while(scanner.hasNextLine())
                {
                    list.add(scanner.nextLine());
                }
                scanner.close();
            }   
            catch(IOException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
        else 
        {
            System.out.println("No previous tasks found");
        }
    }
}