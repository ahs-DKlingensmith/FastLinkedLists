
import java.util.*;

@SuppressWarnings("unchecked")
public class FastLinkedList<AnyType extends Comparable> {
    
    //each node has between one and eight next references
    public static final int MAX_LEVEL = 7;

    //reference to a header node
    //the value stored in the header node is never accessed.
    private Node<AnyType> head;

    //the current highest level of all nodes in the list
    private int maxListLevel;

    /**
     * Builds an empty list with a header node
     */
    public FastLinkedList() {
        maxListLevel = 0;
        head = new Node<AnyType>(MAX_LEVEL, null);
    }

    /**
     * Each element in the list is stored in a node. The level of the node is
     * chosen randomly when the node is created.
     */
    private static class Node<AnyType> {

        public AnyType data;
        public Node<AnyType>[] next;

        public Node(int randLevel, AnyType data) {
            next = new Node[randLevel + 1];
            this.data = data;
        }
    }

    /**
     * Returns a current max level of all nodes in the list
     */
    public int getMaxLevel() {
        return maxListLevel;
    }

    /**
     * Returns a random level between 0 and MAX_LEVEL
     */
    public int randomLevel() {
        int rand = (int) (Math.log(1 - Math.random()) / Math.log(0.5));
        return Math.min(rand, MAX_LEVEL);
    }

    /**
     * Returns the length of this list The method traverses the level 0
     * references
     */
    public int length() {
       
        int count = 0;
        AnyType storedValue = head.data;
        Node<AnyType> tmp = head.next[count];
        
        while (storedValue != null) {
            tmp = head.next[count];
            storedValue = tmp.data;
            count++;
        }
        
        return count;
    }

    /**
     * Returns the string contents of the list The method traverses the level 0
     * references
     */
    public String toString() {
        
        String contentsToString = "";
        int length = this.length();
        int count = 0;
        AnyType storedValue;
        
        while (count < length)  {
            
            Node<AnyType> tmp = head.next[count];
            storedValue = tmp.data;
            
            storedValue.toString();
            contentsToString += storedValue;
            
            count++;
            
        }
        
        return contentsToString;
    }

    /**
     * Returns the string contents of the list at a given level
     */
    public String toString(int level) {
        
        String contentsToString = "";
        int length = this.length();
        AnyType storedValue;
        
        for (int x = 0; x < length; x++)  {
            
            Node<AnyType> tmp = head.next[x];
            storedValue = tmp.data;
            
            storedValue.toString();
            contentsToString += storedValue;
            
        }
        
        return contentsToString;
    }

    /**
     * Returns true if a given value is stored in the list, otherwise false. The
     * search begins at the topmost reference of the header
     */
    public boolean contains(AnyType toSearch) {
        
        int length = this.length();
        boolean containsStoredValue = false;
        AnyType storedValue;
        
        for (int x = 0; x < length; x++)    {
            
            Node<AnyType> tmp = head.next[x];
            storedValue = tmp.data;
            
            if (storedValue == toSearch)    {
                containsStoredValue = true;
            }
        }
        
        return containsStoredValue;
    }

    /**
     * Returns true if a given value is stored in the list at a specified level.
     */
    public boolean contains(AnyType toSearch, int level) {
        
        int length = this.length();
        boolean containsStoredValue = false;
        AnyType storedValue;
        
        for (int x = level; x < length; x++)    {
            
            Node<AnyType> tmp = head.next[x];
            storedValue = tmp.data;
            
            if (storedValue == toSearch)    {
                containsStoredValue = true;
            }
        }
        
        return containsStoredValue;
    }

    /**
     * Inserts a given value into the list at random level In order to insert a
     * new node into the list we must maintain an array of nodes whose next
     * references must be updated.
     */
    public void insert(AnyType toInsert) {
        int randLevel = randomLevel();
        insertHelper(toInsert, randLevel);
    }

    /**
     * Inserts a given value into the list at a given level The level must not
     * exceed MAX_LEVEL.
     */
    public void insert(AnyType toInsert, int level) {
        if (level >= 0 && level <= MAX_LEVEL) {
            insertHelper(toInsert, level);
        }
    }

    private void insertHelper(AnyType toInsert, int level) {
        Node<AnyType> tmp = head;
        Node<AnyType>[] nodesToUpdate = new Node[MAX_LEVEL + 1];

        //Find and store nodes for updates
        //you code goes here
        //If the new node level is greater than any node already in the list
        //then the header node must be updated
        int length = this.length();
       
        for (int x = level; x < length; x++)    {
            nodesToUpdate[x] = tmp.next[x];
        }
        
        //Insert a new node
        if (level > length) {
            head.next = new Node[MAX_LEVEL + 1];
            head.next[length].data = toInsert;
        }
                
    }

    /**
     * Deletes a node that contains the given value. In order to delete a node
     * we must maintain an array of nodes whose next references must be updated.
     */
    public void delete(AnyType toDelete) {
        Node<AnyType> tmp = head;
        Node<AnyType>[] nodesToUpdate = new Node[MAX_LEVEL + 1];

        //Find and store nodes for updates
        //you code goes here
        //Remove a node from the list
        //you code goes here
        //After deleting the node we must check if maxListLevel must be lowered.
        //you code goes here
        if (this.contains(toDelete))    {
            
        }
        
    }
}
