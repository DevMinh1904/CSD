/* Name: 
 Student Code: 
 Purpose: Solve problem 3 - double linked list 
*/
package problem3;

// doublyLinked.java
// demonstrates doubly-linked list
// to run this program: C>java DoublyLinkedApp
////////////////////////////////////////////////////////////////
class Link {
   public long dData; // data item
   public Link next; // next link in list
   public Link previous; // previous link in list
   // -------------------------------------------------------------

   public Link(long d) // constructor
   {
      dData = d;
   }

   // -------------------------------------------------------------
   public void displayLink() // display this link
   {
      System.out.print(dData + " ");
   }
   // -------------------------------------------------------------
} // end class Link
  ////////////////////////////////////////////////////////////////

class DoublyLinkedList {
   private Link first; // ref to first item
   private Link last; // ref to last item
   // -------------------------------------------------------------

   public DoublyLinkedList() // constructor
   {
      first = null; // no items on list yet
      last = null;
   }

   // -------------------------------------------------------------
   public boolean isEmpty() // true if no links
   {
      return first == null;
   }

   // -------------------------------------------------------------
   public void insertFirst(long dd) // insert at front of list
   {
      Link newLink = new Link(dd);
      if (isEmpty())
         last = newLink;
      else
         first.previous = newLink;
      newLink.next = first;
      first = newLink;
   }

   // -------------------------------------------------------------
   public void insertLast(long dd) // insert at end of list
   {
      Link newLink = new Link(dd);
      if (isEmpty())
         first = newLink;
      else {
         last.next = newLink;
         newLink.previous = last;
      }
      last = newLink;
   }

   // -------------------------------------------------------------
   public Link deleteFirst() // delete first link
   { // (assumes non-empty list)
      Link temp = first;
      if (first.next == null) { // if only one item
         last = null; // null <-- last
      } else {
         first.next.previous = null; // null <-- old next
      }
      first = first.next; // first --> old next
      return temp;
   }

   // -------------------------------------------------------------
   public Link deleteLast() // delete last link
   { // (assumes non-empty list)
      Link temp = first;
      if (first.next == null)
         last = null;
      else
         first.next.previous = null;
      first = first.next;
      return temp;
   }

   // -------------------------------------------------------------
   // insert dd just after key
   public boolean insertAfter(long key, long dd) { // (assumes non-empty list)
      Link current = first; // start at beginning
      while (current.dData != key) // until match is found,
      {
         current = current.next; // move to next link
         if (current == null)
            return false; // didn't find it
      }
      Link newLink = new Link(dd); // make new link

      if (current == last) // if last link,
      {
         newLink.next = null; // newLink --> null
         last = newLink; // newLink <-- last
      } else // not last link,
      {
         newLink.next = current.next; // newLink --> old next
                                      // newLink <-- old next
         current.next.previous = newLink;
      }
      newLink.previous = current; // old current <-- newLink
      current.next = newLink; // old current --> newLink
      return true; // found it, did insertion
   }

   // -------------------------------------------------------------
   public Link deleteKey(long key) {
      Link current = first;
      while (current != null && current.dData != key) {
         current = current.next;
      }

      if (current == null) {
         return null; // Key not found
      }

      // If node to be deleted is the first node
      if (first == current) {
         first = current.next;
      }

      // If node to be deleted is the last node
      if (last == current) {
         last = current.previous;
      }

      // Update next and previous references
      if (current.next != null) {
         current.next.previous = current.previous;
      }
      if (current.previous != null) {
         current.previous.next = current.next;
      }

      return current;
   }

   // -------------------------------------------------------------
   public void displayForward() {
      Link current = first;
      while (current != null) {
         current.displayLink();
         current = current.next;
      }
      System.out.println("");
   }

   // -------------------------------------------------------------
   public void displayBackward() {
      Link current = last;
      while (current != null) {
         current.displayLink();
         current = current.previous;
      }
      System.out.println("");
   }
   // -------------------------------------------------------------
} // end class DoublyLinkedList
  ////////////////////////////////////////////////////////////////

class DoublyLinkedApp {
   public static void main(String[] args) { // make a new list
      DoublyLinkedList theList = new DoublyLinkedList();

      theList.insertFirst(22); // insert at front
      theList.insertFirst(44);
      theList.insertFirst(66);

      theList.insertLast(11); // insert at rear
      theList.insertLast(33);
      theList.insertLast(55);

      theList.displayForward(); // display list forward
      theList.displayBackward(); // display list backward

      theList.deleteFirst(); // delete first item
      theList.deleteLast(); // delete last item
      theList.deleteKey(11); // delete item with key 11

      theList.displayForward(); // display list forward

      theList.insertAfter(22, 77); // insert 77 after 22
      theList.insertAfter(33, 88); // insert 88 after 33

      theList.displayForward(); // display list forward
   } // end main()
} // end class DoublyLinkedApp
  ////////////////////////////////////////////////////////////////
