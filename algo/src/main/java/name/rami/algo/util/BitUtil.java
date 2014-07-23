/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import name.rami.algo.array.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author REM <rami.developer@gmail.com>
 */
public class BitUtil {
  private static final Logger logger = LoggerFactory.getLogger(ArrayUtil.class);
  
  public static boolean getBit(int n, int i) {
    return (n & (1<<i)) != 0;
  }
  
  public static int setBit(int n, int i) {
    return n | (1<<i);
  }
  
  public static int clearBit(int n, int i) {
    return n & ~(1<<i);
  }
  
  // Clear bits up to i starting from most significant
  public static int clearBitsUpToMS(int n, int i) {
    return n & (1<<i)-1;
  }
  
  // Clear bits up to i starting from least significant
  public static int clearBitsUpToLS(int n, int i) {
    return n & ~(-1>>(31-i));
  }
  
  public static int updateBit(int n, int i, int v) {
    return (n & ~(1<<i)) | (v<<i);
  }
  
  public static int insertInto(int dest, int toInsert, int i, int j) {
    int ones = ~0;
    int mask = ones<<(j+1) | (1<<i) -1;
    return (dest & mask) | (toInsert<<i); 
  }
  
  public static String decToBin(double dec) {
    double frac = dec - Math.floor(dec);
    int integer = (int)(dec - frac);
    logger.debug("decToBin: {}, int: {}, frac: {}", dec, integer, frac);
    StringBuilder sb = new StringBuilder(intToBin(integer));
    if (frac != 0) {
      sb.append(".");
      while (frac >0) {
        if (sb.length() >= 128)
          break;
        frac *= 2;
        if(frac >= 1) {
          sb.append(1);
          frac--;
        } else
          sb.append(0);
      }
    }
    return sb.toString();
  }
  
  public static String intToBin(int integer) {
    logger.debug("intToBin: {}", integer);
    LinkedList<Integer> list = new LinkedList<Integer>();
    StringBuilder sb = new StringBuilder();
    if (integer == 0) {
       sb.append("0");
    } else {
      while(integer > 0) {
        list.addFirst(integer % 2);
        integer /= 2;
      }
      for (Integer i :list)
        sb.append(i);
    }
    return sb.toString();
  }
  
  public static int[] intToArray(int integer) {
    logger.debug("intToArray: {}", integer);
    LinkedList<Integer> list = new LinkedList<Integer>();
    while(integer > 0) {
      list.addFirst(integer % 10);
      integer /= 10;
    }
    int[] ints = new int[list.size()];
    Iterator<Integer> it = list.iterator();
    for (int i=0; it.hasNext(); i++)
      ints[i] = it.next();
    //logger.debug("ints: {}", Arrays.toString(ints));
    return ints;
  }
}
