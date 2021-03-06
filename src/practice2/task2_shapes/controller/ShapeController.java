package practice2.task2_shapes.controller;

import practice2.task2_shapes.data.DataSource;
import practice2.task2_shapes.model.Shapes;
import practice2.task2_shapes.view.ShapeView;

import java.util.Scanner;

public class ShapeController {

    private Shapes model;
    private ShapeView view;

    public ShapeController(Shapes model, ShapeView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        model.setShapes(DataSource.getShapes());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.printMessage(
                    "Origin shape array                     -       press 1\n" +
                            "Sum of the areas                       -       press 2\n" +
                            "Sum of the areas a certain shape       -       press 3\n" +
                            "Sort shapes by area                    -       press 4\n" +
                            "Sort shapes by color                   -       press 5\n" +
                            "Exit                                   -       press 0\n"
            );
            view.printMessage(">>");
            if (scanner.hasNextInt()) {
                int valueInt = scanner.nextInt();
                switch (valueInt) {
                    case 1:
                        view.printShapes("All shapes:", model.getShapes());
                        continue;
                    case 2:
                        view.printResult(view.SUM_OF_THE_AREAS, model.sumOfTheAreas());
                        continue;
                    case 3:
                        scanner = new Scanner(System.in);
                        view.printMessage(">>");
                        String s = scanner.nextLine();
                        getSumOfTheAreasACertainShape(s);
                        continue;
                    case 4:
                        view.printShapesWithArea("Sort by area", model.getOrderedShapeByArea());
                        continue;
                    case 5:
                        view.printShapes("Sort by color", model.getOrderedShapeByColor());
                        continue;
                    case 0:
                        System.exit(0);
                    default:
                        view.printMessage(view.WRONG_INPUT_INT_DATA  + "\n");

                }
            } else {
                view.printMessage(view.WRONG_INPUT_INT_DATA + "\n");
                scanner.next();
            }
        }
    }

    private void getSumOfTheAreasACertainShape(String s) {
        double v = model.sumOfTheAreasACertainShape(s);
        if (v == 0) view.printMessage("No shapes\n\n");
        else view.printResult(view.SUM_OF_THE_AREAS_A_CERTAIN_SHAPE + " - " + s, v);
    }
    public static void main(String[] args) {
        new ShapeController(new Shapes(), new ShapeView()).run();
    }

}
