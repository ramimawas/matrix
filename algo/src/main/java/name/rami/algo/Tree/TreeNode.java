/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.rami.algo.Tree;

/**
 *
 * @author rami
 */
public class TreeNode<T extends Comparable<T> >{
    private T data;
    private TreeNode right;
    private TreeNode left;
    private int entryIndex;
    
    public TreeNode() {
        this.data = null;
        this.right = null;
        this.left = null;
        this.entryIndex = -1;
    }
    
    public TreeNode(T data) {
        this(data, null, null, -1);
    }

    public TreeNode(T data, TreeNode right, TreeNode left, int entryIndex) {
        this.data = data;
        this.right = right;
        this.left = left;
        this.entryIndex = entryIndex;
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
}

