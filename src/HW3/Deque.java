package HW3;

public class Deque<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    public Deque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public Deque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insert(T value, boolean isInsertInEnd) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        if (isInsertInEnd) {
            list[end] = value;
            size++;
            end = nextIndex(end);
        } else {
            list[begin] = value;
            size++;
            begin = preIndex(begin);
        }
    }

    public T remove(boolean isRemoveFromEnd) {
           T temp;
        if (isRemoveFromEnd) {
            temp = list[end];
            list[end] = null;
            size--;
            end = preIndex(end);
        } else {
            temp = list[begin];
            list[begin] = null;
            size--;
            begin = nextIndex(begin);
        }
        return temp;
    }


    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int preIndex(int index) {
        return (index + list.length - 1) % list.length;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
