package laboratory2;

public class EvenIndexProcessor {
    public static double calcAverageEvenIndices(int[] array) {
        if (array == null || array.length == 0) {
            return Double.NaN; 
        }

        double sumOfIndices = 0;
        int countEven = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sumOfIndices += i;
                countEven++;
            }
        }

        if (countEven == 0) {
            return Double.NaN;
        }

        return sumOfIndices / countEven;
    }
}
