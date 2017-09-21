package node;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NodeTest {

    @Test
    public void testReverse() {
        // Initialize a node list of 3 elements.
        Node headListOne, A, B, C, tailListOne, headListTwo;

        headListOne = new Node();
        A = headListOne;
        B = new Node();
        C = new Node();
        tailListOne = new Node();

        A.value = 1;
        B.value = 2;
        C.value = 3;
        tailListOne.value = 4;

        A.next = B;
        B.next = C;
        C.next = tailListOne;

        // Initialize a second node list off single element.
        headListTwo = new Node();
        headListTwo.value = 1;

        NodeDemo demo = new NodeDemo();

        // Check that method returns null for null parameter
        assertNull("Should be null", demo.reverse(null));

        // Check that method reverses a list of more than one node
        assertEquals(demo.reverse(headListOne), tailListOne);

        // Check that method reverses a list of single node
        assertEquals(demo.reverse(headListTwo), headListTwo);
    }

}
