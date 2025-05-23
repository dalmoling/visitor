package visitor;
import shapes.*;

public interface Visitor {
    String visitDot(Dot dot);
    String visitCircle(Circle circle);
    String visitRectangle(Rectangle rectangle);
    String visitCompoundShape(CompoundShape cs);
}
