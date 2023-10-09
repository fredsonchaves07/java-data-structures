package com.fredson.datastructures.iterator;

import com.fredson.datastructures.stack.ArrayStack;
import com.fredson.datastructures.stack.Stack;

public class StackIterator<T> implements Iterator<T> {

    private T element;

    private final Stack<T> originalStack;

    private final Stack<T> stack;

    private int lengthStack;

    public StackIterator(Stack<T> stack) {
        this.stack = new ArrayStack<>(stack.clone()) ;
        this.originalStack = stack;
        this.lengthStack = stack.length();
        if (!this.stack.isEmpty()) {
            element = this.stack.pop();
        }
    }

    @Override
    public boolean hasNext() {
        if (originalStack.length() > lengthStack) return true;
        if (originalStack.length() < lengthStack && !element.equals(originalStack.peek())) return false;
        return element != null;
    }

    @Override
    public T next() {
        if (originalStack.length() > lengthStack) {
            lengthStack = originalStack.length();
            stack.push(originalStack.peek());
            element = stack.pop();
        } else if (originalStack.length() < lengthStack && !originalStack.peek().equals(element)) {
            lengthStack = originalStack.length();
            element = null;
        }
        T actualElement = element;
        element = stack.pop();
        return actualElement;
    }
}
