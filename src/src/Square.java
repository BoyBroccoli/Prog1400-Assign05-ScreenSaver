import java.awt.*;

public class Square extends Shape{

    public Color color = Color.CYAN;

    public Square(Color color, int height, int width, int xPosition, int yPosition) {
        super(color, height, width, xPosition, yPosition);
    }

    public Square() {
    }


    @Override
    public void drawShape(Graphics g){

        //Get the main car color from parent
        Color mainColor = this.getShapeColor();

        // Draw Shape Body
        g.setColor(mainColor);
        g.fillRect(this.getxPosition(),this.getyPosition(),this.getShapeWidth(),this.getShapeHeight());


    }
}
