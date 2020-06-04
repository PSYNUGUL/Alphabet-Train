//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Alphabet Train
// Files: AlphabetList.java , AlphabetListTester.java, LinkedCart.java
// Course: CS300 Spring 2020
//
// Author: Yeon Jae Cho
// Email: ycho226@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: none
// Partner Email: none
// Partner Lecturer's Name: none
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: none
// Online Sources:
// https://www.geeksforgeeks.org/difference-between-throw-and-throws-in-java/
// - helped for distinguishing way to write in Javadoc for checked/unchecked exception.
//
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class implements SortedListADT<T> with type of Cart for using the classes given in
 * SortedListADT with changed Type value.
 * 
 */
public class AlphabetList implements SortedListADT<Cart> {
  /**
   * Smallest cart that can be added to this sorted list
   */
  private static final Cart MIN_CART = new Cart("A");

  /**
   * Largest cart that can be added to this sorted list
   */
  private static final Cart MAX_CART = new Cart("Z");

  /**
   * Head of this doubly linked list
   */
  private LinkedCart head;

  /**
   * Tail of this doubly linked list
   */
  private LinkedCart tail;

  /**
   * Size of this list
   */
  private int size;

  /**
   * Maximum number of carts which can be stored in this list
   */
  private int capacity;

  /**
   * Constructor for AlphabetList class with no parameter. It initializes head, tail, capacity
   * values.
   */
  public AlphabetList() {
    this.head = null;
    this.tail = null;
    this.capacity = 26;
  }

