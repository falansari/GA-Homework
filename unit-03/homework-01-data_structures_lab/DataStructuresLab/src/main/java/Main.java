import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Task 1: Rotate an array
        ArrayRotation arrayRotation = new ArrayRotation();
        int[] array = {1, 2, 3, 4, 5};
        int[] rotatedArray = arrayRotation.rotate(array, 3);

        System.out.println(Arrays.toString(rotatedArray));
    }
}
