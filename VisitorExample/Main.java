import shapes.*;
import visitor.XMLExportVisitor;

public class Main {
    public static void main(String[] args) {
        CompoundShape allShapes = new CompoundShape();
        allShapes.add(new Dot(1, 10, 55));
        allShapes.add(new Circle(2, 23, 15, 10));
        allShapes.add(new Rectangle(3, 10, 17, 20, 30));

        CompoundShape group = new CompoundShape();
        group.add(new Dot(4, 30, 40));
        group.add(new Circle(5, 25, 30, 20));
        allShapes.add(group);

        String exportado = new XMLExportVisitor().export(allShapes);
        System.out.println(exportado);
    }
}
