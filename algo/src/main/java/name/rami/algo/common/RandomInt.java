/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.common;

import java.util.Random;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 
 */
public class RandomInt {
  private static final Logger logger = LoggerFactory.getLogger(RandomInt.class);
  private final static Random random = new Random(System.currentTimeMillis());
  
  public static int nextInt(int min, int max) {
    return random.nextInt(max-min+1) + min;
  }
  
  public static int[] nextIntArray(int min, int max, int length) {
    logger.debug("nextIntArray: min {}, max {}, length {}", min, max, length);
    int[] a = new int [length];
    for (int i = 0; i<length; i++) 
      a[i] = nextInt(min, max);
    return a;
  }
}