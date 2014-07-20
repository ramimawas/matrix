/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.list;

import java.util.ArrayList;
import java.util.List;
import name.rami.algo.tree.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @param <T>
 */
public class LinkedList<T extends Comparable<T>> {
  private static final Logger logger = LoggerFactory.getLogger(LinkedList.class);
  private ListNode head;
  private ListNode tail;
  private int size;
  
  public LinkedList() {}
  
  public LinkedList(List<T> toInsertList) {
    append(toInsertList);
  }
  
  public LinkedList(T[] toInsertList) {
    append(toInsertList);
  }
  
  public ListNode append(T[] toInsertList) {
    if(toInsertList != null)
      for(T data: toInsertList)
        append(data);
    return head;
  }
  
  public ListNode append(List<T> toInsertList) {
    if(toInsertList != null)
      for(T data: toInsertList)
        append(data);
    return head;
  }
  
  public ListNode append(T toAdd) {
    return tail = (head == null || tail == null)? head = createNode(toAdd): insertAfter(toAdd, tail);
  }
  
  public ListNode remove(T toRemove) {
    ListNode previous = head, found = null;
    if(head != null && toRemove != null) {
      if(previous.getData().compareTo(toRemove)==0) {
        found = previous;
        head = found.getNext();
      } else {
        if ((previous = findPrevious(toRemove)) != null) {
          found = previous.getNext();
          previous.setNext(found.getNext());
          
        }
      }
    }
    if(found != null) {
      size--;
      tail = (head == null)? head: (found == tail? previous: tail);
    }
    return found;
  }
  
  private ListNode createNode(T toCreate) {
    return new ListNode(toCreate, size++);
  }
  
  private ListNode createNode(T toCreate, ListNode next) {
    ListNode node = new ListNode(toCreate, size++);
    node.setNext(next);
    return node;
  }
  
  public ListNode insertAfter(T toAdd, T toInsertAfter) {
    ListNode found;
    if((found = find(toInsertAfter)) != null) {
      found.setNext(createNode(toAdd,found.getNext()));
      if ( tail == found)
        tail = found.getNext();
    }
    return found!= null? found.getNext(): null;
  }
  
  public ListNode insertAfter(T toAdd, ListNode toInsertAfter) {
    if (toInsertAfter != null) {
     toInsertAfter.setNext(createNode(toAdd, toInsertAfter.getNext()));
     if (tail == toInsertAfter)
       tail = toInsertAfter.getNext();
    }
    return toInsertAfter!= null? toInsertAfter.getNext(): null;
  }
  
  public ListNode insertBefore(T toAdd, T toInsertBefore) {
    ListNode previous = head, added = null;
    if(previous != null) {
      if(previous.getData().compareTo(toInsertBefore) == 0)
        added = head = createNode(toAdd, head);
      else if ((previous = findPrevious(toInsertBefore)) != null)
        added = insertAfter(toAdd, previous);
    }
    return added;
  }
  
  public ListNode findPrevious(T toFind) {
    ListNode previous = head, found = null;
    while(previous.getNext() != null) {
      if(previous.getNext().getData().compareTo(toFind)==0) {
        found = previous;
        break;
      }
      previous = previous.getNext();
    }
    return found;
  }
  
  public ListNode find(T toFind) {
    ListNode tmp = head, found = null;
    while(tmp != null) {
      if(tmp.getData().compareTo(toFind)==0) {
        found = tmp;
        break;
      }
      tmp = tmp.getNext();
    }
    return found;
  }
  
  public ListNode findKthToLast(int k) {
    ListNode tmp1 = head, tmp2 = head;
    int count = 0;
    
    for(int i=0; i<k-1; i++) {
      if(tmp1 == null) return null;
      tmp1 = tmp1.getNext();
    }
    
   if(tmp1 == null) return null;
    
    while (tmp1 != null) {
      tmp1 = tmp1.getNext();
      tmp2 = tmp2.getNext();
    }    
    return tmp2;
  }
  
  public ListNode partition(T divider) {
    ListNode tmin = head, tmax = head, tmp;
    while(tmax.getNext() != null) {
      if (tmax.getNext().getData().compareTo(divider) >= 0) {
        tmax = tmax.getNext();
      } else {
        tmp = tmax.getNext();
        tmax.setNext(tmax.getNext().getNext());
        if(tmin == head) {
          tmp.setNext(head);
          tmin = head = tmp;
        } else {
          if(tmp != tmin.getNext())
            tmp.setNext(tmin.getNext());
          tmin.setNext(tmp);
        }
      }
    }
    return head;
  }
  
  public List toList() {
    List list = new ArrayList<ListNode>();
    ListNode tmp = head;
    while(tmp != null) {
      list.add(tmp.getData());
      tmp = tmp.getNext();
    }
    return list;
  }
  
  public void print() {
    logger.info(toList().toString());
  }
  
  public void printDetails() {
    logger.info(toList().toString());
    logger.info("head: " + head.getData());
    logger.info("tail: " + tail.getData());
    logger.info("size: " + size);
  }

  public ListNode head() {
    return head;
  }

  public ListNode tail() {
    return tail;
  }
  
  public int size() {
    return size;
  }
}