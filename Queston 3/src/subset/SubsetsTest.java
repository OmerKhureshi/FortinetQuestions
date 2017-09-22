package subset;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubsetsTest {

    @Test
    public void testCheckSubset() {
        int k = 2; // Specify number of groups

        Subsets subsets = new Subsets();
        List<Integer> list = Arrays.asList(1,1,2,3,1);
        int sum = ((int) Math.floor(list.stream().mapToInt(Integer::valueOf).sum() / k));
        assertTrue(subsets.checkSubset(list, sum, list.size()));
    }
}
