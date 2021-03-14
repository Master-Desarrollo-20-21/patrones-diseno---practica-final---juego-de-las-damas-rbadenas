package main.java.rbadenas.checkers.models;

import main.java.rbadenas.checkers.types.Error;
public class SquareNotation {
    
    private String notation;
    public SquareNotation(String notation) {
        this.notation = notation;
    }

    public Error isValid(){

        if(notation == null || notation.length() != 2)
            return Error.NOTATION_NOT_VALID;

        if(!Character.isLetter(notation.charAt(0)) 
        || !Character.isDigit(notation.charAt(1)))
        {
            return Error.NOTATION_NOT_VALID;
        }

        return Error.NULL;
    }

    public String getNotation(){
        return this.notation.toUpperCase();
    }
}