package visitor;
import shapes.*;

public class XMLExportVisitor implements Visitor {

    public String export(Shape... shapes) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");

        for (Shape shape : shapes) {
            sb.append(shape.accept(this)).append("\n");
        }

        return sb.toString();
    }

    @Override
    public String visitDot(Dot dot) {
        return String.format("<dot>\n  <id>%d</id>\n  <x>%d</x>\n  <y>%d</y>\n</dot>",
                dot.getId(), dot.getX(), dot.getY());
    }

    @Override
    public String visitCircle(Circle circle) {
        return String.format("<circle>\n  <id>%d</id>\n  <x>%d</x>\n  <y>%d</y>\n  <radius>%d</radius>\n</circle>",
                circle.getId(), circle.getX(), circle.getY(), circle.getRadius());
    }

    @Override
    public String visitRectangle(Rectangle rectangle) {
        return String.format("<rectangle>\n  <id>%d</id>\n  <x>%d</x>\n  <y>%d</y>\n  <width>%d</width>\n  <height>%d</height>\n</rectangle>",
                rectangle.getId(), rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    @Override
    public String visitCompoundShape(CompoundShape cs) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<compound_graphic>\n  <id>%d</id>\n", cs.getId()));
        for (Shape child : cs.getChildren()) {
            String childXml = child.accept(this).replace("\n", "\n  ");
            sb.append("  ").append(childXml).append("\n");
        }
        sb.append("</compound_graphic>");
        return sb.toString();
    }
}
