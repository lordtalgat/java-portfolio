package kz.talgat.generic_stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
/*
Create a generic class GenericStack<T> that represents a stack data structure.
The stack should support the following operations:
push(T item): Adds an item to the top of the stack.
pop(): Removes and returns the item from the top of the stack. If the stack is empty, throw an exception or return null.
peek(): Returns the item at the top of the stack without removing it. If the stack is empty, throw an exception or return null.
isEmpty(): Returns true if the stack is empty, otherwise false.
size(): Returns the number of items in the stack.

Use an ArrayList<T> or an array to store the stack elements internally.
Create a Main class to test the GenericStack<T> with different data types (e.g., Integer, String, etc.).
 */

public class GenericStack<T> {
    private ArrayList<T> stack;
    private int size;

    public GenericStack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(0, item);
        size += 1;
    }

    public T pop() {
        if (stack.isEmpty()) throw new EmptyStackException();
        var item = stack.get(0);
        stack.remove(0);
        size -= 1;
        return item;
    }


    public T peek() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.get(0);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return stack.stream().map(Object::toString).reduce((el, acc) -> el + " " +acc).orElse("");
    }
}
