/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.rami.algo.Tree;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 *
 * @author rami
 */
public class TreeNode<T extends Comparable<T> >{
  private static final Logger logger = LoggerFactory.getLogger(BinaryTree.class);
  private T data;
  private TreeNode right;
  private TreeNode left;
  private int index;

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
    this.index = index;
  }

  public void print() {
    logger.info("data: " + data);
    logger.info("index: " + index);
  }
  /*public void comparareTo2(TreeNode nodeToCompare) {
      this.data.compareTo(nodeToCompare.getData());
  }*/
  //insertUnder.getData().compareTo(toInsert);

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
    return this.right = right;
  }

  public TreeNode setLeft(TreeNode left) {
    return this.left = left;
  }

  public int getIndex() {
      return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
}

