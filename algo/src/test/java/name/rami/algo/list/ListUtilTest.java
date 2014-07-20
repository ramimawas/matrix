/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.rami.algo.list;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rami <rami.developer@gmail.com>
 */
public class ListUtilTest {
  private static final Logger logger = LoggerFactory.getLogger(ListUtilTest.class);
  
    public ListUtilTest() {}
    
    @BeforeClass
    public static void setUpClass() throws Exception {
      logger.info("setUpClass");
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
      logger.info("Tearing down");
    }
    
    @Test
    public void testCreate() {
      Integer[] data = {9, 4, 3, 1, 11, 2, 8, 12, 7, 5, 6, 10};
      LinkedList list = new LinkedList(data);
      list.printDetails();
      list.remove(9);
      list.printDetails();
      list.append(13);
      list.printDetails();
      list.insertBefore(14, 11);
      list.printDetails();
      list.insertAfter(15, 14);
      list.printDetails();
      list.insertAfter(16, 13);
      list.printDetails();
      list.insertBefore(0, 4);
      list.printDetails();
    }
    
    @Test
    public void testPartition() {
      //Integer[] data = {9, 4, 3, 1, 11, 2, 8, 12, 7, 5, 6, 10};
      //Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      Integer[] data = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      LinkedList list = new LinkedList(data);
      list.printDetails();
      list.partition(5);
      list.printDetails();
    }
}