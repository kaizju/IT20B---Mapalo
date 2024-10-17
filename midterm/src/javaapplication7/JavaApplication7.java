package javaapplication7;

import java.util.LinkedList;

public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LinkedList<String> tropa= new LinkedList<>();

// insertion
        tropa.add("Kadon the dog");
        tropa.addFirst("nika love the dog");
        tropa.addLast("rimond the lover boy");
        tropa.add(1, "mama precelle");

        System.out.println("Linked List Original: " + tropa);
        System.out.println(tropa.size());

//  Seraching  
        if (tropa.contains("kadon the dog")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        boolean containslion = tropa.contains("kadon the dog");
        System.out.println(containslion);

//        Deletion
//        animals.remove();
//        animals.removeFirst();
//        animals.removeLast();
//        animals.remove(2);
//        System.out.println("LinkedList After Deletion: " + animals);
//        Insertion:    add(); addFirst();  addLast();  add(index, data);
//         Deletion:    remove();   removeFirst();  removeLast(); remove(index);
//          Searching operation:        contains(element); size();
    }

}
