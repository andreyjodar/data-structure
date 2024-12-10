package linkedlist.dual;

public class DualLinkedList<T> {
    private DualNode<T> begin;
    private DualNode<T> end;
    private int length = 0;

    private final int NOT_FOUND = -1;
    private final String OUT_OF_RANGE = "Index out of range";
    private final String EMPTY_LINKEDLIST = "LinkedList is empty";

    public void addFirst(T element) {
        DualNode<T> newNode = new DualNode<T>(element);
        if(this.length == 0) {
            this.begin = newNode;
            this.end = newNode;
        } else {
            newNode.setNextNode(this.begin);
            begin.setPreviousNode(newNode);
            this.begin = newNode;
        }
        this.length++;
    }

    public void addLast(T element) {
        
    }

    public void add(int index, T element) {
        if(this.isInvalidIndex(index)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }

        if(this.length == 0) {
            this.addFirst(element);
        } else if(index == this.length -1) {
            this.addLast(element);
        } else {
            DualNode<T> previousNode = this.searchNode(index -1);
            DualNode<T> posteriorNode = previousNode.getNextNode();
            DualNode<T> newNode = new DualNode<T>(element, previousNode, posteriorNode);
            posteriorNode.setPreviousNode(newNode);
            previousNode.setNextNode(newNode);
            this.length++;
            
        }
    }

    public T rightSearchIndex(int index) {

    }

    public T leftSearchIndex(int index) {

    }

    public T searchIndex(int index) {
        if(this.isInvalidIndex(index)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }

        if(this.findNearSide(index) == NearSide.LEFT) {
            return leftSearchIndex(index);
        }
        return rightSearchIndex(index);
    }

    public int searchElement(T element) {
        
    }

    private DualNode<T> searchNode(int index) {
        if(this.isInvalidIndex(index)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }

        if(this.findNearSide(index) == NearSide.LEFT) {
            return this.leftSearchNode(index);
        } 
        return this.rightSearchNode(index);
    }

    private DualNode<T> rightSearchNode(int index) {
        DualNode<T> currentNode = this.end;
        for (int i = this.length -1; i > index; i++) {
            currentNode = currentNode.getPreviousNode();
        }

        return currentNode;
    }

    private DualNode<T> leftSearchNode(int index) {
        DualNode<T> currentNode = this.begin;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }

    public T removeFirst() {
        if(this.length == 0) {
            throw new RuntimeException(EMPTY_LINKEDLIST);
        }
    }

    public T removeLast() {
        if(this.length == 0) {
            throw new RuntimeException(EMPTY_LINKEDLIST);
        }
    }

    public T remove(int index) {
        if(this.isInvalidIndex(index)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    public int getLength() {
        return this.length;
    }

    private boolean isInvalidIndex(int index) {
        return index < 0 || index >= length;
    }

    private NearSide findNearSide(int index) {
        if(index > (this.length -1) / 2) {
            return NearSide.RIGHT;
        } 
        return NearSide.LEFT;
    } 
}
