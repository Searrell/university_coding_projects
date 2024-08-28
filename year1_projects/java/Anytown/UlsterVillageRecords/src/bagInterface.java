public interface bagInterface {

    public int getCurrentSize();
    /* the number of elements contained in the bag

    @return - (int) number of elements
     */

    public boolean isEmpty();
    /* test for empty bag

    @return - (boolean) true if the number of elements is zero, false other wise
     */

    public boolean buildingNewEntry(Building newEntry);
    /* test for spare capacity in the bag and it if exists, add new element
    and increment the number of elements in the bag

    @param (Building) newEntry - the item to be added to the bag

    @return - (boolean) true if items is added, false otherwise
     */

    public Building remove();
    /*  remove and element from the bag, if one is available and
    decrement the number of elements in the bag. return the removed element or null if none is available

    @return - (Building) the element removed from the bag, or null
     */

    public boolean remove(Building anEntry);
    /* remove the specified element from the bag, if it is present and
    decrement the number of elements

    @return - (boolean) true if the element is available, false otherwise.
     */

    public void clear();
    /* empty the bag set number of elements to 0

     */

    public int getFrequency(Building anEntry);
    /* count how many times a given element appears in the bag
    @param  (Building) anEntry- the element to look for in the bag

    @return - (int) the number of time the element appears.
     */

    public boolean contains(Building anEntry);
    /* check for a specified element in the bag

    @param (Building) anEntry - the itme to look for in the bag

    @return - (boolean) true if bag contains the element, false otherwise
     */

    public String toString();
    /* describe all the elements in the bag

    @return - (String) a String representation of all bag contents
     */
}
