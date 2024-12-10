package linkedlist.simply;

public class SimplyLinkedList<T> {

    private SimplyNode<T> begin;
    private SimplyNode<T> end;
    private int length = 0;

    private final int NOT_FOUND = -1;
    private final String OUT_OF_RANGE = "Index out of range";
    private final String EMPTY_LINKEDLIST = "LinkedList is empty";

    public void append(T element) {
        SimplyNode<T> newNode = new SimplyNode<T>(element);
        if(this.length == 0) {
            this.begin = newNode;
        } else {
            this.end.setNextNode(newNode);
        }
        this.end = newNode;
        this.length++;
    }

    public void appendFirst(T elemento) {
        if(this.length == 0) {
            SimplyNode<T> newNode = new SimplyNode<T>(elemento);
            this.begin = newNode;
            this.end = newNode;
        } else {
            SimplyNode<T> newNode = new SimplyNode<T>(elemento, this.begin);
            this.begin = newNode;
        }
        this.length++;
    }

    public void append(int index, T element) {
        if(this.isInvalidIndex(index)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }

        if(index == 0) {
            this.appendFirst(element);
        } else if(index == this.length) {
            this.append(element);
        } else {
            SimplyNode<T> previousNode = this.searchNode(index -1);
            SimplyNode<T> posteriorNode = previousNode.getNextNode();
            SimplyNode<T> newNode = new SimplyNode<T>(element, posteriorNode);
            previousNode.setNextNode(newNode);
            this.length++;
        }
    }

    public void clean() {
        for (SimplyNode<T> currentNode = this.begin; currentNode != null;) {
            SimplyNode<T> nextNode = currentNode.getNextNode();
            currentNode.setElement(null);
            currentNode.setNextNode(null);
            currentNode = nextNode;
        }
    }

    public int searchElement(T element) {
        SimplyNode<T> currentNode = this.begin;
        int index = 0;

        while(currentNode != null) {
            if(currentNode.getElement().equals(element)) {
                return index;
            }
            currentNode = currentNode.getNextNode();
            index++;
        }

        return NOT_FOUND;
    } 

    public T searchIndex(int index) {
        return this.searchNode(index).getElement();
    }

    private SimplyNode<T> searchNode(int index) {
        if(this.isInvalidIndex(index)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }

        SimplyNode<T> currentNode = this.begin;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }

    public T removeFirst() {
        if(this.length == 0) {
            throw new RuntimeException(EMPTY_LINKEDLIST);
        }

        T removed = this.begin.getElement();
        this.begin = this.begin.getNextNode();
        this.length--;

        if(this.length == 0) {
            this.end = null;
        }

        return removed;
    }

    public T removeLast() {
        if(this.length == 0) {
            throw new RuntimeException(EMPTY_LINKEDLIST);
        }

        if(this.length == 1){
            return this.removeFirst();
        }
        SimplyNode<T> penultimateNode = searchNode(this.length -2);
        T removed = penultimateNode.getNextNode().getElement();
        penultimateNode.setNextNode(null);
        this.end = penultimateNode;
        this.length--;

        return removed;
    }

    public T remove(int index) {
        if(this.isInvalidIndex(index)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        } 

        if(index == 0){
            return this.removeFirst();
        }
        if(index == this.length -1) {
            return removeLast();
        }

        SimplyNode<T> previousNode = this.searchNode(index-1);
        SimplyNode<T> currentNode = previousNode.getNextNode();
        SimplyNode<T> nextNode = currentNode.getNextNode();
        previousNode.setNextNode(nextNode);
        currentNode.setNextNode(null);
        this.length--;

        return currentNode.getElement();
    }

    public int getLength() {
        return this.length;
    }

    private boolean isInvalidIndex(int index) {
        return index < 0 || index >= this.length;
    }

    @Override
    public String toString() {

        if(this.length == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        SimplyNode<T> currentNode = this.begin;
        for (int i = 0; i < this.length-1; i++) {
            builder.append(currentNode.getElement()).append(",");
            currentNode = currentNode.getNextNode();
        }
        builder.append(currentNode.getElement()).append("]");
        return builder.toString();
    }

}
