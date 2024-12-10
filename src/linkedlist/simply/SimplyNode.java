package linkedlist.simply;

public class SimplyNode<T> {

    private T element;
    private SimplyNode<T> nextKnot;

    public SimplyNode(T element) {
        this.element = element;
        this.nextKnot = null;
    }

    public SimplyNode(T element, SimplyNode<T> nextKnot) {
        this.element = element;
        this.nextKnot = nextKnot;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SimplyNode<T> getNextNode() {
        return nextKnot;
    }

    public void setNextNode(SimplyNode<T> nextKnot) {
        this.nextKnot = nextKnot;
    }

    @Override
    public String toString() {
        return "SimplyKnot [element=" + element + ", nextKnot=" + nextKnot + "]";
    }
    
}
