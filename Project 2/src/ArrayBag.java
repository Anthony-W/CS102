import java.util.NoSuchElementException;

/**
 *  The {@code Bag} class represents a bag (or multiset) of generic items.
 *  <p>
 *  This implementation uses a fixed size array of Items (no resizing)
 *  @param <Item> the generic type of an item in this bag
 */
public class ArrayBag<Item>
{
    protected Item[] _list;
    protected int _size;

    /**
     * Initializes an empty bag to a specified size.
     * 
     * @param capacity -- fixed capacity of the bag
     */
    public ArrayBag(int capacity) {}

    /**
     * Returns true if this bag is empty.
     *
     * @return {@code true} if this bag is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {return false;}

    /**
     * Returns true if this bag is full.
     *
     * @return {@code true} if this bag is full;
     *         {@code false} otherwise
     */
    public boolean isFull(){return false;}

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size() {return -1;}

    /**
     * Adds the item to this bag at index position 0
     *
     * @param  item -- the item to add to this bag
     * @return {@code true} if the item is successfully added
     *         {@code false} if the item was not added
     */
    public boolean add(Item item) {return false;}

    /**
     * Insert an item into this bag at the particular index by shifting all
     * elements down the list.
     *
     * @param  index -- index position where to insert the given item
     * @param  item the item to add to this bag
     * @throws NoSuchElementException if the index is invalid; not in the
     *         range [0, _size]
     *         Note: index 0 is always valid even for an empty bag
     * @return {@code true} if the item is successfully inserted
     *         {@code false} if the item was not inserted 
     */
    public boolean insert(int index, Item item) throws NoSuchElementException{return false;}

    /**
     * Remove an item from this bag.
     *
     * @param  item the item to remove from this bag
     * @return {@code true} if the item is found and removed
     *         {@code false} if the item is not found 
     */
    public boolean remove(Item item) {return false;}

    /**
     * Return an item at a particular position.
     *
     * @param  index an index position in the bag array
     * @return the item at bag[index]
     */
    public Item get(int index) throws NoSuchElementException{return null;}
}