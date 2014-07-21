/*
 * MIT Licensed
 * Copyright 2014 REM <rami.developer@gmail.com>.
 */

package name.rami.algo.string;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 *
 */
public class StringUtil {
  private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
  
  /**
  * Reallocates an array with a new size, and copies the contents
  * of the old array to the new array.
  * @param oldArray  the old array, to be reallocated.
  * @param newSize   the new array size.
  * @return          A new array with the same contents.
  */
  public static Object resizeArray(Object oldArray, int newSize) {
    int oldSize = Array.getLength(oldArray);
    Class classType = oldArray.getClass().getComponentType();
    Object newArray = Array.newInstance(classType, newSize);
    int preserveLength = Math.min(oldSize, newSize);
    System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
    return newArray;
  }
  /**
   * Question
   * --------
   * Implement an algorithm to determine if a string has all unique characters. 
   * What if you can't use additional data structures?
   * 
   * Follow Up
   * ---------
   * Is the string ASCII or Unicode?
   * ASCII assigns values only to 128 characters
   * (a-z, A-Z, 0-9, space, some punctuation, and some control characters).
   * 
   * @param s
   * @return boolean
   */
  
  public static boolean isAllUniqueChars(String s) {
    return isAllUniqueChars3(s);
  }
  public static boolean isAllUniqueChars1(String s) {
    logger.info("isAllUniqueChars1: " + s);
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i=0; i<s.length(); i++)
      if (set.contains((int)s.charAt(i)))
        return false;
      else
        set.add((int)s.charAt(i));
    return true;
  }
  
  public static boolean isAllUniqueChars2 (String s) {
    logger.info("isAllUniqueChars2: " + s);
    if (s.length() > 128 ) return false;
    boolean[] chars = new boolean[128];
    for (int i=0; i<s.length(); i++) {
      int val = s.charAt(i);
      if (chars[val] == true)
        return false;
      chars[val] = true;
    }
    return true;
  }
  
  // no structure
  public static boolean isAllUniqueChars3 (String s) {
    logger.info("isAllUniqueChars3: " + s);
    int bitMap = 0;
    for (int i=0; i<s.length(); i++) {
      int val = s.charAt(i) - 'a';
      if((bitMap & 1<<val) == 1)
        return false;
      else
        bitMap |= 1<<val;
    }
    return true;
  }
  
  public static String sort(String s) {
    char [] cs = s.toCharArray();
    Arrays.sort(cs);
    return new String(cs);
  }
  
  public static boolean isPermuted(String s1, String s2) {
    return isPermuted2(s1, s2);
  }
  
  public static boolean isPermuted1(String s1, String s2) {
    logger.info("isPermuted1: " + s1 + ", " + s2);
    if(s1 == null || s2 == null)
      return false;
    if(s1.length() != s2.length())
      return false;
    return sort(s1).equals(sort(s2));
    
  }
  
  public static boolean isPermuted2(String s1, String s2) {
    logger.info("isPermuted2: " + s1 + ", " + s2);
    if(s1 == null || s2 == null)
      return false;
    if(s1.length() != s2.length())
      return false;
    char[] count = new char[256]; // ascuii assumption
    char[]cs1 = s1.toCharArray();
    char[]cs2 = s2.toCharArray();
    for(char c : cs1)
      count[c]++;
    for(char c : cs2)
      if(--count[c] <0)
        return false;
    return true;
  }
  
  public static void replaceSpaces(char[]s, int length) {
    try {
      logger.info("replaceSpaces: " + new String(s) + ", " + length);
      int pointer  = s.length-1;
      boolean strStarted = false;
      boolean spaceDetected = false;
      for(int i = pointer; i>=0; i--) {
        char c = s[i];
        if (c != ' ') {
          if (spaceDetected) {
            s[pointer--] = '0';
            s[pointer--] = '2';
            s[pointer--] = '%';
          }
          s[pointer--] = c;
          spaceDetected = false;
          strStarted = true;
        } else if (c == ' ' && strStarted) {
          spaceDetected = true;
        }
      }

      if(pointer >= 0) {
        pointer++;  // go to begining of the fixed string
        System.arraycopy(s, pointer, s, 0, s.length-pointer);
        s[s.length-pointer] = '\0';
      }
    } catch (IndexOutOfBoundsException e) {
      logger.debug("Input char[] is too small or does not have enough spaces at the end.");
    }
  }
  
  public static String compress(String s) {
    logger.info("compress: " + s + ", " + s.length());
    String cs = s;
    StringBuilder sb = new StringBuilder();
    if (s!=null && !s.isEmpty()) {
      char last = s.charAt(0);
      int count = 0;
      for(int i =1; i<s.length(); i++) {
        if (s.charAt(i)==last) {
          count++;
        } else {
          sb.append(last).append(count);
          last = s.charAt(i);
          count = 1;
        }
      }
      sb.append(last).append(count);
      if (sb.length()<s.length())
        cs = sb.toString();
    }
    logger.info("compressed: <" + cs + ">");
    return cs;
  }
  
  public static boolean isRotation(String s1, String s2) {
    logger.debug("isRotation: s1<{}>, s2<{}>", s1, s2);
    return (s1 == null || s2 == null || s1.length() != s2.length()) ? false : s1.concat(s1).contains(s2);
  }
}
