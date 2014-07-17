/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.rami.algo.Tree;

import static junit.framework.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
//import org.junit.Test;

/**
 *
 * @author rami <rami.developer@gmail.com>
 */
public class BinaryTreeTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BinaryTreeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BinaryTreeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        BinaryTree btree = new BinaryTree<Integer>();
        btree.insert(new Integer(10));
        btree.insert(new Integer(1));
        btree.insert(new Integer(15));
        btree.insert(new Integer(5));
        btree.insert(new Integer(25));
        btree.insert(new Integer(50));
        btree.insert(new Integer(-5));
        btree.print(BinaryTree.Order.IN);
        assertTrue( true );
    }
}

