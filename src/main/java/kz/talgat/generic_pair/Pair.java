package kz.talgat.generic_pair;

/*
Task: Implement a Generic Pair Class
Requirements:
Create a generic class Pair<T, U> that can hold a pair of objects of any two types (T and U).

The class should have two private fields:
first of type T
second of type U

Implement the following methods:
A constructor to initialize first and second.
getFirst(): Returns the value of first.
getSecond(): Returns the value of second.
setFirst(T first): Sets the value of first.
setSecond(U second): Sets the value of second.
toString(): Returns a string representation of the pair in the format (first, second).
Create a Test class to test the Pair<T, U> class with different types (e.g., Integer and String, Double and Boolean, etc.).
 */
public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T t, U u) {
        this.first = t;
        this.second = u;
    }

    // Getter for first
    public T getFirst() {
        return first;
    }

    // Getter for second
    public U getSecond() {
        return second;
    }

    // Setter for first
    public void setFirst(T first) {
        this.first = first;
    }

    // Setter for second
    public void setSecond(U second) {
        this.second = second;
    }

    // String representation of the pair
    @Override
    public String toString() {
        return "Pair [first=" + first + ", second=" + second + "]";
    }

}
