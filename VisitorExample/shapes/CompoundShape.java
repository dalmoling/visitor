package shapes;
import visitor.Visitor;
import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements Shape {
    private int id;
    private List<Shape> children = new ArrayList<>();

    public CompoundShape() {}

    public CompoundShape(int id) {
        this.id = id;
    }

    public void add(Shape shape) {
        children.add(shape);
    }

    public void remove(Shape shape) {
        children.remove(shape);
    }

    public int getId() { return id; }

    public List<Shape> getChildren() {
        return children;
    }

    @Override
    public void move(int x, int y) {
        for (Shape child : children) {
            child.move(x, y);
        }
    }

    @Override
    public void draw() {
        for (Shape child : children) {
            child.draw();
        }
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundShape(this);
    }
}
