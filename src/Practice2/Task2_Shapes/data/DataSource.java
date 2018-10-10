package Practice2.Task2_Shapes.data;

import Practice2.Task2_Shapes.model.entity.Circle;
import Practice2.Task2_Shapes.model.entity.Rectangle;
import Practice2.Task2_Shapes.model.entity.Shape;
import Practice2.Task2_Shapes.model.entity.Triangle;

public class DataSource {

    public static Shape[] getShapes() {
        return new Shape[]{
                new Circle("Red", 3),
                new Rectangle("Red", 6, 2),
                new Triangle("Yellow", 5, 1),
                new Circle("Green", 5),
                new Rectangle("Black", 3, 2),
                new Triangle("Green", 4, 2),
                new Triangle("Green", 4, 2),
                new Circle("Green", 4),
                new Rectangle("Yellow", 5, 1),
                new Circle("Yellow", 2),
                new Triangle("Red", 6, 2),
        };

    }

}
