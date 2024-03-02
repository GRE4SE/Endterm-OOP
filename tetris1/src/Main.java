import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Welcome to Tetris!!!\n"+"Press Enter to continue!");
        Scanner s = new Scanner(System.in);
        String input;
        do {
            input = s.nextLine();
        } while (!input.equals(""));

        Game game = new Game();
        setupWindowForKeyListener(game);
    }
    private static void setupWindowForKeyListener(KeyListener k) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setSize(100,100);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.addKeyListener(k);
    }
}