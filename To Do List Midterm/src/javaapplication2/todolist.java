package javaapplication2;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class todolist {

    public static void main(String[] args) {
        //For Container for current task
        LinkedList<String> tasks = new LinkedList<>();
        //Container for Completed task
        LinkedList<String> tasks1 = new LinkedList<>();
        //Container for Undo task
        Stack<String> undo = new Stack<>();

        JOptionPane.showMessageDialog(null, "To-Do List Application!", "To-Do List Application", JOptionPane.PLAIN_MESSAGE);
        //Choices for To Do List
        while (true) {
            String[] choices = {
                "Choose an option:",
                "Add Task",
                "Mark Task as Done",
                "Undo",
                "View To-Do List",
                "View Completed Tasks",
                "Exit"
            };

            String letter = (String) JOptionPane.showInputDialog(null, "Select an action:",
                    "Choices",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    choices,
                    choices[0]);
            if (letter == null || letter.equals("6")) {
                int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (confirmExit == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Thank you for Using!!!");
                    System.exit(0);
                }
            }
            //option 1 Add Task
            if (letter.equals("Add Task")) {
                String add = JOptionPane.showInputDialog(null, "Enter Task to add:", "Add Task", JOptionPane.INFORMATION_MESSAGE);
                tasks.add(add);
                undo.push("add: " + add);
                JOptionPane.showMessageDialog(null, "Added to the Current Task \n * " + add);

                //option 2 Mark as Done
            } else if (letter.equals("Mark Task as Done")) {
                if (!tasks.isEmpty()) {
                    StringBuilder taskList = new StringBuilder("To-Do List:\n");
                    for (int i = 0; i < tasks.size(); i++) {
                        taskList.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, taskList.toString(), "Mark as Done", JOptionPane.INFORMATION_MESSAGE);
                    String wow = JOptionPane.showInputDialog(null, "Enter the Number of the Task to Mark as Done.", "Mark as Done", JOptionPane.INFORMATION_MESSAGE);
                    if (wow != null) {
                        try {
                            int num = Integer.parseInt(wow);
                            if (num > 0 && num <= tasks.size()) {
                                String completedTask = tasks.remove(num - 1);
                                tasks1.add(completedTask);
                                undo.push("done: " + completedTask);
                                JOptionPane.showMessageDialog(null, "Task marked as done: " + completedTask, "Mark as Done", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid task number.", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "To-Do List is empty. Nothing to mark as done.");
                }

                //option 3 Undo
            } else if (letter.equals("Undo")) {
                if (!undo.isEmpty()) {
                    String lastAction = undo.pop();
                    String[] part = lastAction.split(": ");
                    String type = part[0];
                    String task = part[1];

                    if (type.equals("add")) {
                        tasks.removeLast();
                        JOptionPane.showMessageDialog(null, "Undid adding task: " + task, "Undo Task", JOptionPane.INFORMATION_MESSAGE);
                    } else if (type.equals("done")) {
                        tasks1.removeLast();
                        tasks.add(task);
                        JOptionPane.showMessageDialog(null, "Undid marking task as done: " + task, "Undo Task", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Nothing to undo.", "Error", JOptionPane.WARNING_MESSAGE);
                }

                //option 4 View Task
            } else if (letter.equals("View To-Do List")) {
                JOptionPane.showMessageDialog(null, "\nTo-Do List: \n", "View Task", JOptionPane.INFORMATION_MESSAGE);
                view(tasks);
                continue;

                //option 5 View Completed Task
            } else if (letter.equals("View Completed Tasks")) {
                JOptionPane.showMessageDialog(null, "\nTo-Do List: ", "Completed Task", JOptionPane.INFORMATION_MESSAGE);
                view(tasks1);
                continue;

                //option 6 Exit
            } else if (letter.equals("Exit")) {
                int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (confirmExit == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Thank you for Using!!!", "Exitting", JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "\nInvalid Choice!!!", "Error", JOptionPane.WARNING_MESSAGE);
            }

        }
    }

    private static void view(LinkedList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            JOptionPane.showMessageDialog(null, (i + 1) + " " + list.get(i));
        }
        JOptionPane.showMessageDialog(null, "");
    }
}
