import java.util.Iterator;
public class LRUCache<T> implements Iterable<T> {
    Node<T> first;
    int capacity;

    public LRUCache(){
        this.capacity = 10;
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public void addElement(T data) {
        Node<T> addedNode = new Node(data);
        if(first == null) {
            first = addedNode;
        }else {
            if (size() >= capacity) first = first.next;

            Node<T> currentNode = first;
            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = addedNode;
        }
    }

    public int size()
    {
        int count = 0;
        Node<T> current = first;
        while (current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }


    public T get(int index) {
        if (index > size()){
            return null;
        }
        Node<T> currentNode = first;
        for(int i = 0; i < index; i ++){
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public void printAll(){
        Node<T> current = first;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    Node<T> node = current;
                    current = current.next;
                    return node.data;
                }
                return null;
            }
        };
    }
}