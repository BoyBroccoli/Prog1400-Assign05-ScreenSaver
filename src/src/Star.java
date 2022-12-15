import java.awt.*;
import java.awt.geom.GeneralPath;

public class Star extends Shape{

    public Color color = Color.DARK_GRAY;

    public Star(Color color, int height, int width, int xPosition, int yPosition) {
        super(color, height, width, xPosition, yPosition);
    }

    public Star() {
    }

    @Override
    public void drawShape(Graphics g){

        // need an array of xPoints and yPoints
        int xPoints[] = {9,15,0,18,3};
        int yPoints[] = {0,18,6,6,18};

        Graphics2D g2d = (Graphics2D) g;
        GeneralPath star = new GeneralPath();

        star.moveTo(xPoints[0] + getxPosition(), yPoints[0] + getyPosition());
        for (int i = 0; i< xPoints.length; i++){
            star.lineTo(xPoints[i] + getxPosition(), yPoints[i] + getyPosition());
        }

        star.closePath();
        //Get the main car color from parent
        Color mainColor = this.getShapeColor();


        // Draw Shape Body
        g2d.setColor(mainColor);
        g2d.fill(star);


    }
}
