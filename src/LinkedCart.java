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
 * This Class is for implementations of methods for LinkedCart used for AlphabetList class.
 */
public class LinkedCart {
  /**
   * Data field of this linked Cart
   */
  private final Cart CART;

  /**
   * Reference to the previous linked cart in a list of carts
   */
  private LinkedCart previous;

  /**
   * Reference to the next linked cart in a list of carts
   */
  private LinkedCart next;

  /**
   * Creates a new LinkedCart object with specific data cart and null for both previous and next
   * linked carts.
   * 
   * @param cart - data of this linked cart
   */
  public LinkedCart(Cart cart) {
    this.CART = cart;
    previous = null;
    next = null;
  }

  /**
   * Creates a new LinkedCart object with specific data cart, previous and next linked carts.
   * 
   * @param cart - data of this linkedCart
   */
  public LinkedCart(Cart cart, LinkedCart previous, LinkedCart next) {
    this.CART = cart;
    this.previous = previous;
    this.next = next;
  }

  /**
   * Returns a reference to the data cart of this linked cart.
   * 
   * @return the data cart of this LinkedCart
   */
  public Cart getCart() {
    return CART;
  }

  /**
   * Returns a reference to the previous LinkedCart attached to this linked cart.
   * 
   * @return the previous LinkedCart
   */
  public LinkedCart getPrevious() {
    return previous;
  }

  /**
   * Sets the previous LinkedCart attached to this LinkedCart.
   * 
   * @param previous - the previous to set
   */
  public void setPrevious​(LinkedCart previous) {
    this.previous = previous;
  }

  /**
   * Returns a reference to the next LinkedCart attached to this LinkedCart.
   * 
   * @return the next LinkedCart
   */
  public LinkedCart getNext() {
    return next;
  }

  /**
   * Sets the next LinkedCart attached to this LinkedCart.
   * 
   * @param next - the next to set
   */
  public void setNext​(LinkedCart next) {
    this.next = next;
  }
}
