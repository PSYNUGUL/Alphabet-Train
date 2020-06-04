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
 * This class implements unit test methods to check the correctness of LinkedCart and AlphabetList
 * classes defined in the CS300 Spring 2020 - P06 Alphabet Train programming assignment.
 *
 */
public class AlphabetListTester {

  /**
   * This method should test and make use of at least the LinkedCart constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedCart() {
    LinkedCart one = new LinkedCart(new Cart("A"));
    if (one.getPrevious() != null || one.getNext() != null) {
      return false;
    }
    LinkedCart two = new LinkedCart(new Cart("C"));
    LinkedCart three = new LinkedCart(new Cart("B"), one, two);

    if (three.getPrevious() != one || three.getNext() != two) {
      return false;

    }

    LinkedCart fourPrevious = new LinkedCart(new Cart("A"));
    LinkedCart fourNext = new LinkedCart(new Cart("C"));
    LinkedCart four = new LinkedCart(new Cart("B"), fourPrevious, fourNext);
    if (four.getPrevious() != fourPrevious || four.getNext() != fourNext) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of both AlphabetList constructors and the instance
   * method isEmpty() when called on an empty alphabet list object.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorIsEmpty() {

    AlphabetList list1 = new AlphabetList();
    if (!list1.isEmpty()) {
      return false;
    }

    AlphabetList list2 = new AlphabetList();
    if (!list2.isEmpty()) {
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList(int) constructor when passed a
   * negative int value.
   * 
   * case 1 : Negative capacity passed to AlphabetList
   * 
   * case 2 : Zero capacity passed to AlphabetList
   * 
   * case 3 : Extreme negative capacity passed to AlphabetList
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorBadInput() {
    try {
      AlphabetList list1 = new AlphabetList(-10);
      System.out.println("Problem detected. The constructor call of the AlphabetList did not "
          + "throw an IllegalArgumentException when it is passed a negative capacity.");
      return false;
    } catch (IllegalArgumentException e1) {
      if (e1.getMessage() == null
          || !e1.getMessage().toLowerCase().contains("must be a non-zero a positive integer")) {
        System.out
            .println("Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the AlphabetList when it is passed a negative capacity "
                + "does not contain an appropriate error message.");
        return false;
      }
    }

    try {
      AlphabetList list2 = new AlphabetList(0);
      list2.add(new Cart("A"));
      System.out.println("Problem detected. The call of add method in AlphabetList list2 did not "
          + "throw an IllegalArgumentException when it is passed a negative capacity.");
      return false;
    } catch (IllegalArgumentException e2) {
      if (e2.getMessage() == null
          || !e2.getMessage().toLowerCase().contains("must be a non-zero a positive integer")) {
        System.out.println("Problem detected. The IllegalArgumentException thrown by the"
            + " call of the addCoins method in list2 of AlphabeticList  when it has negative capacity "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    try {
      AlphabetList list3 = new AlphabetList(-999999999);
      System.out.println("Problem detected. The constructor call of the AlphabetList did not "
          + "throw an IllegalArgumentException when it is passed a negative capacity.");
      return false;
    } catch (IllegalArgumentException e3) {
      if (e3.getMessage() == null || !e3.getMessage()
          .contains("The capacity of this list must be a non-zero a positive integer")) {
        System.out.println("Problem detected. The IllegalArgumentException thrown by the "
            + "call of the AlphabetList when it is passed an extreme negative capacity "
            + "does not contain an appropriate error message.");
        return false;
      }
    }
    return true;
  }


  /**
   * This method checks for the correctness of the AlphabetList.add() method when it is passed bad
   * inputs. This method must consider at least the test scenarios provided in the detailed
   * description of these javadocs. (1) Try adding a null to the list; (2) Try adding a cart which
   * carries a non upper-case alphabet letter, for instance "Hello" or "1" or "a". (3) Try adding a
   * duplicate cart to the list.
   * 
   * case 1 : Null reference passed to add method
   * 
   * case 2 : String w/ length over 1 passed to add method
   * 
   * case 3 : Number passed to add method
   * 
   * case 4 : Non lower-case alphabet letter passed to add method
   * 
   * case 5 : Duplicate letter passed to add method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAddBadInput() {
    // case 1
    try {
      AlphabetList list = new AlphabetList();
      String nullString = "";
      list.add(new Cart(nullString));
      System.out.println("Problem detected. The add method did not "
          + "throw an IllegalArgumentException when it is passed a null reference.");
      return false;
    } catch (IllegalArgumentException e1) {
      if (e1.getMessage() == null || !e1.getMessage().contains(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.")) {
        System.out.println("Problem detected. The IllegalArgumentException thrown by the "
            + "call of the add method when it is passed a null reference "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    // case 2
    try {
      AlphabetList list = new AlphabetList();
      list.add(new Cart("Hello"));
      System.out.println("Problem detected. The add method did not "
          + "throw an IllegalArgumentException when it is passed a string over length of one.");
      return false;
    } catch (IllegalArgumentException e2) {
      if (e2.getMessage() == null || !e2.getMessage().contains(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.")) {
        System.out.println("Problem detected. The IllegalArgumentException thrown by the "
            + "call of the add method when it is passed a string over length of one "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    // case 3
    try {
      AlphabetList list = new AlphabetList();
      list.add(new Cart("1"));
      System.out.println("Problem detected. The add method did not "
          + "throw an IllegalArgumentException when it is passed a number.");
      return false;
    } catch (IllegalArgumentException e3) {
      if (e3.getMessage() == null || !e3.getMessage().contains(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.")) {
        System.out.println("Problem detected. The IllegalArgumentException thrown by the "
            + "call of the add method when it is passed a number "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    // case 4
    try {
      AlphabetList list = new AlphabetList();
      list.add(new Cart("a"));
      System.out.println("Problem detected. The add method did not "
          + "throw an IllegalArgumentException when it is passed a lower-case alphabet letter.");
      return false;
    } catch (IllegalArgumentException e4) {
      if (e4.getMessage() == null || !e4.getMessage().contains(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.")) {
        System.out.println("Problem detected. The IllegalArgumentException thrown by the "
            + "call of the add method when it is passed a lower-case alphabet letter "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    // case 5
    try {
      AlphabetList list = new AlphabetList();
      Cart A = new Cart("A");
      list.add(A);
      list.add(A);
      System.out.println("Problem detected. The add method did not "
          + "throw an IllegalArgumentException when it is passed a duplicate alphabet letter.");
      return false;
    } catch (IllegalArgumentException e4) {
      if (e4.getMessage() == null
          || !e4.getMessage().contains("Cannot duplicate letters or carts in this list.")) {
        System.out.println("Problem detected. The IllegalArgumentException thrown by the "
            + "call of the add method when it is passed a duplicate alphabet letter "
            + "does not contain an appropriate error message.");
        return false;
      }
    }


    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList.add() considering at least the test
   * scenarios provided in the detailed description of these javadocs. (1) Try adding a cart to an
   * empty list; (2) Try adding a cart which is expected to be added at the head of a non-empty
   * alphabet list; (3) Try adding a cart which is expected to be added at the end of a non-empty
   * alphabet list; (4) Try adding a cart which is expected to be added at the middle of a non-empty
   * alphabet list. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions. You can
   * also check the correctness of AlphabetList.get(int), AlphabetList.indexOf(Cart), and
   * AlphabetList.size() in this test method.
   * 
   * case 1 : Cart added to empty list
   * 
   * case 2 : Cart added to head of non-empty list
   * 
   * case 3 : Cart added to the tail of non-empty list
   * 
   * case 4 : Cart added to middle of non-empty list
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAdd() {
    // case 1
    AlphabetList list1 = new AlphabetList();
    Cart cart = new Cart("A");
    list1.add(cart);
    if (list1.size() != 1 || !list1.readBackward().contentEquals("A")
        || !list1.readForward().contentEquals("A")) {
      return false;
    }

    // case 2
    AlphabetList list2 = new AlphabetList();
    Cart newHeadCart = new Cart("A");
    Cart prevHeadCart = new Cart("B");
    list2.add(prevHeadCart);
    list2.add(newHeadCart);
    if (list2.size() != 2 || !list2.readBackward().contentEquals("BA")
        || !list2.readForward().contentEquals("AB")) {
      return false;
    }

    // case 3
    AlphabetList list3 = new AlphabetList();
    Cart newTailCart = new Cart("C");
    Cart prevTailCart = new Cart("B");
    Cart headCart = new Cart("A");

    list3.add(headCart);
    list3.add(prevTailCart);
    list3.add(newTailCart);
    if (list3.size() != 3 || !list3.readBackward().contentEquals("CBA")
        || !list3.readForward().contentEquals("ABC")) {
      return false;
    }

    // case 4
    AlphabetList list4 = new AlphabetList();
    Cart endCart = new Cart("D");
    Cart newMiddleCart = new Cart("B");
    Cart startCart = new Cart("A");

    list4.add(startCart);
    list4.add(endCart);
    list4.add(newMiddleCart);
    if (list4.size() != 3 || !list4.readBackward().contentEquals("DBA")
        || !list4.readForward().contentEquals("ABD")) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList.remove() considering at least the
   * test scenarios provided in the detailed description of these javadocs. (1) Try removing a cart
   * from an empty list or pass a negative index to AlphabetList.remove() method; (2) Try removing a
   * cart (at position index 0) from a list which contains only one cart; (3) Try to remove a cart
   * (position index 0) from a list which contains at least 2 carts; (4) Try to remove a cart from
   * the middle of a non-empty list containing at least 3 carts; (5) Try to remove the cart at the
   * end of a list containing at least two carts. For each of those scenarios, make sure that the
   * size of the list is appropriately updated after a call without errors of the add() method, and
   * that the contents of the list is as expected whatever if list is read in the forward or
   * backward directions.
   * 
   * case 1 : Cart removed from empty list
   * 
   * case 2 : Negative index passed to remove() method
   * 
   * case 3 : Cart at index 0 removed from list with only one cart
   * 
   * case 4 : Cart at index 0 removed from list with at least 2 carts
   * 
   * case 5 : Cart at middle index removed from non-empty list with at least 3 carts
   * 
   * case 6 : Cart at end removed from list with at least two carts
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListRemove() {
    // case 1
    try {
      AlphabetList list = new AlphabetList();
      list.remove(0);
      System.out.println("Problem detected. The remove method did not "
          + "throw an IndexOutOfBoundsException when it removed an empty list.");
      return false;
    } catch (IndexOutOfBoundsException e3) {
      if (e3.getMessage() == null || !e3.getMessage().contains("Invalid index.")) {
        System.out.println("Problem detected. The IndexOutOfBoundsException thrown by the "
            + "call of the remove method when it removed an empty list "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    // case 2
    try {
      AlphabetList list = new AlphabetList();
      list.add(new Cart("A"));
      list.remove(-1);
      System.out.println("Problem detected. The remove method did not "
          + "throw an IndexOutOfBoundsException when its index is negative.");
      return false;
    } catch (IndexOutOfBoundsException e3) {
      if (e3.getMessage() == null || !e3.getMessage().contains("Invalid index.")) {
        System.out.println("Problem detected. The IndexOutOfBoundsException thrown by the "
            + "call of the remove method when its index is negative "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    // case 3
    AlphabetList list = new AlphabetList();
    list.add(new Cart("B"));
    list.remove(0);
    if (list.size() != 0 || !list.isEmpty()) {
      return false;
    }

    // case 4
    AlphabetList list1 = new AlphabetList();
    list1.add(new Cart("A"));
    list1.add(new Cart("B"));
    list1.add(new Cart("C"));
    list1.remove(0);
    if (!list1.readBackward().contentEquals("CB") || list1.size() != 2
        || !list1.readForward().contentEquals("BC")) {
      return false;
    }

    // case 5
    AlphabetList list2 = new AlphabetList();
    list2.add(new Cart("A"));
    list2.add(new Cart("C"));
    list2.add(new Cart("E"));
    list2.remove(1);
    if (list2.size() != 2 || !list2.readBackward().contentEquals("EA")
        || !list2.readForward().contentEquals("AE")) {
      return false;
    }

    // case 6
    AlphabetList list3 = new AlphabetList();
    list3.add(new Cart("Z"));
    list3.add(new Cart("A"));
    list3.add(new Cart("B"));
    list3.remove(2);
    if (list3.size() != 2 || !list3.readBackward().contentEquals("BA")
        || !list3.readForward().contentEquals("AB")) {
      return false;
    }
    return true;
  }

  /**
   * This method calls Clear() to check if it actually "clears" the list changed by various other
   * methods such as add() and remove().
   * 
   * case 1 : List with 3 carts cleared
   * 
   * case 2 : Empty list cleared
   * 
   * case 3 : List in random order cleared
   * 
   * @return true if the method works as expected
   */
  public static boolean testClear() {
    // case 1
    AlphabetList list = new AlphabetList();
    list.add(new Cart("Z"));
    list.add(new Cart("A"));
    list.add(new Cart("B"));
    list.clear();
    if (list.size() != 0 || !list.isEmpty()) {
      return false;
    }

    // case 2
    AlphabetList list1 = new AlphabetList();
    list1.clear();
    if (list1.size() != 0 || !list1.isEmpty()) {
      return false;
    }

    // case 3
    AlphabetList list2 = new AlphabetList();
    list2.add(new Cart("Z"));
    list2.add(new Cart("A"));
    list2.add(new Cart("B"));
    list2.add(new Cart("D"));
    list2.add(new Cart("C"));
    list2.add(new Cart("F"));
    list2.add(new Cart("E"));
    list2.clear();
    if (list2.size() != 0 || !list2.isEmpty()) {
      return false;
    }

    return true;
  }

