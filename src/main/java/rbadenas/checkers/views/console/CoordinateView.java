package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.models.Coordinate;
import main.java.rbadenas.checkers.models.SquareNotation;
import main.java.rbadenas.checkers.types.Error;
import main.java.rbadenas.utils.Console;

public class CoordinateView {

    public Coordinate read(String title) {
        Coordinate coordinate;
        SquareNotation squareNotation;

        Error error;

        do {
            squareNotation = readSquareNotation(title);
            coordinate = new Coordinate(squareNotation);

            error = coordinate.isValid();
            new ErrorView(error).writeln();
        } while (!error.isNull());

        return coordinate;
    }

    private SquareNotation readSquareNotation(String title){

        SquareNotation squareNotation;

        Error error;
        do {
            String notation = Console.instance().readString(title + " Square: ");
            squareNotation = new SquareNotation(notation);

            error = squareNotation.isValid();
            new ErrorView(error).writeln();
        } while (!error.isNull());

        return squareNotation;
    }
}