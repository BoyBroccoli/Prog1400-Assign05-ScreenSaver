import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Shape extends Rectangle {
    private Color shapeColor;
    private int height;
    private int width;

    private int xPosition;
    private int yPosition;
    private int xSpeed = 2;
    private int ySpeed = 2;

    public boolean collision = false;

    public Shape(Color color, int height, int width, int xPosition, int yPosition){
        this.shapeColor=color;
        this.height=height;
        this.width=width;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
    }

    public Shape(){}
    // Getters

    public Rectangle getBounds(){
        return new Rectangle(xPosition,yPosition,width,height);
    }

    public Color getShapeColor() {
        return shapeColor;
    }

    public int getShapeHeight() {
        return height;
    }

    public int getShapeWidth() {
        return width;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }


    // Setters
    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setShapeWidth(int width) {
        this.width = width;
    }

    public void setShapeHeight(int height) {
        this.height = height;
    }

    public void setShapeColor(Color color) {
        this.shapeColor = color;
    }


    // Methods

    public void drawShape(Graphics g){

        //Get the main car color from parent
        Color mainColor = this.getShapeColor();

        // Draw Shape Body
        g.setColor(mainColor);
        g.fillOval(this.xPosition,this.getyPosition(),this.getShapeWidth(),this.getShapeHeight());


    }

    public void moveShape(){

        // To move Shape, add "speed" to current x and y positions

        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }

    public void flipDirection(){
        xSpeed *= -1;
        ySpeed *= -1;
    }

//    public void addShapes(MouseEvent e, Graphics g){
//
//        int mouseX = e.getX();
//        int mouseY = e.getY();
//
//        if(mouseX > 0 || mouseY > 0){
//            drawShape(g);
//        }
//    }

}
