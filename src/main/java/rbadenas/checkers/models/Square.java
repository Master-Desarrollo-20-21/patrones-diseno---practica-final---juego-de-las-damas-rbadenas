package main.java.rbadenas.checkers.models;

import main.java.rbadenas.checkers.models.pieces.Piece;

public class Square {

    private Coordinate coordinate;
    private Piece piece;
    private SquareColor squareColor;

    public Square(int col, int row) {
        this.coordinate = new Coordinate(col, row);
        
        this.squareColor = this.coordinate.isWhiteOnCheckersBoard()
            ? SquareColor.WHITE
            : SquareColor.BLACK;
    }
    
    public void movePieceTo(Square target) {
        target.setPiece(this.piece);
        this.removePiece();
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    public void removePiece() {
        this.piece = null;
    }

    public void tryPromotePiece() {
        if (this.canPromote()) {
            this.piece = this.piece.promote();
        }
    }

    private boolean canPromote() {
        if (isWhitePiece())
            return this.coordinate.getRow() == Board.DIMENSION - 1;
        else
            return this.coordinate.getRow() == 0;
    }

    public boolean isWhitePiece(){
        return this.piece.isWhite();
    }
    
    public boolean isEmpty() {
        return this.piece == null;
    }

    public boolean pieceCanMove(Coordinate target, boolean isCapturing) {
        return this.piece.canMove(this.coordinate, target, isCapturing);
    }

    public boolean isWhite() {
        return this.squareColor.isWhite();
    }

    public Piece getPiece() {
        return this.piece;
    }
 
}