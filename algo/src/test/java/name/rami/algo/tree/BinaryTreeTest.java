/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.rami.algo.tree;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author rami <rami.developer@gmail.com>
 */
public class BinaryTreeTest {
  private static final Logger logger = LoggerFactory.getLogger(BinaryTreeTest.class);
  public BinaryTreeTest() {
  }
  
  @Test
  public void testApp() {
    BinaryTree btree = new BinaryTree<Integer>();
    int[] dataRaw = {9, 4, 3, 1, 11, 2, 8, 12, 7, 5, 6, 10};
    List<Integer> data = new ArrayList<Integer>();
    for(int i = 0; i<dataRaw.length; i++) data.add(dataRaw[i]);
    Random rand = new Random(9);
    btree.insert(data);

    logger.info("Printing IN ORDER: ");
    btree.print(BinaryTree.Order.IN);

    logger.info("Printing PRE ORDER: ");
    btree.print(BinaryTree.Order.PRE);

    logger.info("Printing POST ORDER: ");
    btree.print(BinaryTree.Order.POST);

    Integer i = new Integer(rand.nextInt(data.size()));
    Integer toFind = data.get(i);
    TreeNode n = btree.find(toFind);
    if(n != null) {
        logger.info(toFind + " was found:");
        n.print();
        assert(n.getData() == toFind);
        assert(n.getIndex() == data.indexOf(toFind));
    } else {
        logger.info(toFind + " was NOT found");
    }        
    logger.info("Maximum Depth: " + btree.maxDepth());
    logger.info("Size: " + btree.size());
    assertTrue(btree.size() == data.size());
  }
}

