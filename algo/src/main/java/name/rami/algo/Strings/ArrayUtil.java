/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.rami.algo.Strings;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 *
 * @author rami <rami.developer@gmail.com>
 */
public class ArrayUtil {
  private static final Logger logger = LoggerFactory.getLogger(ArrayUtil.class);
  
  public static void printGrid (int[][]a) {
    for(int i = 0; i < a.length; i++) {
      for(int j = 0; j < a[i].length; j++)
         System.out.printf("%5d ", a[i][j]);
      System.out.println();
    }
  }
  
  public static void rotate(int[][] cube) {
    rotate2(cube);
  }
  
  public static void rotate1(int[][] cube) {
    int N = cube.length;
    System.out.println("rotate1: " + N);
    int[] tmp = new int[N-1];
    int n = N-1;
    for (int i=0; i<N/2; i++) {
      //logger.debug("Main Loop: " + i);
      n = N-1-i;
      System.arraycopy(cube[i], i, tmp, i, n - i);
      tmp = replace(cube, tmp, n, i, n, true);
      tmp = replace(cube, tmp, n, i+1, n, false);
      tmp = replace(cube, tmp, i, i+1, n, true);
      tmp = replace(cube, tmp, i, i, n, false);
    }
  }
  
  private static int[] replace(int[][] cube, int[] insert, int index, int start, int length, boolean vertical) {
    int[] tmp = new int[length];
    //logger.debug("index: " + index + ", start: " + start + ", length: " + length + ", " + (vertical? "vertical": "horizontal") + ", insert: " + Arrays.toString(insert));
    if(vertical) {
      for(int i=start, j=0; i<start+length; i++, j++) {
        tmp[length-j-1] = cube[i][index];
        cube[i][index] = insert[j];
      }
    } else {
      for(int i=start, j=0; i<start+length; i++, j++) {
        tmp[j] = cube[index][i];
        cube[index][i] = insert[j];
      }
    }
    return tmp;
  }
  
  public static void rotate2(int[][] cube) {
    int N = cube.length;
    logger.debug("rotate2: " + N);
    for (int layer=0; layer<N/2; layer++) {
      int first = layer;
      int last = N - 1 - layer;
      for (int i=first; i<last; i++) {
        int offset = i - first;
        int top = cube[first][i]; // save top
        cube[first][i] = cube[last-offset][first]; //left to top
        cube[last-offset][first] = cube[last][last-offset]; // bottom to left
        cube[last][last-offset] = cube[i][last]; // right to bottom
        cube[i][last] = top; // top to right
      }
    }
  }
}