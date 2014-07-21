/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.list;
import java.util.HashMap;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
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

      @Test
  public void testNthToLast() {
    final Integer[] data = {9, 4, 3, 1, 11, 2, 8, 12, 7, 5, 6, 10};
    Map<Integer, Boolean> tests = new HashMap<Integer, Boolean>() {{
      put(1, true); // last
      put(data.length-3, true); // 5
      put(data.length, true); //1st
    }};
    LinkedList list = new LinkedList<Integer>(data);
    list.printDetails();
    for (Map.Entry test : tests.entrySet()) {
      Integer i = (Integer)test.getKey();
      Assert.assertEquals(data[data.length-i].equals(list.nthToLast1(i).getData()), (Boolean)test.getValue());
      Assert.assertEquals(data[data.length-i].equals(list.nthToLast2(i).getData()), (Boolean)test.getValue());
    }
  }
}