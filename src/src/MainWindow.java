import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 600);
        this.setTitle("Java OOP Screensaver");
        //Make our own JPanel
        DrawingPanel drawing = new DrawingPanel();
        drawing.setBackground(Color.DARK_GRAY);

        this.add(drawing );
        drawing.setLayout(null);
    }

}
