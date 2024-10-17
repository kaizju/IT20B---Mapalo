/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.LinkedList;
import java.util.Queue;
public class ququququ {
      public static void main(String[] args) {
        // Creating a queue using a LinkedList
        Queue<String> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.add("jude the monkey");
        queue.add("Kadon the dog");
        queue.add("Dwight the goat");

        // Accessing and removing elements from the queue (FIFO)
        String firstElement = queue.poll(); // Removes and returns "Apple"
        String secondElement = queue.poll(); // Removes and returns "Banana"

        // Printing the remaining elements in the queue
        System.out.println("ang nag pabilin: " + queue);

        // Adding more elements to the queue
        queue.add("mika the dululu");
        queue.add("preclle the mother");

        // Accessing and removing elements from the queue (FIFO)
        String thirdElement = queue.poll(); // Removes and returns "Cherry"

        // Printing the remaining elements in the queue
        System.out.println("nag pabilin gihapon: " + queue);
    }
}
