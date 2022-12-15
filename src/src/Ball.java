import java.awt.*;

public class Ball extends Shape{

    private Color color;
    private int height;
    private int width;


    private int xPosition;
    private int yPosition;
    private int xSpeed = 2;
    private int ySpeed = 2;

    public Ball(Color color, int height, int width, int xPosition, int yPosition){

        super(color, height, width, xPosition, yPosition);
    }
    public Ball(){}
}
