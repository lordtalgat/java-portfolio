package kz.talgat.generic_stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    @Test
    void shouldWorkWithInteger() {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushing 10, 20, 30: " + stack);

        System.out.println("Peeked element: " + stack.peek());
        assertEquals(30, stack.peek());
        var pop = stack.pop();
        System.out.println("Popped element: " + pop);
        System.out.println("Stack after pop: " + stack);
        assertEquals(30, pop);
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldWorkWithString() {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Test1");
        stack.push("Test2");
        System.out.println("Stack after pushing Test1 and Test2: " + stack);

        System.out.println("Peeked element: " + stack.peek());
        assertEquals("Test2", stack.peek());
        var pop = stack.pop();
        System.out.println("Popped element: " + pop);
        System.out.println("Stack after pop: " + stack);
        assertEquals("Test2", pop);
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }
}