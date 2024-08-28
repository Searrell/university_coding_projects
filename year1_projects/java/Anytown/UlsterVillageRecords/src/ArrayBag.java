public class ArrayBag implements BagInterface {

    private Building[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    public ArrayBag() {

        this(ArrayBag.DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity) {
        this.bag = new Building[capacity];
        this.numberOfEntries = 0;
    }

    public int getCurrentSize() {
        return 0;
    }

    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }

    private boolean isArrayFull() {
        return this.numberOfEntries == this.bag.length;
    }

    public boolean addNewEntry(Building newEntry) {
        if (isArrayFull()) return false;
        else {
            this.bag[this.numberOfEntries++] = newEntry;
            return true;
        }
    }

    private Building removeElementAt(int index) {
        Building result = null;
        if (!isEmpty() && index >= 0 && index < numberOfEntries) {
            result = this.bag[index];
            this.bag[index] = this.bag[numberOfEntries - 1];
            this.numberOfEntries--;
        }
        return result;
    }




    public Building remove(){
        return removeElementAt(this.numberOfEntries - 1);
    }

    public boolean remove(Building anEntry){
        boolean found = false;
        int index = 0;
        while (!found && index < this.numberOfEntries-1){
            if(this.bag[index].equals(anEntry)) found = true;
            else index++;
        }
        if(found) removeElementAt(index);
        return found;
    }

    public void clear(){
        while(isEmpty()) remove();

    }

    public int getFrequencyOf(Building anEntry){
        int count = 0;
        for(int i = 0;i < this.numberOfEntries; i++){
            if (this.bag[i].equals(anEntry)) count++;
        }
        return count;
    }

    public boolean contains(Building anEntry){
        boolean found = false;
        int index = 0;
        while (!found && index < this.numberOfEntries){
            if (this.bag[index++].equals(anEntry)) found = true;
        }
        return found;
    }

    public String toString(){
        String strResult = "Bag[ \n";
        for (int i = 0; i < this.numberOfEntries; i++){
            strResult += this.bag[i] + "\n";
        }
        strResult += "]";
        return strResult;
    }
}
