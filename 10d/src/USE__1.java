


// add Last
// void addLast(String xForest, int xRate, int xSound) {
//    //You should write here appropriate statements to complete this function.
//     if(!xForest.startsWith("A"))
//                  {
//                  Node newNode = new Node(new Boo(xForest, xRate, xSound));
//                  if(isEmpty()){
//                  head= tail =newNode;
//                  } else{
//                  tail.next = newNode;
//                  tail = tail.next;
//                  }
//                  }
//   }



// add Postiion
//    
//    void addPos2(Dog dog, int a) {
//int size = size();
//    if (a < 1 || a > size + 1) {
//        System.out.println("Invalid position!");
//        return;
//    }
//    Node newNode = new Node(dog);
//    if (a == 1) { // Insert at the beginning of the list
//        newNode.next = head;
//        head = newNode;
//        if (tail == null) { // List was empty before insertion
//            tail = newNode;
//        }
//    } else if (a == size + 1) { // Insert at the end of the list
//        tail.next = newNode;
//        tail = newNode;
//    } else { // Insert at a position other than the beginning or the end
//        Node prevNode = head;
//        int i = 1;
//        while (i < a - 1) {
//            prevNode = prevNode.next;
//            i++;
//        }
//        newNode.next = prevNode.next;
//        prevNode.next = newNode;
//    }
//    size++;
//}

//    public int size() 
//    {Node p = head; int c = 0;
//      while(p != null) {c++; p = p.next;}
//      return c;
//    }


// Sort bình thường
//    void sort(){
//    Node p = head;
//    Node q;
//    Dog temp;
//    while(p!=null){
//    q= p.next;
//    while (q!=null){
//    if(p.getInfo().price > q.getInfo().getPrice()) {
//      temp = p.getInfo();
//      p.setInfo(q.getInfo());
//      q.setInfo(temp);
//    }
//    q= q.next;
//    } 
//    p =p.next;
//    }
//    }
//}


// tìm node Min 

//    
//  Node findNodemin(){
//  Node p= head;
//  Node p1;
//  Node min= head;
//  while(p!=null){
//  if(p.info.weight < min.info.weight) 
//      min =p; 
//     p=p.next;
//  }
//    return min;
//  }
//}
//



// tìm node Max
//  Node findNodemax(){
//  Node p= head;
//  Node p1;
//  Node max= head;
//  while(p!=null){
//  if(p.info.weight > min.info.weight) 
//      min =p; 
//     p=p.next;
//  }
//    return max;
//  }
//}
//
//


// add After 
//    void insertAfter(Node q, Bike x) {
//        if (q == null) {
//            return;
//
//        }
//        Node qNext = q.next;
//        Node pNode = new Node(x, qNext);
//        q.next = pNode;
//        if (tail == q) {
//            tail = pNode;
//        }
//
//    }


// delete Node 

//    void dele(Node q) {
//        Node f, p;
//        f = null;
//        p = head;
//        while (p != null) {
//            if (p == q) {
//                break;
//            }
//            f = p;
//            p = p.next;
//        }
//        if (p == null) {
//            return;
//        }
//        if (f == null) {
//            head = head.next;
//            if (head == null) {
//                tail = null;
//            }
//            return;
//        }
//        f.next = p.next;
//        if (f.next == null) {
//            tail = f;
//        }
//    }