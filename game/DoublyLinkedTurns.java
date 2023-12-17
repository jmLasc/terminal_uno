// doubly linked AND circular in order for turn recording
// using <T> instead of hardcoding <Player>, 
// but Player class will be the item of this dataclass
public class DoublyLinkedTurns<T> implements Turns<T>
{
    private class Node
    {
        private T data;
        private Node prev;
        private Node next;

        public Node(T player){
            data = player;
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public DoublyLinkedTurns(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T item){
        Node temp = new Node(item);
        
        if (head == null){
            head = temp;
            tail = temp;
            tail.next = head;
            tail.prev = head;
            head.next = tail;
            head.prev = tail;   
        } else {
            temp.prev = tail;
            temp.next = head;
            tail.next = temp;
            head.prev = temp;
            tail = temp;
        }
        size++;
    }

    public int size(){
        return size;
    }

    private class TurnIterator implements IteratorTurns<T>
    {
        private Node position;
        private boolean reversed;
        
        public TurnIterator(){
            position = head;
            reversed = false;
        }

        public void reverse(){
            reversed = !reversed;
        }

        public boolean hasNext(){
            return true; // will ALWAYS be true due to circular nature
        }

        public T next(){
            if (reversed){
                T item = position.data;
                position = position.prev;
                return item;
            } else {
                T item = position.data;
                position = position.next;
                return item;
            }
        }
    }

    public IteratorTurns<T> iterator(){
        return new TurnIterator();
    }

}