  /**
   * Constructor for AlphabetList class with parameter "capacity". It initializes head , tail , and
   * capacity with given parameter value.
   * 
   * @throws IllegalArgumentException is thrown when capacity is less than or equal to 0.
   */
  public AlphabetList(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException(
          "The capacity of this list must be a non-zero a positive integer.");
    }
    this.head = null;
    this.tail = null;
    this.capacity = capacity;

  }

  /**
   * Returns a String representation of this list (example: [ A B C ]).
   * 
   * Overrides toString()
   * 
   * @return a String representation of this list
   */
  @Override
  public String toString() {
    String string = "This list contains " + size + " cart(s)";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    LinkedCart currentCart = head;
    while (currentCart != null) {
      string += currentCart.getCart().toString() + " ";
      currentCart = currentCart.getNext();
    }
    string += "]";
    return string;

  }

  /**
   * Checks list if it is empty or not
   * 
   * @return true when list is empty
   */
  @Override
  public boolean isEmpty() {
    if (head == null && tail == null) {
      return true;
    }

    return false;
  }

  /**
   * Adds a new cart to this sorted list to add Carts in alphabetical sequence
   * 
   * Specified by add in interface SortedListADT<Cart>
   * 
   * @param newCart to add
   * @throws IllegalStateException    if list is full
   * @throws IllegalArgumentException if newObject is non-upper case alphabetic letter
   */
  @Override
  public void add(Cart newCart) {
    LinkedCart initialCart = new LinkedCart(newCart);
    if (size == capacity) {
      throw new IllegalStateException("This list is full. Cannot add another cart.");
    }
    if (newCart.compareTo(MIN_CART) < 0 || newCart.compareTo(MAX_CART) > 0
        || newCart.getCargo().length() > 1) {
      throw new IllegalArgumentException(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
    }
    if (head == null) {
      head = initialCart;
      tail = head;
      size = 1;
    } else {

      LinkedCart headCart = head;
      LinkedCart tailCart = tail;

      while (null != headCart) {

        if (newCart.getCargo().compareTo(headCart.getCart().getCargo()) < 0) {
          LinkedCart currentCart = new LinkedCart(newCart, headCart.getPrevious(), headCart);
          if (headCart.getPrevious() != null) {
            headCart.getPrevious().setNext​(currentCart);
          }
          headCart.setPrevious​(currentCart);
          size++;
          if (head == headCart) {
            head = currentCart;
          }

          break;
        }

        else if (newCart.getCargo().compareTo(tailCart.getCart().getCargo()) > 0) {
          LinkedCart currentCart = new LinkedCart(newCart, tailCart, tailCart.getNext());

          if (tailCart.getNext() != null) {
            tailCart.getNext().setPrevious​(currentCart);
          }
          tailCart.setNext​(currentCart);
          size++;
          if (tail == tailCart) {
            tail = currentCart;
          }

          break;
        } else if (newCart.getCargo().equals(headCart.getCart().getCargo())) {
          throw new IllegalArgumentException("Cannot duplicate letters or carts in this list.");
        } else {
          headCart = headCart.getNext();
        }
      }

    }
  }

  /**
   * Returns the size of this list.
   * 
   * Specified by size in interface SortedListADT<Cart>.
   * 
   * @return the number of carts linked in this list
   */

  @Override
  public int size() {
    return size;

  }

  /**
   * Returns the capacity of this list in terms of maximum number of carts which can be stored in
   * it.
   * 
   * @return the capacity of this list
   */
  public int capacity() {
    return capacity;
  }

  /**
   * Removes all the carts from this list. This list must be empty after this method returns by
   * setting size to 0, and head and tail pointer to null.
   * 
   * Specified by clear in interface SortedListADT<Cart>
   * 
   */
  @Override
  public void clear() {
    size = 0;
    head = null;
    tail = null;
  }

  /**
   * Returns the cart at position index of this list without removing it
   * 
   * Specified by get in interface SortedListADT<Cart>
   * 
   * @param index of the cart to return
   * @return the cart of this sorted list at the given index
   * @throws IndexOutOfBoundsException if index is less than 0 or index is greater or equal to
   *                                   size()
   * 
   */
  @Override
  public Cart get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid index." + index);
    }
    LinkedCart headCart = head;
    int cnt = 0;
    while (null != headCart) {
      if (index == cnt) {
        return headCart.getCart();
      }
      headCart = headCart.getNext();
      cnt++;
    }
    return null;
  }

  /**
   * Returns the index of the cart carrying data within this list with algorithm using head and tail
   * pointer of the list.
   * 
   * Specified by indexOf in interface SortedListADT<Cart>
   * 
   * @param findCart element to find in this list
   * @return the index of findCart within this list or -1 if this list does not contain that cart.
   */

  @Override
  public int indexOf(Cart findCart) {
    int index = 0;
    LinkedCart headCart = head;
    while (headCart != null) {
      if (findCart.getCargo().equals(headCart.getCart().getCargo())) {
        return index;
      } else {
        headCart = headCart.getNext();
        index += 1;
      }
    }
    return -1;
  }

  /**
   * Returns and removes the cart from this sorted list at the given index position
   * 
   * @param index of the cart to be removed
   * @return the removed cart
   * @throws IndexOutOfBoundsException if index is less than 0 or index is greater or equal to
   *                                   size()
   */
  @Override
  public Cart remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid index." + index);
    }

    LinkedCart temp = head;
    int count = 0;


    while (temp != null) {
      if (index == count) {

        if (index == 0) {
          if (size == 1) {
            clear();
            return null;
          }

          else if (head.equals(temp)) { // removing head
            head = head.getNext();
            head.setPrevious​(null);
            size--;
            return temp.getCart();

          }
        }

        if (this.tail.equals(temp)) { // removing tail
          this.tail = this.tail.getPrevious();
          this.tail.setNext​(null);
          this.size--;
          return temp.getCart();
        }

        else {
          if (index > 0) {
            temp.getPrevious().setNext​(temp.getNext());
            if (null != temp.getNext()) {
              temp.getNext().setPrevious​(temp.getPrevious());
            }
            this.size--;
            return temp.getCart();
          }
        }

      }

      temp = temp.getNext();
      count++;

      if (count > index) {
        break;
      }
    }
    return null;
  }

  /**
   * Reads the contents of this list in the forward direction starting from its head.
   * 
   * @return a String representation of the contents of this list read in the forward direction or
   *         an empty string if this list is empty. For instance, if the list contains the following
   *         letters "A", "B", "D", "M", and "O". This method MUST return the following string
   *         "ABDMO".
   */
  public String readForward() {

    String result = "";
    if (head == null) {
      result = "";

    } else {
      LinkedCart currentCart = head;
      while (currentCart != null) {
        result += currentCart.getCart().toString();
        currentCart = currentCart.getNext();
      }
    }
    return result;
  }


  /**
   * Reads the contents of this list in the backward direction starting from its tail.
   * 
   * @return a String representation of the contents of this list read in the backward direction or
   *         an empty string if this list is empty. For instance, if the list contains the following
   *         letters "A", "B", "D", "M", and "O". This method MUST return the following string
   *         "OMDBA".
   */
  public String readBackward() {
    String result = "";
    if (head == null) {
      result = "";

    } else {
      LinkedCart currentCart = tail;
      while (currentCart != null) {
        result += currentCart.getCart().toString();
        currentCart = currentCart.getPrevious();
      }

    }
    return result;
  }

}
