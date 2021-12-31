package datastructures;

import java.util.ArrayList;
import java.util.List;

public class Deque<T> {
    
    private List<T> items;

    public Deque(){
        this.items = new ArrayList<>();
    }

    public void addFront(T element){
        if(this.isEmpty()){
            this.addBack(element);
        } else {
            this.items.add(0, element);
        }
    }

    public void addBack(T element){
        if(this.isEmpty()){
            this.items.add(element);
        } else {
            this.items.add(this.items.size(), element);
        }
    }

    public void removeFront(){
        if(this.size() == 1){
            this.removeBack();
        } else {
            this.items.remove(0);
        }
    }

    public void removeBack(){
        if(this.size() == 1){
            this.items.remove(0);
        } else {
            this.items.remove(this.items.size() - 1);
        }
    }

    public T peekFront(){
        return this.items.get(0);
    }

    public T peekBack(){
        if(this.size() == 1){
            this.peekFront();
        }
        return this.items.get(this.items.size() - 1);
    }

    public boolean isEmpty(){
        return this.items.size() == 0;
    }

    public int size(){
        return this.items.size();
    }

    public void clear(){
        this.items.clear();
    }

    @Override
    public String toString() {
        return this.items.toString();
    }
}
