package main;

import linkedlist.simply.SimplyLinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        remove();
    }

    public static void initializeTests() {
        SimplyLinkedList<Integer> linkedList = new SimplyLinkedList<>();
        linkedList.append(1);
        linkedList.append(30);
        linkedList.append(25);

        System.out.println(linkedList.searchIndex(0));
        System.out.println(linkedList.searchIndex(1));
        System.out.println(linkedList.searchIndex(2));

        System.out.println(linkedList.searchElement(1));
        System.out.println(linkedList.searchElement(35));
        System.out.println(linkedList.searchElement(25));

        System.out.println(linkedList);
    }

    public static void appendTests() {
        SimplyLinkedList<Integer> linkedList = new SimplyLinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(4);
        System.out.println(linkedList);

        linkedList.append(0, 0);
        System.out.println(linkedList);

        linkedList.append(4, 5);
        System.out.println(linkedList);

        linkedList.append(3, 3);
        System.out.println(linkedList);
    }

    public static void removeStart() {
        SimplyLinkedList<Integer> linkedList = new SimplyLinkedList<Integer>();
        // linkedList.removeStart();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
    }

    public static void removeEnd() {
        SimplyLinkedList<Integer> linkedList = new SimplyLinkedList<Integer>();
        // linkedList.removeEnd();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        System.out.println(linkedList);
        System.out.println("Removed: " + linkedList.removeLast());
        System.out.println(linkedList);

        System.out.println("Removed: " + linkedList.removeLast());
        System.out.println(linkedList);

        System.out.println("Removed: " + linkedList.removeLast());
        System.out.println(linkedList);
    }

    public static void remove() {
        SimplyLinkedList<Integer> linkedList = new SimplyLinkedList<Integer>();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        System.out.println(linkedList);
        System.out.println("Removed: " + linkedList.remove(5));
        System.out.println(linkedList);
    }
}
