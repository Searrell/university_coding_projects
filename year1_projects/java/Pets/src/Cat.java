public class Cat extends Pet{

    private  String colour;
    private String breed;

    public Cat(){
        super();
        this.colour = "";
        this.breed = "";
    }
    public Cat(String name, String age, String colour, String breed){
        super(name, age);
        this.colour = colour;
        this.breed = breed;
    }
    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour){
        this.colour = colour;
    }
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Meow!! " + super.toString() + " and fur colour is  " +
                this.colour + " and my breed is " + this.breed ;
    }
}
