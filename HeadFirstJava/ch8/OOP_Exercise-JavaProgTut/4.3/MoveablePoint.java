public class MovablePoint implements Moveable {
    int x, y xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y -= ySpeed;   // y-axis pointing down for 2D graphics
    }
    @Override
    public void moveDown() {
        x -= xSpeed;   // x-axis pointing for 2D graphics
    }
    public void moveLeft() {
        x -= xSpeed;   // y-axis pointing down for 2D graphics
    }
    public void moveRight() {
        x -= xSpeed;   // y-axis pointing down for 2D graphics
    }
}
