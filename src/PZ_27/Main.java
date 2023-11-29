package PZ_27;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        Redactor red = new Redactor();
        red.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        red.setSize(1000, 700);
        red.setVisible(true);
    }
}
