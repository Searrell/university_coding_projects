import java.util.ArrayList;
import java.util.Collections;

public class ArrayListBag implements BagInterface{
    private ArrayList<Building> buildings = new ArrayList<Building>();

    public int getCurrentSize(){
        return this.buildings.size();

    }
    public boolean isEmpty(){
        return this.buildings.size() == 0;
    }

    public boolean addNewEntry(Building newEntry){
        this.buildings.add(newEntry);
        return true;
    }

    public Building remove() {
        if (!isEmpty()){
            Building thisBuilding = this.buildings.get(0);
            this.buildings.remove(0);
            return thisBuilding;

        }else return null;
    }

    public boolean remove(Building anEntry){
        return  this.buildings.remove((anEntry));
    }

    public void clear(){
        this.buildings.clear();
    }

    public int getFrequencyOf(Building anEntry){
       return Collections.frequency(this.buildings, anEntry);
    }

    public boolean contains(Building anEntry){
        return this.buildings.contains(anEntry);
    }

    public String toString(){
        String resultsStr = "Bag [ \n";
        for (Building building : buildings){
            resultsStr += building + "\n";
        }
        resultsStr += "] \n";
        return resultsStr;
    }
}
