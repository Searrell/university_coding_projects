public class Building {
    private String address;
    private String owner;

    public Building() {
        this.address = "";
        this.owner = "";
    }
    public Building(String address, String owner) {
        this.address = address;
        this.owner = owner;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public  String getOwner(){
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String toString() {
        return this.address + " occupied by " + this.owner;
    }

    public boolean equals(Building anotherBuilding){
        return this.getAddress().equals(anotherBuilding.getAddress());
    }
}
