/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.rami.algo.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 *
 * @author rami <rami.developer@gmail.com>
 */
public class BinaryTree<T extends Comparable<T>> {
  private static final Logger logger = LoggerFactory.getLogger(BinaryTree.class);
  private TreeNode root;
  private int count = 0;

  public enum Order {
    PRE, POST, IN
  }
  public enum Branch {
    LEFT, RIGHT
  }

  public BinaryTree() {
    root = null;
  }

  public TreeNode insert(List<T> toInsertDataList) {
    if(toInsertDataList == null || toInsertDataList.size() == 0)
        return null;
    for(T data: toInsertDataList)
        insert(data);
    return root;
  }

  public TreeNode insert(TreeNode toInsert) {
    if(root == null)
        return root = toInsert;
    else
        return _insert(toInsert, root);
  }

  public TreeNode insert(T toInsertData) {
    if(root == null)
        return root = new TreeNode(toInsertData, count++);
    else
        return insert(toInsertData, root);
  }

  public TreeNode insert(T toInsertData, TreeNode insertUnder) {
    TreeNode node = new TreeNode(toInsertData, count);
    return _insert(node, insertUnder);
  }

  private TreeNode _insert(TreeNode toInsert, TreeNode insertUnder) {
    TreeNode node = null;
    int comp = insertUnder.getData().compareTo(toInsert.getData());
    if(comp > 0) {
        if (insertUnder.getLeft() == null) {
            node = insertUnder.setLeft(toInsert);
            count++;
        } else {
            node = _insert(toInsert, insertUnder.getLeft());
        }
    } else if (comp < 0) {
        if (insertUnder.getRight() == null) {
            node = insertUnder.setRight(toInsert);
            count++;
        } else
            node = _insert(toInsert, insertUnder.getRight());
    }
    return node;
  }

  public TreeNode find(TreeNode toFind) {
    return find(toFind, root);
  }

  public TreeNode find(T toFind) {
    TreeNode node = new TreeNode(toFind);
    if(root == null)
        return null;
    else return find(node, root);
  }

  private TreeNode find(TreeNode toFind, TreeNode findUnder) {
    TreeNode found = null;
    if(findUnder == null || toFind == null)
        found = null;
    else {
        int comp = findUnder.getData().compareTo(toFind.getData());
        if(comp == 0)
            found = findUnder;
        else if (comp > 0)
            found = find(toFind, findUnder.getLeft());
        else if (comp < 0)
            found = find(toFind, findUnder.getRight());
    }
    return found;
  }

  public TreeNode remove(Object toRemove) {
    count--;
    return null;
  }

  public void print(Order order) {
    List list = toList(order);
    logger.info(list.toString());
  }

  public List<Object> toList(Order order) {
    List list = new ArrayList();
    if (root != null) {
        switch(order) {
            case PRE:
                list = toListPre(root);
                break;
            case POST:
                list = toListPost(root);
                break;
            case IN:
                list = toListIn(root);
                break;
        }
    }
    return list;
  }

  private List toListPre(TreeNode n) {
    // root, left, right
    List list = new ArrayList();
    return list;
  }

  private List toListPost(TreeNode n) {
    // left, root, right
    List list = new ArrayList();
    return list;
  }

  private List toListIn(TreeNode n) {
    // left, root, right
    List list = new ArrayList<TreeNode>();
    if(n.getLeft()!=null)
        list.addAll(toListIn(n.getLeft()));
    list.add(n.getData());
    if(n.getRight()!=null)
        list.addAll(toListIn(n.getRight()));
    return list;
  }

  public int maxDepth() {
    return _maxDepth(root);
  }

  public int _maxDepth(TreeNode n) {
    if(n == null)
        return 0;
    return Math.max(_maxDepth(n.getLeft()), _maxDepth(n.getRight())) + 1;
  }

  public int size() {
    return count;
  }

  public TreeNode getRoot() {
    return root;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }
}
