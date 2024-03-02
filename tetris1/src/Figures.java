import java.util.Arrays;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Figures {

    private int type;
    private int orientation;
    private int[] numbers;
    private String[] pattern;

    private static final Integer[] NUMBERS_WITHIN_BLOCKS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private static final int[][] O_COORDINATES = {{0, 0, 0, 1, 1, 0, 1, 1}};
    private static final int[][] I_COORDINATES = {{0, 0, 0, 1, 0, 2, 0, 3}, {0, 0, 1, 0, 2, 0, 3, 0}};
    private static final int[][] Z_COORDINATES = {{0, 0, 0, 1, 1, 1, 1, 2}, {0, 1, 1, 0, 1, 1, 2, 0}};
    private static final int[][] S_COORDINATES = {{0, 1, 0, 2, 1, 0, 1, 1}, {1, 1, 2, 1, 0, 0, 1, 0}};
    private static final int[][] J_COORDINATES = {{0, 0, 1, 0, 1, 1, 1, 2}, {0, 1, 0, 0, 1, 0, 2, 0}, {1, 2, 0, 2, 0, 1, 0, 0}, {2, 0, 2, 1, 1, 1, 0, 1}};
    private static final int[][] L_COORDINATES = {{0, 2, 1, 0, 1, 1, 1, 2}, {2, 1, 0, 0, 1, 0, 2, 0}, {1, 0, 0, 2, 0, 1, 0, 0}, {0, 0, 2, 1, 1, 1, 0, 1}};
    private static final int[][] T_COORDINATES = {{0, 0, 0, 1, 0, 2, 1, 1}, {0, 1, 1, 1, 2, 1, 1, 0}, {1, 2, 1, 1, 1, 0, 0, 1}, {2, 0, 1, 0, 0, 0, 1, 1}};
    private static final int[][][] ALL_BLOCKS_COORDINATES = {O_COORDINATES, I_COORDINATES, Z_COORDINATES, S_COORDINATES, J_COORDINATES, L_COORDINATES, T_COORDINATES};

    private Figures() {
    }


    public static Figures create() {

        Figures t = new Figures();

        Random r = new Random();
        t.type = r.nextInt(7);
        t.numbers = new int[4];
        t.pattern = new String[2];

        Collections.shuffle(Arrays.asList(NUMBERS_WITHIN_BLOCKS));
        for (int i = 0; i < 4; i++) {
            t.numbers[i] = NUMBERS_WITHIN_BLOCKS[i];
        }

        switch (t.type) {
            case 0:
                // type O
                t.pattern[0] = String.format(" %d %d  ", t.numbers[0], t.numbers[1]);
                t.pattern[1] = String.format(" %d %d  ", t.numbers[2], t.numbers[3]);
                break;
            case 1:
                // type I
                t.pattern[0] = "          ";
                t.pattern[1] = String.format(" %d %d %d %d  ", t.numbers[0], t.numbers[1], t.numbers[2], t.numbers[3]);
                break;
            case 2:
                // type Z
                t.pattern[0] = String.format(" %d %d    ", t.numbers[0], t.numbers[1]);
                t.pattern[1] = String.format("   %d %d  ", t.numbers[2], t.numbers[3]);
                break;
            case 3:
                // type S
                t.pattern[0] = String.format("   %d %d  ", t.numbers[0], t.numbers[1]);
                t.pattern[1] = String.format(" %d %d    ", t.numbers[2], t.numbers[3]);
                break;
            case 4:
                // type J
                t.pattern[0] = String.format(" %d      ", t.numbers[0]);
                t.pattern[1] = String.format(" %d %d %d  ", t.numbers[1], t.numbers[2], t.numbers[3]);
                break;
            case 5:
                // type L
                t.pattern[0] = String.format("     %d  ", t.numbers[0]);
                t.pattern[1] = String.format(" %d %d %d  ", t.numbers[1], t.numbers[2], t.numbers[3]);
                break;
            case 6:
                // type T
                t.pattern[0] = String.format(" %d %d %d  ", t.numbers[0], t.numbers[1], t.numbers[2]);
                t.pattern[1] = String.format("   %d    ", t.numbers[3]);
                break;
        }

        return t;
    }

    public void rotate() {
        orientation++;
    }

    public void unrotate() {
        orientation--;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public String[] getPattern() {
        return pattern;
    }

    public int[] getCoordinates() {
        int[][] coordinates = ALL_BLOCKS_COORDINATES[type];
        return coordinates[orientation % coordinates.length];
    }

}