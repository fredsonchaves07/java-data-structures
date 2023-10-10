package com.fredson.datastructures.iterator;

import com.fredson.datastructures.queue.ArrayQueue;
import com.fredson.datastructures.queue.Queue;

public class QueueIterator<T> implements Iterator<T> {

    private T element;

    private final Queue<T> originalQueue;

    private final Queue<T> queue;

    private int lengthStack;

    public QueueIterator(Queue<T> queue) {
        this.queue = new ArrayQueue<>((Queue<T>) queue.clone()) ;
        this.originalQueue = queue;
        this.lengthStack = queue.length();
        if (!this.queue.isEmpty()) {
            element = this.queue.dequeue();
        }
    }

    @Override
    public boolean hasNext() {
        if (originalQueue.length() > lengthStack) return true;
        if (originalQueue.length() < lengthStack && !element.equals(originalQueue.peek())) return false;
        return element != null;
    }

    @Override
    public T next() {
        if (originalQueue.length() > lengthStack) {
            lengthStack = originalQueue.length();
            increaseElementInQueue(originalQueue);
            element = queue.dequeue();
        } else if (originalQueue.length() < lengthStack && !originalQueue.peek().equals(element)) {
            lengthStack = originalQueue.length();
            element = null;
        }
        T actualElement = element;
        element = queue.dequeue();
        return actualElement;
    }

    private void increaseElementInQueue(Queue<T> originalQueue) {
        Queue<T> queueAux = originalQueue.clone();
        while (!queueAux.isEmpty()) {
            if (queueAux.length() == 1) {
                queue.enqueue(queueAux.dequeue());

            }
            queueAux.dequeue();
        }
    }
}
