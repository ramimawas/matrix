/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.rami.algo.string;

import name.rami.algo.string.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static junit.framework.Assert.assertTrue;
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
public class StringUtilTest {
  private static final Logger logger = LoggerFactory.getLogger(StringUtilTest.class);
  
    public StringUtilTest() {}
    
    @BeforeClass
    public static void setUpClass() throws Exception {
      logger.info("setUpClass");
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
      logger.info("Tearing down");
    }

    @Test
    public void testIsAllUniqueChars1() {
      assertTrue(StringUtil.isAllUniqueChars1("rami"));
      Assert.assertFalse(StringUtil.isAllUniqueChars1("sarah"));
    }
    
    @Test
    public void testIsAllUniqueChars2() {
      assertTrue(StringUtil.isAllUniqueChars2("rami"));
      Assert.assertFalse(StringUtil.isAllUniqueChars2("sarah"));
    }
    
    @Test
    public void testIsAllUniqueChars3() {
      assertTrue(StringUtil.isAllUniqueChars3("rami"));
      Assert.assertFalse(StringUtil.isAllUniqueChars3("sarah"));
    }
    
    @Test
    public void testIsPermuted1() {
      assertTrue(StringUtil.isPermuted1("rami", "imar"));
      Assert.assertFalse(StringUtil.isPermuted1("rami", "sarah"));
    }
    
    @Test
    public void testIsPermuted2() {
      assertTrue(StringUtil.isPermuted2("rami", "imar"));
      Assert.assertFalse(StringUtil.isPermuted2("rami", "sarah"));
    }
    
    @Test
    public void testReplaceSpaces() {
      Map<String, Boolean> testStrings = new HashMap<String, Boolean>() {{
        put(" Rami", true);
        put("Mr John  Smith    ", true);
        put("How are       you today   %20my lord   ", false);
      }};
      for (Map.Entry test : testStrings.entrySet()) {
        String s = (String)test.getKey();
        char[] cleanExpected = s.trim().replaceAll("\\s+", "%20").toCharArray();
        char[] clean = s.toCharArray();
        StringUtil.replaceSpaces(clean, cleanExpected.length);
        String strCleanExpected = new String(cleanExpected);
        String strClean = new String(clean);
        int end = strClean.indexOf('\0');
        if(end>=0)
          strClean = strClean.substring(0, end);
        //logger.info("original: <" + s + ">, " + s.length());
        //logger.info("cleanExpected: <" + new String(cleanExpected) + ">, " + strCleanExpected.length());
        //logger.info("clean: <" + strClean + ">, " + strClean.length());
        Assert.assertEquals(strCleanExpected.equals(strClean), test.getValue());
       }
    }
    
    @Test
    public void testCompress() {
      List<List> testStrings = new ArrayList<List>() {{
        add(new ArrayList() {{add("Rami"); add("Rami"); add(true);}});
        add(new ArrayList() {{add("aabccccaaa"); add("a2b1c4a3"); add(true);}});
        add(new ArrayList() {{add("foobar"); add("f1o2b1a1r1"); add(false);}});
        add(new ArrayList() {{add("foooooooooobar"); add("f1o10b1a1r1"); add(true);}});
      }};
      for (List test : testStrings) {
        try {
          Assert.assertEquals((Boolean)test.get(2), StringUtil.compress((String)test.get(0)).equals((String)test.get(1)));
        } catch (AssertionError e) {
          logger.error(e.getMessage());
          throw e;
        }
      }
    }
    
    @Test
    public void testIsRotation() {
      List<List> testStrings = new ArrayList<List>() {{
        add(new ArrayList() {{add("rami"); add("mira"); add(true);}});
        add(new ArrayList() {{add("rami"); add("imar"); add(false);}});
      }};
      for (List test : testStrings) {
        try {
          Assert.assertEquals((Boolean)test.get(2), StringUtil.isRotation((String)test.get(0), (String)test.get(1)));
        } catch (AssertionError e) {
          logger.error(e.getMessage());
          throw e;
        }
      }
    }
}

/*
public class StringUtilTest
    extends TestCase {

public StringUtilTest( String testName ) {
        super( testName );
        rand = new RandomString(10);
        randsec = new SecureRandomString(10);
    }

    public static Test suite() {
        return new TestSuite(StringUtilTest.class);
    }
*/