/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.rami.algo.array;
import name.rami.algo.array.ArrayUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rami <rami.developer@gmail.com>
 */
public class ArrayUtilTest {
  private static final Logger logger = LoggerFactory.getLogger(ArrayUtilTest.class);
  
    public ArrayUtilTest() {}
    
    @BeforeClass
    public static void setUpClass() throws Exception {
      logger.info("setUpClass");
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
      logger.info("Tearing down");
    }
    private static List<List> cubeTests;
    static {
        cubeTests = new ArrayList<List>() {{
        add(new ArrayList() {{add(new int[][] {{1, 2}, {3, 4}});
                              add(new int[][] {{3, 1}, {4, 2}});
                              add(true);}});
        add(new ArrayList() {{add(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
                              add(new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});
                              add(true);}});
        add(new ArrayList() {{add(new int[][] {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}); 
                              add(new int[][] {{7, 8, 1}, {6, 9, 2}, {5, 4, 3}});
                              add(true);}});
      }};
    }
    
    @Test
    public void testRotate1() {
      for(List test: cubeTests) {
        int[][] originalCube = (int[][])test.get(0);
        int[][] expectedCube = (int[][])test.get(1);
        Boolean expectedAssertion = (Boolean)test.get(2);
        System.out.println("Original Cube: ");
        ArrayUtil.printGrid(originalCube);
        ArrayUtil.rotate(originalCube);
        System.out.println("Rotated Cube: ");
        ArrayUtil.printGrid(originalCube);
        System.out.println("Expected Cube: ");
        ArrayUtil.printGrid(expectedCube);
        Assert.assertEquals(Arrays.deepEquals(originalCube, expectedCube), expectedAssertion);
        ArrayUtil.rotate(originalCube);
        ArrayUtil.rotate(originalCube);
        ArrayUtil.rotate(originalCube);
      }
    }
      
    @Test
    public void testRotate2() {
      for(List test: cubeTests) {
        int[][] originalCube = (int[][])test.get(0);
        int[][] expectedCube = (int[][])test.get(1);
        Boolean expectedAssertion = (Boolean)test.get(2);
        System.out.println("Original Cube: ");
        ArrayUtil.printGrid(originalCube);
        ArrayUtil.rotate2(originalCube);
        System.out.println("Rotated Cube: ");
        ArrayUtil.printGrid(originalCube);
        System.out.println("Expected Cube: ");
        ArrayUtil.printGrid(expectedCube);
        Assert.assertEquals(Arrays.deepEquals(originalCube, expectedCube), expectedAssertion);
        ArrayUtil.rotate2(originalCube);
        ArrayUtil.rotate2(originalCube);
        ArrayUtil.rotate2(originalCube);
      }
    }
}