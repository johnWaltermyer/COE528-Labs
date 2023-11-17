package lab3;
/**
 *
 * @author ur_dad
 */
import java.util.ArrayList;

public class QueueOfDistinctStrings {
/* 
Overview: QueueOfDistinctStrings are mutable, bounded collection of 
distinct strings that operate in FIFO (First-In-First-Out) order.

The abstraction function is:
a) Write the abstraction function here
AF(c) = p, where c is a Java QueueOfDistinctStrings object 
           and p is an abstract queue of distinct strings where
           p = {p_0, p_1, ..., p_N}
           where p_i = c.items[i] and i = {0, 1, ..., N}

The rep invariant is:
b) Write the rep invariant here
RI(c) = true if c.items.size() > 0 
            && c.items = {str0, str1, ..., strN | str_i != str_j; 
            i, j = {0, 1, ..., N} }                
      = false otherwise
*/ 
    
    //the rep
    private ArrayList<String> items;
    
    // constructor
    public QueueOfDistinctStrings () {
    // EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }    
    
    public void enqueue(String element) throws Exception {
    // MODIFIES: this
    // EFFECTS: Appends the element at the end of the queue if the element is 
    //          not in the queue, otherwise does nothing.
        if(element == null) 
            throw new Exception();
        if(!items.contains(element))
            items.add(element);
    }
    
    public String dequeue() throws Exception {
    // MODIFIES: this
    // EFFECTS: Removes an element from the front of the queue
        if (items.isEmpty()) 
            throw new Exception();
        return items.remove(0);
    }
    
    public boolean repOK() {
    // EFFECTS: Returns true if the rep invariant holds for this object;
    // otherwise, returns false
        if(items.isEmpty())
            return false;
        //re-checking each element to see if repeated in the list        
        for (int i = 0; i < items.size()-1; i++) {
            for (int j = i+1; j < items.size(); j++) {
                if(items.get(i).equals(items.get(j)))
                    return false;
            }
        }     
        return true;
    }
    
    @Override
    public String toString() {    
    // EFFECTS: Returns a string that contains the strings in the queue, the 
    // front element and the end element. Implements the abstraction function.    
        String returnString="";        
        for(String aString : items){
            returnString += aString + " ";
        }        
        return returnString;
    }
}