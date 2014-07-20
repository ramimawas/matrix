/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.list;

/**
 * @param <T>
 */
public class ListNode<T extends Comparable<T>> {
  private ListNode next;
  private T data;
  private int index;
  
  public ListNode() {
  }
  
  public ListNode(ListNode node, T data, int index) {
    this.data = data;
    this.next = node;
    this.index = index;
  }
  
  public ListNode(T data, int index) {
    this(null, data, index);
  }
  
  public ListNode(T data) {
    this(null, data, -1);
  }
  
  public ListNode next() {
    return next;
  }

  public ListNode getNext() {
    return next;
  }

  public ListNode setNext(ListNode next) {
    this.next = next;
    return this;
  }

  public T getData() {
    return data;
  }

  public ListNode setData(T data) {
    this.data = data;
    return this;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
}
