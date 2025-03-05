class TrainList {
    Node head;

    public TrainList() {
        head = null;
    }

    public void addTrainToEnd(Train train) {
        Node newNode = new Node(train);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Train search(String tcode) {
        Node temp = head;
        while (temp != null) {
            Train train = (Train) temp.data;
            if (train.tcode.equals(tcode)) {
                return train;  
            }
            temp = temp.next;
        }
        return null;  
    }

    public void delete(String tcode) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Train train = (Train) temp.data;
            if (train.tcode.equals(tcode)) {
                if (prev == null) {
                    head = temp.next;  
                } else {
                    prev.next = temp.next;  
                }
                System.out.println("Train with tcode " + tcode + " deleted.");
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        System.out.println("Train with tcode " + tcode + " not found.");
    }

    public void sort() {
        if (head == null || head.next == null) {
            return; 
        }

        boolean swapped;
        do {
            Node current = head;
            Node prev = null;
            Node next = null;
            swapped = false;

            while (current != null && current.next != null) {
                next = current.next;
                Train currentTrain = (Train) current.data;
                Train nextTrain = (Train) next.data;

                if (currentTrain.tcode.compareTo(nextTrain.tcode) > 0) {
                    current.data = next.data;
                    next.data = current.data;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Trains sorted by tcode.");
    }

    public void addTrainAfterPosition(int position, Train train) {
        Node newNode = new Node(train);
        Node temp = head;

        int count = 0;
        while (temp != null) {
            if (count == position) {
                newNode.next = temp.next;
                temp.next = newNode;
                System.out.println("Train added after position " + position);
                return;
            }
            count++;
            temp = temp.next;
        }

        System.out.println("Invalid position.");
    }

    public void deleteNodeBefore(String tcode) {
        Node temp = head;
        Node prev = null;

        if (head == null || head.next == null) {
            System.out.println("Not enough nodes to perform this operation.");
            return;
        }

        while (temp != null && temp.next != null) {
            Train train = (Train) temp.next.data;
            if (train.tcode.equals(tcode)) {
                if (prev == null) {
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Node before train code " + tcode + " deleted.");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Train with tcode " + tcode + " not found.");
    }
}
