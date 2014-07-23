/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.util;

import java.util.Arrays;
import static junit.framework.Assert.assertTrue;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 */
public class BitUtilTest {
  private static final Logger logger = LoggerFactory.getLogger(BitUtilTest.class);
  
  public BitUtilTest() {}

  @BeforeClass
  public static void setUpClass() throws Exception {
    logger.info("setUpClass");
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
    logger.info("Tearing down");
  }

  @Test
  public void testDecToBin() {
    assertTrue(BitUtil.decToBin(0).equals("0"));
    assertTrue(BitUtil.decToBin(10).equals("1010"));
    assertTrue(BitUtil.decToBin(0.25).equals("0.01"));
    assertTrue(BitUtil.decToBin(5.5).equals("101.1"));
    assertTrue(BitUtil.decToBin(100.75).equals("1100100.11"));
  }
  
  @Test
  public void testIntToArray() {
    assertTrue(Arrays.equals(BitUtil.intToArray(39), new int[]{3, 9}));
  }
}