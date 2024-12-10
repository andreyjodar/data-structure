package linkedlist.dual;

public class DualNode<T> {
    private T element;
    private DualNode<T> previousNode;
    private DualNode<T> nextNode;

    public DualNode(T element) {
        this.element = element;
        this.previousNode = null;
        this.nextNode = null;
    }

    public DualNode(DualNode<T> previousNode, T element) {
        this.element = element;
        this.previousNode = previousNode;
        this.nextNode = null;
    }

    public DualNode(T element, DualNode<T> nextNode) {
        this.element = element;
        this.previousNode = null;
        this.nextNode = nextNode;
    }

    public DualNode(T element, DualNode<T> previousNode, DualNode<T> nextNode) {
        this.element = element;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public DualNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DualNode<T> previousNode) {
        this.previousNode = previousNode;
    }

    public DualNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DualNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "DualNode [element=" + element + ", previousNode=" + previousNode + ", nextNode=" + nextNode + "]";
    }
    
}
