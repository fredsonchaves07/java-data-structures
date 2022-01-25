package fredson.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Stack <T>{
    
    private List<T> items;

    public Stack(){
        this.items = new ArrayList<>();
    }

    public void push(T element){
        this.items.add(element);
    }

    public T pop(){
        return this.items.remove(this.items.size() - 1);
    }

    public T peek(){
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
