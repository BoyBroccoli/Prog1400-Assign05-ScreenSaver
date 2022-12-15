import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawingPanel extends JPanel{

    //Set to fire every 1/10th of a second, since the delay parameter is in milliseconds
    private Timer timer = new Timer(10,  new TimerAction());

    //Array to hold Shape objects
    public ArrayList<Shape> shapes;

    boolean screenClicked;

    //Constructor
    public DrawingPanel() {


        //Instantiate our array list
        shapes = new ArrayList<Shape>();


        //Create some Cars and add to array
        Shape shape1 = new Ball(Color.GREEN, 50, 50, 100, 80);
        Shape shape2 = new Triangle( Color.CYAN, 75, 50, 10, 300);
        Shape shape3 = new Square(Color.YELLOW, 90, 50, 300, 120);
        Shape shape4 = new Star(Color.PINK, 35, 15, 400, 200);
        Shape shape5 = new Ball(Color.ORANGE, 50,50,50,50);

        shapes.add(shape1);
        shapes.add(shape2);
        shapes.add(shape3);
        shapes.add(shape4);
        shapes.add(shape5);

        // Code to add a mouselistener, to capture mouse-related events
        // Uses a class called MouseAdapter, which simplifies accessing Mouse properties & events.
        // NOTE: The MouseEvent parameter (e) contains all mouse-related properties. Use intellisense to check
        // what it has available.
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //When mouse is clicked on panel, call our start/stop timer method
                startOrStopMoving(e);


                Shape shape = new Star(Color.PINK, 35, 15, 400, 200);
                Shape shape10 = new Ball(Color.GREEN, 50, 50, 100, 80);
                Shape shape11 = new Square(Color.YELLOW, 90, 50, 300, 120);
                Shape shape12 = new Star(Color.PINK, 35, 15, 400, 200);
                shapes.add(shape);
                shapes.add(shape10);
                shapes.add(shape11);
                shapes.add(shape12);


            }


        });




    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);	//Tell the parent JPanel to repaint ie redraw
        //Avoids a couple of potential issues

        //Draw each vehicle from the array on panel
        for (Shape s: shapes) {
            s.drawShape(g);
        }


    }

    //Method to start or stop the timer - in effect, stopping the cars' movements
    private void startOrStopMoving(MouseEvent e) {
        //Example of using MouseEvent e to get data about the mouse's current state.
        //JOptionPane.showMessageDialog(null, "Mouse location: " + e.getX() + ", " + e.getY());

        if (timer.isRunning()) {
            timer.stop();
            //JOptionPane.showMessageDialog(null, "Mouse location: " + e.getX() + ", " + e.getY());

        } else {
            //JOptionPane.showMessageDialog(null, "Mouse location: " + e.getX() + ", " + e.getY());

            timer.start();
        }
    }

    public void moveEverything() {
        //Call the "move me" method for each car in the array
        for (Shape s: shapes) {
            s.moveShape();
            //After moving, check each car to see if it hit a wall
            checkForWallHit(s);
            // checkForshapeCollision();

        }



        //After the move, tell the panel to repaint (which re-calls
        //the paintComponent() method)
        this.repaint();
    }




    public void checkForWallHit(Shape currentShape) {
        //What if it hits the edge of window?
        //Compare current position of car to current panel width (ie. the "furthest right" x position of window
        //Note that we add the Shapes width to get the Shapes right edge.
        if ((currentShape.getxPosition() + currentShape.getShapeWidth()) >= this.getWidth()) {
            //Multiply by -1 to reverse the direction
            currentShape.setxSpeed(currentShape.getxSpeed() * -1);
        }

        else if (currentShape.getxPosition() < 0 ) {	//if Shape hits the left edge (x position 0)
            //Multiply by -1 to reverse the direction
            currentShape.setxSpeed(currentShape.getxSpeed() * -1);
        }

        if ((currentShape.getyPosition() + currentShape.getShapeHeight()) >= this.getHeight()) {
            //Multiply by -1 to reverse the direction
            currentShape.setySpeed(currentShape.getySpeed() * -1);
        }
        else if (currentShape.getyPosition() < 50 ) {	//if the Shape hits the left edge (x position 0)
            //Multiply by -1 to reverse the direction
            currentShape.setySpeed(currentShape.getySpeed() * -1);
        }
    }

    public void checkCollision(Shape b1, Shape b2){
        if ((b1.getxPosition() + b1.getShapeWidth()) >= b2.getxPosition() + b2.getShapeWidth()) {
            //Multiply by -1 to reverse the direction
            b1.setxSpeed(b1.getxSpeed() * -1);
            b2.setxSpeed(b2.getxSpeed() * -1);
        }

        if ((b1.getyPosition() + b1.getShapeHeight()) >= b2.getyPosition() + b2.getShapeWidth()) {
            //Multiply by -1 to reverse the direction
            b1.setySpeed(b1.getySpeed() * -1);
            b2.setySpeed(b2.getySpeed() * -1);
        }
    }

    private class TimerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Whenever the timer fires a tick event, this method is called, which in turn calls our "drive" method.
            moveEverything();
        }
    }
}
