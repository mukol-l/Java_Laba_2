package laboratory2;

import org.junit.Test;
import static org.junit.Assert.*;

public class EvenIndexProcessorTest {
    
    public static final double EPS = 1e-6;

    @Test
    public void testNormal() {
        int[] array = {5, 10, 7, 22, 9}; // Парні: 10 (інд 1), 22 (інд 3). (1+3)/2 = 2.0
        double expResult = 2.0;
        double result = EvenIndexProcessor.calcAverageEvenIndices(array);
        assertEquals(expResult, result, EPS);
    }

    @Test
    public void testNoEven() {
        int[] array = {1, 3, 5, 7}; // Парних немає
        double expResult = Double.NaN;
        double result = EvenIndexProcessor.calcAverageEvenIndices(array);
        assertEquals(expResult, result, EPS);
    }

    @Test
    public void testEmpty() {
        int[] array = {}; // Порожній масив
        double expResult = Double.NaN;
        double result = EvenIndexProcessor.calcAverageEvenIndices(array);
        assertEquals(expResult, result, EPS);
    }
}
