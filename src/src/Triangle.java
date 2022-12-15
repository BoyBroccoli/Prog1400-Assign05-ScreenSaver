import java.awt.*;
import java.awt.geom.GeneralPath;

public class Triangle extends Shape{

    public Color color = Color.GREEN;

    public Triangle(Color color, int height, int width, int xPosition, int yPosition) {
        super(color, height, width, xPosition, yPosition);
    }

    public Triangle() {
    }

    @Override
    public void drawShape(Graphics g){

        // need an array of xPoints and yPoints
        int xPoints[] = {40,70,0};
        int yPoints[] = {0,70,70};






        Graphics2D g2d = (Graphics2D) g;
        GeneralPath triangle = new GeneralPath();

        triangle.moveTo(xPoints[0] + getxPosition(), yPoints[0] + getyPosition());
        for (int i = 0; i< xPoints.length; i++){
            triangle.lineTo(xPoints[i] + getxPosition(), yPoints[i] + getyPosition());
        }

        triangle.closePath();

        // Draw Shape Body

        //Get the main car color from parent
        Color mainColor = this.getShapeColor();

        g2d.setColor(mainColor);
        g2d.fill(triangle);



    }
}
