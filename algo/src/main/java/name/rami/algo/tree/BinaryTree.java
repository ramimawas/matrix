/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @param <T>
 */
public class BinaryTree<T extends Comparable<T>> {
  private static final Logger logger = LoggerFactory.getLogger(BinaryTree.class);
  private TreeNode root;
  private int count;

  public enum Order {
    PRE, POST, IN, DFS, BFS
  }
  public enum Branch {
    LEFT, RIGHT
  }

  public BinaryTree() {
    root = null;
    count = 0;
  }
  
  public TreeNode insert(T[] toInsertDataList) {
    if(toInsertDataList == null || toInsertDataList.length==0)
        return null;
    for(T data: toInsertDataList)
        insert(data);
    return root;
  }

  public TreeNode insert(List<T> toInsertDataList) {
    if(toInsertDataList == null || toInsertDataList.isEmpty())
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
  
  public List<Object> traverseDFS () {
    return null;
  }

  public TreeNode remove(Object toRemove) {
    count--;
    return null;
  }

  public void print(Order order) {
    List list = toList(order);
    logger.info(list.toString());
  }
  
  public String toString(Order order) {
    return toList(order).toString();
  }

  public List<T> toList(Order order) {
    List<T> list = new ArrayList();
    List<TreeNode> visited = new ArrayList<TreeNode>();
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
            case DFS:
              toListDFS(root, visited);
              for (TreeNode node : visited)
                list.add((T)node.getData());
              break;
            case BFS:
              toListBFS(root, visited);
              for (TreeNode node : visited)
                list.add((T)node.getData());
              break;
        }
    }
    return list;
  }

  private List toListPre(TreeNode n) {
    // root, left, right
    List list = new ArrayList();
    list.add(n.getData());
    if (n.getLeft() != null)
      list.addAll(toListPre(n.getLeft()));
    if (n.getRight() != null)
      list.addAll(toListPre(n.getRight()));
    return list;
  }

  private List toListPost(TreeNode n) {
    // left, root, right
    List list = new ArrayList();
    if (n.getLeft() != null)
      list.addAll(toListPre(n.getLeft()));
    if (n.getRight() != null)
      list.addAll(toListPre(n.getRight()));
    list.add(n.getData());
    return list;
  }
  
  // TODO: Fix. BROKEN!
  private void toListDFS(TreeNode root, List visited) {
    if (root != null) {
      visited.add(root);
      for (Iterator<TreeNode> it = root.getAdjacents().iterator(); it.hasNext();) {
        TreeNode node = it.next();
        if(!visited.contains(node))
          toListDFS(node, visited);
      }
    }
  }
  
  // TODO: Fix. BROKEN!
  private void toListBFS(TreeNode root, List<TreeNode> visited) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    if (root != null) {
      visited.add(root);
      queue.add(root);
      while(!queue.isEmpty()) {
        TreeNode n = queue.poll();
        for (TreeNode child : (List<TreeNode>)n.getAdjacents()) {
          if(!visited.contains(child)) {
            visited.add(child);
            queue.add(child);
          }
        }
      }
    }
  }
  
  public boolean isBinary() {
    Map results = isBinary(root);
    return (Boolean)results.get("isBinary");
  }

    public Map isBinary(TreeNode root) {
      Map minMax = null;
      logger.debug("In: {}", root!= null? root.getData(): 0);
      if(root==null) {
        return null;
      } else {
        minMax = new HashMap<String, T>();
        minMax.put("min", root.getData());
        minMax.put("max", root.getData());
        minMax.put("isBinary", true);
        logger.debug("going left from {}", root.getData());
        Map minMaxLeft = isBinary(root.getLeft());
        if(minMaxLeft != null) {
          if (root.getData().compareTo(minMaxLeft.get("max")) >= 0) {
            minMax.put("min", minMaxLeft.get("min"));
          } else {
            minMax.put("isBinary", false);
          }
        }
        if((Boolean)minMax.get("isBinary")== false) {
          logger.debug("going right from {}", root.getData());
          Map minMaxRight = isBinary(root.getRight());
          if(minMaxRight != null) {
            if(root.getData().compareTo(minMaxRight.get("min")) < 0) {
              minMax.put("max", minMaxRight.get("max"));
            } else {
              minMax.put("isBinary", false);
            }
          }
        }
        logger.debug("node: {}, min: {}, max: {}, exit: {}", root.getData(), minMax.get("min"), minMax.get("max"), minMax.get("isBinary"));
      }  
      return minMax;
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
  
  public boolean isBalanced() {
    return isBalanced(root);
  }
  
  public boolean isBalanced(TreeNode n) {
    if(root == null)
      return true;
    if (Math.abs(_maxDepth(root.getLeft()) - _maxDepth(root.getRight())) > 1)
      return false;
    else
      return isBalanced(root.getLeft()) && isBalanced(root.getRight());
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
