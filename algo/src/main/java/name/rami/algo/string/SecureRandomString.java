/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.string;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 *
 */
public final class SecureRandomString {
  private static final Logger logger = LoggerFactory.getLogger(SecureRandomString.class);
  private final SecureRandom random = new SecureRandom();
  private final int length;

  public SecureRandomString() {
    this(26);
  }
  
  public SecureRandomString(int length) {
    if (length < 1)
      throw new IllegalArgumentException("length < 1: " + length);
    this.length = length;
  }
  
  public String nextString() {
    return new BigInteger(length*5, random).toString(32);
  }
}
