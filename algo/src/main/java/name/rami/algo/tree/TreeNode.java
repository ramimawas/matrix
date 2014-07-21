/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.tree;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @param <T>
 */
public class TreeNode<T extends Comparable<T> >{
  private static final Logger logger = LoggerFactory.getLogger(BinaryTree.class);
  private T data;
  private TreeNode right;
  private TreeNode left;
  private int index;
  private final List<TreeNode> adjacents = new ArrayList<TreeNode>();
  
  public TreeNode() {
    this.data = null;
    this.right = null;
    this.left = null;
    this.index = -1;
  }

  public TreeNode(T data) {
    this(data, null, null, -1);
  }

  public TreeNode(T data, int index) {
    this(data, null, null, index);
  }

  public TreeNode(T data, TreeNode right, TreeNode left, int index) {
    this.data = data;
    this.right = right;
    this.left = left;
    addAdjacent(right).addAdjacent(left);
    this.index = index;
  }
  
  private TreeNode addAdjacent(TreeNode child) {
    if(child != null)
      adjacents.add(child);
    return this;
  }

  public void print() {
    logger.info("data: " + data);
    logger.info("index: " + index);
  }
  
  @Override
  public String toString() {
    return "index: " + index + ", data: " + data.toString();
  }
  
  public T getData() {
    return data;
  }

  public TreeNode getRight() {
    return right;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setData(T data) {
    this.data = data;
  }

  public TreeNode setRight(TreeNode right) {
    adjacents.remove(this.right);
    addAdjacent(right);
    return this.right = right;
  }

  public TreeNode setLeft(TreeNode left) {
    adjacents.remove(this.left);
    addAdjacent(left);
    return this.left = left;
  }

  public int getIndex() {
      return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public List<TreeNode> getAdjacents() {
    return adjacents;
  }
}

