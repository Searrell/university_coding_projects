public class Dog extends Pet{

    private int numAge;
    private String breed;

    public Dog(){
        super();
        this.numAge = 0;
        this.breed = "";
    }

    public Dog (String name, String age, int numAge, String breed) {
        super(name, age);
        this.numAge = numAge;
        this.breed = breed;
    }
    public int getNumAge() {
        return this.numAge;
    }

    public void setNumAge(int numAge) {
        this.numAge = numAge;
    }

    public String getBreed() {
        return this.breed;
    }

    public String speak(){
        return "Bark!! " + super.toString() + " and in Dog years is " +
                this.numAge + ", My breed is " + this.breed + ".";
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    /*
    //hard coded version
    public String toString() {
        return "Bark!! " + super.toString() + " and in Dog years is " +
                this.numAge + ", My breed is " + this.breed + ".";

    }

     */
    //version with speak method
    public String toString() {
        return speak() ;
    }
}
