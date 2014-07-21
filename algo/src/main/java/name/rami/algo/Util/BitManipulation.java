/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.Util;

/**
 * @author REM <rami.developer@gmail.com>
 */
public class BitManipulation {
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
}
