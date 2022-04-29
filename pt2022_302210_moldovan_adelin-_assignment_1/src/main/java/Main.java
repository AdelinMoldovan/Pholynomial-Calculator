import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new View("Calculator operații cu polinoame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}