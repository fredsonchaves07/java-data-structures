package com.fredson.datastructures.iterator;

import com.fredson.datastructures.list.List;
import com.fredson.datastructures.queue.LinkedQueue;
import com.fredson.datastructures.queue.Queue;

public class ListIterator<T> implements Iterator<T> {

    private T element;

    private final Queue<T> queue = new LinkedQueue<>();

    private final List<T> list;

    private int lengthList;

    public ListIterator(List<T> list) {
        for (int i = 0; i < list.length(); i++) {
            queue.enqueue(list.getElement(i));
        }
        this.list = list;
        this.lengthList = list.length();
    }

    @Override
    public boolean hasNext() {
        if (hasElementInList()) {
            return true;
        }
        if (listHasChangeAndHasElement()) {
            return true;
        }
        return listDatastructureIsLessThanListIterator() && hasElementInList();
    }

    @Override
    public T next() {
        if (lengthList != list.length() && hasNext()) {
            lengthList = list.length();
            queue.enqueue(list.getElement(lengthList - 1));
        }
        while(!queue.isEmpty()) {
            element = queue.dequeue();
            if (list.getElement(element) != null) {
                T actualElement = element;
                element = queue.peek();
                return actualElement;
            }
        }
        element = null;
        return null;
    }

    private boolean hasElementInList() {
        return list.getElement(queue.peek()) != null;
    }

    private boolean listHasChangeAndHasElement() {
        return listDatastructureIsGreaterThanListIterator()
                && lastElementDatastructureEqualsElementIterator()
                && indexElementDatastructureIsLessEqualsListSize();
    }

    private boolean listDatastructureIsGreaterThanListIterator() {
        return list.length() > lengthList;
    }

    private boolean listDatastructureIsLessThanListIterator() {
        return list.length() < lengthList;
    }

    private boolean lastElementDatastructureEqualsElementIterator() {
        return list.getElement(list.length() - 1) != null
                && list.getElement(list.length() - 1) != element;
    }

    private boolean indexElementDatastructureIsLessEqualsListSize() {
        return list.indexOf(list.getElement(list.length() - 1)) <= list.length() - 1;
    }
}
