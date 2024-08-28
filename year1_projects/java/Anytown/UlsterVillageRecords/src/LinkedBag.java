public class LinkedBag implements BagInterface {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        this.firstNode = null;
        this.numberOfEntries = 0;

    }

        public int getCurrentSize(){
            return  this.numberOfEntries;
        }

        public boolean isEmpty(){
            return  this.numberOfEntries == 0;
        }

        public boolean addNewEntry(Building newEntry){
            Node newNode = new Node (newEntry);
            newNode.setNext(this.firstNode);
            this.firstNode = newNode;
            this.numberOfEntries++;
            return true;
        }

        public Building remove(){
            if (this.firstNode != null){
                Building result = this.firstNode.getData();
                this.firstNode = this.firstNode.getNext();
                this.numberOfEntries--;
                return result;
            }
            else {
                return null;
            }

        }
        private Node findEntry(Building anEntry){
        Node currentNode = this.firstNode;
        boolean found = false;
        while (!found && currentNode != null){
           if (currentNode.getData().equals(anEntry))
               found = true;
           else
               currentNode = currentNode.getNext();
        }
         if (found) return  currentNode;
         else return null;
    }

        public boolean remove(Building anEntry){
            Node nodeToRemove = findEntry(anEntry);
            if (nodeToRemove == null)return false;
            else {
                nodeToRemove.setData(this.firstNode.getData());
                this.firstNode = this.firstNode.getNext();
                this.numberOfEntries--;
                return true;
            }

        }

        public void clear(){
            while (!isEmpty()) remove();

        }

        public int getFrequencyOf(Building anEntry){
            int count = 0;
            Node currentNode = this.firstNode;
            while (currentNode != null){
                if (currentNode.getData().equals(anEntry))
                    count++;
                currentNode = currentNode.getNext();
            }
            return count;
        }
        public boolean contains(Building anEntry){
            Node currentNode = this.firstNode;
            boolean found = false;
            while (!found && currentNode != null){
                if (currentNode.getData().equals(anEntry))
                    found = true;
                else
                    currentNode = currentNode.getNext();
            }
            return found;
        }

        public String toString(){
            String resultStr = "Bag [ \n";
            Node currentNode = this.firstNode;
            while (currentNode != null){
                resultStr += currentNode.getData() + "\n";
                currentNode = currentNode.getNext();
            }
            resultStr += "] \n";
            return resultStr;
        }


}
