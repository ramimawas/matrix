/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.string;

import java.util.Random;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 *
 */
public class RandomString {

  private static final Logger logger = LoggerFactory.getLogger(RandomString.class);
  private static char[] symbols;

  static {
    StringBuilder tmp = new StringBuilder();
    for (char ch = '0'; ch <= '9'; ++ch)
      tmp.append(ch);
    for (char ch = 'a'; ch <= 'z'; ++ch)
      tmp.append(ch);
    symbols = tmp.toString().toCharArray();
  }   

  private final Random random = new Random();

  private final char[] buf;

  public RandomString(int length) {
    if (length < 1)
      throw new IllegalArgumentException("length < 1: " + length);
    buf = new char[length];
  }

  public String nextString() {
    for (int idx = 0; idx < buf.length; ++idx) 
      buf[idx] = symbols[random.nextInt(symbols.length)];
    return new String(buf);
  }
}