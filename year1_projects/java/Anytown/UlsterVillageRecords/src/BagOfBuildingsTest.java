public class BagOfBuildingsTest {

    private static Building b1 = new Building("Address 1", "Owner 1");
    private static Building b2 = new Building("Address 2", "Owner 2");
    private static Building b3 = new Building("Address 3", "Owner 3");
    private static Building b4 = new Building("Address 4", "Owner 4");

    public static void main(String[] args) {

        ArrayListBag buildings = new ArrayListBag();

        System.out.println("--------------------------");
        System.out.println("BAG TEST:");
        System.out.println("Initial state of Bag:");

        // Output the current status of the bag:
        bagStatusReport(buildings);
        System.out.println("\n");

        System.out.println("Adding 8 buildings to the bag: b1, b1, b2, b2, b3, b3, b4, b4");

        // TODO (1/5): Add the following building objects to the bag in the order given
        // Note: The building objects are defined above as static variables

        buildings.addNewEntry(BagOfBuildingsTest.b1);
        buildings.addNewEntry(BagOfBuildingsTest.b1);
        buildings.addNewEntry(BagOfBuildingsTest.b2);
        buildings.addNewEntry(BagOfBuildingsTest.b2);
        buildings.addNewEntry(BagOfBuildingsTest.b3);
        buildings.addNewEntry(BagOfBuildingsTest.b3);
        buildings.addNewEntry(BagOfBuildingsTest.b4);
        buildings.addNewEntry(BagOfBuildingsTest.b4);

        // Output the current status of the bag:
        bagStatusReport(buildings);
        System.out.println("\n");

        System.out.println("---------------------");
        System.out.println("Remove b3 from the bag");

        // TODO (2/5): Remove b3 from the bag:

        buildings.remove(b3);
  

        // Output the current status of the bag:
        bagStatusReport(buildings);
        System.out.println("\n");

        System.out.println("---------------------------");
        System.out.println("Remove b1 and b2 from the bag");

        // TODO (3/5): Remove b1 and b2 from the bag:

        buildings.remove(b1);
        buildings.remove(b2);

        /// Output the current status of the bag:
        bagStatusReport(buildings);
        System.out.println("\n");

        System.out.println("----------------------------------------");
        System.out.println("Remove an unspecified entry from the bag");

        // TODO (4/5): Remove an unspecified entry from the bag:

        buildings.remove();

        // Output the current status of the bag:
        bagStatusReport(buildings);
        System.out.println("\n");

        System.out.println("---------------------------------------------");
        System.out.println("Remove another unspecified entry from the bag");

        // TODO (5/5): Remove another unspecified entry from the bag:

        buildings.remove();

        // Output the current status of the bag:
        bagStatusReport(buildings);
        System.out.println("\n");

        System.out.println("Bag test completed");
        System.out.println("-----------------------------------------------");
    }

    public static void bagStatusReport(ArrayListBag myBag) {
        System.out.println("Bag contents: " + myBag);
        System.out.println("Size: " + myBag.getCurrentSize());
        System.out.println("Is empty: " + myBag.isEmpty());
        System.out.println("Frequency of b1: " + myBag.getFrequencyOf(BagOfBuildingsTest.b1));
        System.out.println("Frequency of b2: " + myBag.getFrequencyOf(BagOfBuildingsTest.b2));
        System.out.println("Frequency of b3: " + myBag.getFrequencyOf(BagOfBuildingsTest.b3));
        System.out.println("Frequency of b4: " + myBag.getFrequencyOf(BagOfBuildingsTest.b4));
        System.out.println("Bag contains b1: " + myBag.contains(BagOfBuildingsTest.b1));
        System.out.println("Bag contains b2: " + myBag.contains(BagOfBuildingsTest.b2));
        System.out.println("Bag contains b3: " + myBag.contains(BagOfBuildingsTest.b3));
        System.out.println("Bag contains b4: " + myBag.contains(BagOfBuildingsTest.b4));
    }

}