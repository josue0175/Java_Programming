public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
    }
    public Shape(String color, boolean filled) {
    }

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color; 
    }
    //All abstract defined classes must be implemented in subclass
    //public boolean isFilled() { }
    //public void setFilled(boolean filled);
    abstract public double getArea();
    //abstract public double getPerimeter();
    abstract public String toString();
}