  /**
   * This method checks if get() method outputs the correct Cart at its given index and throws
   * IndexOutOfBoundsException at set conditions.
   *
   * case 1 : Cart resulted from the non-empty list
   * 
   * case 2 : Error thrown if the index is equal to its size from empty list
   * 
   * case 3 : Error thrown if index is greater than its size
   * 
   * case 4 : Error thrown if index is less than zero
   *
   * @return true if method works as expected
   */
  public static boolean testGet() {
    // case 1
    AlphabetList list = new AlphabetList();
    Cart head = new Cart("Z");
    Cart tail = new Cart("A");
    list.add(head);
    list.add(tail);
    if (list.get(0) != tail) {
      return false;
    }

    // case 2
    try {
      AlphabetList list1 = new AlphabetList();
      list1.get(0);
      System.out.println("Problem detected. The get method did not "
          + "throw an IndexOutOfBoundsException when its index is equal to its size.");
      return false;
    } catch (IndexOutOfBoundsException e) {
      if (e.getMessage() == null || !e.getMessage().contains("Invalid index.")) {
        System.out.println("Problem detected. The IndexOutOfBoundsException thrown by the "
            + "call of the get method when its index is equal to its size "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    // case 3
    try {
      AlphabetList list1 = new AlphabetList();
      list1.get(1);
      System.out.println("Problem detected. The get method did not "
          + "throw an IndexOutOfBoundsException when its index is greater than its size.");
      return false;
    } catch (IndexOutOfBoundsException e) {
      if (e.getMessage() == null || !e.getMessage().contains("Invalid index.")) {
        System.out.println("Problem detected. The IndexOutOfBoundsException thrown by the "
            + "call of the get method when its index is greater than its size "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    // case 4
    try {
      AlphabetList list1 = new AlphabetList();
      list1.get(-1);
      System.out.println("Problem detected. The get method did not "
          + "throw an IndexOutOfBoundsException when its index is less than 0.");
      return false;
    } catch (IndexOutOfBoundsException e) {
      if (e.getMessage() == null || !e.getMessage().contains("Invalid index.")) {
        System.out.println("Problem detected. The IndexOutOfBoundsException thrown by the "
            + "call of the get method when its index is less than 0 "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    return true;
  }

  /**
   * This method checks if indexOf() appropriately returns the int value according to set
   * conditions.
   * 
   * case 1 : Index of cart at given list with at least two carts returned
   * 
   * case 2 : Index of cart at given list in random orders returned
   * 
   * case 3 : Index of -1 returned due to unavailability of the given cart at index
   * 
   * @return true if the method works as expected
   */
  public static boolean testIndexOf() {
    // case 1
    AlphabetList list = new AlphabetList();
    list.add(new Cart("A"));
    list.add(new Cart("B"));
    if (list.indexOf(new Cart("A")) != 0) {
      return false;
    }

    // case 2
    AlphabetList list1 = new AlphabetList();
    list1.add(new Cart("A"));
    list1.add(new Cart("B"));
    list1.add(new Cart("E"));
    list1.add(new Cart("C"));
    if (list1.indexOf(new Cart("E")) != 3) {
      return false;
    }

    // case 3
    AlphabetList list2 = new AlphabetList();
    if (list2.indexOf(new Cart("A")) != -1) {
      return false;
    }
    return true;
  }

  /**
   * This method calls all the test methods defined and implemented in your AlphabetListTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    if (!testLinkedCart() || !testAlphabetListAdd() || !testAlphabetListConstructorIsEmpty()
        || !testAlphabetListConstructorBadInput() || !testAlphabetListAddBadInput()
        || !testAlphabetListRemove() || !testClear() || !testGet() || !testIndexOf()) {
      return false;
    }
    return true;
  }

  /**
   * Driver method defined in this AlphabetListTester class.
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {

    System.out.println("Testing LinkedCart constructor: " + testLinkedCart());
    System.out.println("Testing add() method: " + testAlphabetListAdd());
    System.out.println("Testing isEmpty() method: " + testAlphabetListConstructorIsEmpty());
    System.out.println(
        "Testing AlphabetList constructor w/ error: " + testAlphabetListConstructorBadInput());
    System.out.println("Testing add() method w/ error: " + testAlphabetListAddBadInput());
    System.out.println("Testing remove() method w/ error: " + testAlphabetListRemove());
    System.out.println("Testing clear() method: " + testClear());
    System.out.println("Testing get() method: " + testGet());
    System.out.println("Testing indexOf() method: " + testIndexOf());
    System.out.println("Testing all tests: " + runAllTests());
  }
}
