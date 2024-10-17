package javaapplication7;

import java.util.Stack;
public class stk {
     public static void main(String[] args) {

        Stack<String> wowkaayu = new Stack<>();
        
        // Push elements onto the stack
        wowkaayu.push("halaka");
        wowkaayu.push("dyaaa");
        wowkaayu.push("duhhhhh");

        System.out.println("Stack: " + wowkaayu);

        // Pop and display the top element
        String topElement = wowkaayu.pop();
        System.out.println("Dre mag Popped: " + topElement);
        
        // Peek at the top element without removing it
        String peekedElement = wowkaayu.peek();
        System.out.println("Dre ka mag tan aw sa Peeked: " + peekedElement);

        // Check if the stack is empty
        boolean isEmpty = wowkaayu.isEmpty();
        System.out.println("Naa nay sulod? " + isEmpty);

        // Get the size of the stack
        int stackSize = wowkaayu.size();
        System.out.println("pila ka bouk ang naa?: " + stackSize);
        
         
}
}