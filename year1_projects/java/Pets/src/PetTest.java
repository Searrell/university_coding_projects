public class PetTest {

    public static  void main(String[] args){
        /*
        Pet p1 = new Pet();
        Pet p2 = new Pet("bob", "9 year old");
        Pet p3 = new Pet ("rick", "4 year old");

        p1.setName("Patch");
        p1.setAge("13 year old");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println(p1.getName());
        System.out.println(p1.getAge());
         */
        Dog d1 = new Dog();
        Dog d2 = new Dog(" Spot", "14",2, "lab");

        System.out.println(d2);

        Cat c1 = new Cat();
        Cat c2 = new Cat(" Felix ", "6", "orange", "tabbie.");

        System.out.println(c2);



        d1.setName("John ");
        d1.setAge("7");
        d1.setNumAge(1);
        d1.setBreed("boxer");
        System.out.println(d1);

        c1.setName("Tom");
        c1.setAge("5");
        c1.setColour("Black & White");
        c1.setBreed("Scottish fold");
        System.out.println(c1);

       /*
        System.out.println(d1.getBreed());
        System.out.println(d1.getNumAge());
        System.out.println(c1.getBreed());
        System.out.println(c1.getColour());
        */



    }


}
