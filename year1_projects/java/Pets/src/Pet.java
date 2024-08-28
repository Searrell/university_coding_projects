public class Pet {
    private String name;

    private String age;

    public Pet() {
        this.name = "";
        this.age = "";
    }

    public Pet(String name, String age) {
        this.age = age;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age){
        this.age = age;
    }
    public String toString(){
        return  "I am " + this.name + ",and i'm " + this.age + " Year old" ;
    }

    /*public String toString(){
        if (Dog)
            return "Woof" + this.name + " is a Dog" + "and is " + this.age + " Year old" ;
        else (Cat)
                return "Meow" + this.name + " is a Cat" + "and is " + this.age + " Year old" ;
    } */

}
