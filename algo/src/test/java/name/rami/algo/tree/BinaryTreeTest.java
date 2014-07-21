/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.tree;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import java.util.Random;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 */
public class BinaryTreeTest {
  private static final Logger logger = LoggerFactory.getLogger(BinaryTreeTest.class);
  public BinaryTreeTest() {}
  
  @BeforeClass
  public static void setUpClass() throws Exception {
    intTree.insert(intData);
    logger.info("setUpClass");
  }
    
  @AfterClass
  public static void tearDownClass() throws Exception {
    logger.info("Tearing down");
  }
  
  private static final Integer[] intData = {9, 4, 3, 1, 11, 2, 8, 12, 7, 5, 6, 10};
  private static final BinaryTree intTree = new BinaryTree<Integer>();
  
  @Test
  public void testInit() {
    logger.debug("testInit");
    logger.debug("Printing IN ORDER: {}", intTree.toString(BinaryTree.Order.IN));
    logger.debug("Printing PRE ORDER: {}", intTree.toString(BinaryTree.Order.PRE));
    logger.debug("Printing POST ORDER: {}", intTree.toString(BinaryTree.Order.POST));
    logger.debug("Printing Depth-First Search: {}", intTree.toString(BinaryTree.Order.DFS));
    logger.debug("Printing Breadth-First Search: {}", intTree.toString(BinaryTree.Order.BFS));

    logger.debug("Maximum Depth: {}", intTree.maxDepth());
    assertTrue(intTree.maxDepth() == 6);
    logger.debug("Size: {}", intTree.size());
    assertTrue(intTree.size() == intData.length);
  }
  
  //@Test
  public void testFind() {
    logger.debug("testFind");
    for(int i = 0; i<intData.length; i++) {
      Integer toFind = intData[i];
      TreeNode n = intTree.find(toFind);
      assertTrue(n != null);
      logger.info("{} was found: [{}]", toFind, n.toString());
      assertTrue(n.getData() == toFind);
      assertTrue(n.getIndex() == i);
    }
  }
  
  @Test
  public void testIsBalanced() {
    logger.debug("testIsBalanced");
    assertTrue(!intTree.isBalanced()); 
  }
  
  @Test
  public void testIsBinary() {
    logger.debug("testIsBinary");
    assertTrue(intTree.isBinary());
  }
}

