public class ArrayRotation {
    /**
     * Rotate the elements at the end of the array to the start of the array by number of rotations.
     * @param array int[]
     * @param rotateByNumber int
     * @return int[] rotated array
     */
    public int[] rotate(int[] array, int rotateByNumber) {
        int arrayLength = array.length;

        if (rotateByNumber > arrayLength) rotateByNumber = rotateByNumber % arrayLength;

        for (int i = 0; i < rotateByNumber; i++) {
            int startElement = array[arrayLength - 1 - i];
            int endElement = array[i];

            array[i] = startElement;
            array[arrayLength - 1 - i] = endElement;
        }

        return array;
    }
}
