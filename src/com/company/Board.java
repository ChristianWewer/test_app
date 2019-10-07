package com.company;

public class Board {

    public int size;
    public Cell[][] theGrid;
    public String[] pieces = {"Knight", "King", "Queen", "Bishop", "Rook", "Pawn"};

    public Board(int s) {
        size = s;

        theGrid = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Create cell:
                theGrid[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean isCellOnBoard(int x, int y) {
        boolean isOnBoard = false;
        if ((x >= 0 && y >= 0) && (x < size && y < size)) {
            isOnBoard = true;
        }
        return isOnBoard;
    }

    public void MarkLegalNextMove(Cell currentCell, String chessPiece) {
        System.out.println(currentCell.columnNumber);
        System.out.print(currentCell.rowNumber);
        // instantiate the board: I.e. set CurrentlyOccupied and LegalNextMove = False.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                theGrid[i][j].currentlyOccupied = false;
                theGrid[i][j].LegalNextMove = false;
            }
        }
        System.out.println(currentCell.columnNumber);
        System.out.println(currentCell.rowNumber);
        System.out.println(size);
        // Find all legal moves:

        switch (chessPiece) {
            case "Knight":
                if (isCellOnBoard(currentCell.columnNumber + 2, currentCell.rowNumber + 1)) {
                    theGrid[currentCell.columnNumber + 2][currentCell.rowNumber + 1].LegalNextMove = true;
                    System.out.println(theGrid[currentCell.columnNumber + 2][currentCell.rowNumber + 1].LegalNextMove);
                }
                if (isCellOnBoard(currentCell.columnNumber + 2, currentCell.rowNumber - 1)) {
                    theGrid[currentCell.columnNumber + 2][currentCell.rowNumber - 1].LegalNextMove = true;
                    System.out.println(theGrid[currentCell.columnNumber + 2][currentCell.rowNumber - 1].LegalNextMove);
                }
                if (isCellOnBoard(currentCell.columnNumber - 2, currentCell.rowNumber + 1)) {
                    theGrid[currentCell.columnNumber - 2][currentCell.rowNumber + 1].LegalNextMove = true;
                    System.out.println(theGrid[currentCell.columnNumber - 2][currentCell.rowNumber + 1].LegalNextMove);
                }
                if (isCellOnBoard(currentCell.columnNumber - 2, currentCell.rowNumber - 1)) {
                    theGrid[currentCell.columnNumber - 2][currentCell.rowNumber - 1].LegalNextMove = true;
                    System.out.println(theGrid[currentCell.columnNumber - 2][currentCell.rowNumber - 1].LegalNextMove);
                }
                if (isCellOnBoard(currentCell.columnNumber + 1, currentCell.rowNumber + 2)) {
                    theGrid[currentCell.columnNumber + 1][currentCell.rowNumber + 2].LegalNextMove = true;
                    System.out.println(theGrid[currentCell.columnNumber + 1][currentCell.rowNumber + 2].LegalNextMove);
                }
                if (isCellOnBoard(currentCell.columnNumber + 1, currentCell.rowNumber - 2)) {
                    theGrid[currentCell.columnNumber + 1][currentCell.rowNumber - 2].LegalNextMove = true;
                    System.out.println(theGrid[currentCell.columnNumber + 1][currentCell.rowNumber - 2].LegalNextMove);
                }
                if (isCellOnBoard(currentCell.columnNumber - 1, currentCell.rowNumber + 2)) {
                    theGrid[currentCell.columnNumber - 1][currentCell.rowNumber + 2].LegalNextMove = true;
                    System.out.println(theGrid[currentCell.columnNumber - 1][currentCell.rowNumber + 2].LegalNextMove);
                }
                if (isCellOnBoard(currentCell.columnNumber - 1, currentCell.rowNumber - 2)) {
                    theGrid[currentCell.columnNumber - 1][currentCell.rowNumber - 2].LegalNextMove = true;
                    System.out.println(theGrid[currentCell.columnNumber - 1][currentCell.rowNumber - 2].LegalNextMove);
                }
                break;
            case "Queen":
                // Linear movement.
                for (int i = 0; i < size; i++) {
                    if (theGrid[i][currentCell.rowNumber] != theGrid[currentCell.columnNumber][currentCell.rowNumber]) {
                        theGrid[i][currentCell.rowNumber].LegalNextMove = true;
                    }
                    if (theGrid[currentCell.columnNumber][i] != theGrid[currentCell.columnNumber][currentCell.rowNumber]) {
                        theGrid[currentCell.columnNumber][i].LegalNextMove = true;
                    }
                }
                //Diagonal movement:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (i == j){
                            if ((isCellOnBoard(currentCell.columnNumber + i, currentCell.rowNumber + j) // ignore out of bounds
                                    && theGrid[currentCell.columnNumber + i][currentCell.rowNumber + j] != theGrid[currentCell.columnNumber][currentCell.rowNumber])) {
                                theGrid[currentCell.columnNumber + i][currentCell.rowNumber + j].LegalNextMove = true;
                            }
                            if ((isCellOnBoard(currentCell.columnNumber - i, currentCell.rowNumber - j) // ignore out of bounds
                                    && theGrid[currentCell.columnNumber - i][currentCell.rowNumber - j] != theGrid[currentCell.columnNumber][currentCell.rowNumber])) {
                                theGrid[currentCell.columnNumber - i][currentCell.rowNumber - j].LegalNextMove = true;
                            }
                            if ((isCellOnBoard(currentCell.columnNumber - i, currentCell.rowNumber + j) // ignore out of bounds
                                    && theGrid[currentCell.columnNumber - i][currentCell.rowNumber + j] != theGrid[currentCell.columnNumber][currentCell.rowNumber])) {
                                theGrid[currentCell.columnNumber - i][currentCell.rowNumber + j].LegalNextMove = true;
                            }
                            if ((isCellOnBoard(currentCell.columnNumber + i, currentCell.rowNumber - j) // ignore out of bounds
                                    && theGrid[currentCell.columnNumber + i][currentCell.rowNumber - j] != theGrid[currentCell.columnNumber][currentCell.rowNumber])) {
                                theGrid[currentCell.columnNumber + i][currentCell.rowNumber - j].LegalNextMove = true;
                            }
                        }
                    }
                }
                break;
            case "King":
                if (isCellOnBoard(currentCell.columnNumber + 1, currentCell.rowNumber)) {
                    theGrid[currentCell.columnNumber + 1][currentCell.rowNumber].LegalNextMove = true;
                }
                if (isCellOnBoard(currentCell.columnNumber - 1, currentCell.rowNumber)) {
                    theGrid[currentCell.columnNumber - 1][currentCell.rowNumber].LegalNextMove = true;
                }
                if (isCellOnBoard(currentCell.columnNumber, currentCell.rowNumber + 1)) {
                    theGrid[currentCell.columnNumber][currentCell.rowNumber + 1].LegalNextMove = true;
                }
                if (isCellOnBoard(currentCell.columnNumber, currentCell.rowNumber - 1)) {
                    theGrid[currentCell.columnNumber][currentCell.rowNumber - 1].LegalNextMove = true;
                }
                if (isCellOnBoard(currentCell.columnNumber + 1, currentCell.rowNumber - 1)) {
                    theGrid[currentCell.columnNumber + 1][currentCell.rowNumber - 1].LegalNextMove = true;
                }
                if (isCellOnBoard(currentCell.columnNumber - 1, currentCell.rowNumber + 1)) {
                    theGrid[currentCell.columnNumber - 1][currentCell.rowNumber + 1].LegalNextMove = true;
                }
                if (isCellOnBoard(currentCell.columnNumber + 1, currentCell.rowNumber + 1)) {
                    theGrid[currentCell.columnNumber + 1][currentCell.rowNumber + 1].LegalNextMove = true;
                }
                if (isCellOnBoard(currentCell.columnNumber - 1, currentCell.rowNumber - 1)) {
                    theGrid[currentCell.columnNumber - 1][currentCell.rowNumber - 1].LegalNextMove = true;
                }
                break;
            case "Pawn":
                if (isCellOnBoard(currentCell.columnNumber, currentCell.rowNumber-1)){
                    theGrid[currentCell.columnNumber][currentCell.rowNumber-1].LegalNextMove = true;
                }
                if (currentCell.rowNumber == size-2){
                    theGrid[currentCell.columnNumber][currentCell.rowNumber-2].LegalNextMove = true;
                }
                break;
            case "Rook":
                for (int i = 0; i < size; i++) {
                    if (theGrid[i][currentCell.rowNumber] != theGrid[currentCell.columnNumber][currentCell.rowNumber]) {
                        theGrid[i][currentCell.rowNumber].LegalNextMove = true;
                    }
                    if (theGrid[currentCell.columnNumber][i] != theGrid[currentCell.columnNumber][currentCell.rowNumber]) {
                        theGrid[currentCell.columnNumber][i].LegalNextMove = true;
                    }
                }
                break;
            case "Bishop":
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (i == j){
                            if ((isCellOnBoard(currentCell.columnNumber + i, currentCell.rowNumber + j) // ignore out of bounds
                                    && theGrid[currentCell.columnNumber + i][currentCell.rowNumber + j] != theGrid[currentCell.columnNumber][currentCell.rowNumber])) {
                                theGrid[currentCell.columnNumber + i][currentCell.rowNumber + j].LegalNextMove = true;
                            }
                            if ((isCellOnBoard(currentCell.columnNumber - i, currentCell.rowNumber - j) // ignore out of bounds
                                    && theGrid[currentCell.columnNumber - i][currentCell.rowNumber - j] != theGrid[currentCell.columnNumber][currentCell.rowNumber])) {
                                theGrid[currentCell.columnNumber - i][currentCell.rowNumber - j].LegalNextMove = true;
                            }
                            if ((isCellOnBoard(currentCell.columnNumber - i, currentCell.rowNumber + j) // ignore out of bounds
                                    && theGrid[currentCell.columnNumber - i][currentCell.rowNumber + j] != theGrid[currentCell.columnNumber][currentCell.rowNumber])) {
                                theGrid[currentCell.columnNumber - i][currentCell.rowNumber + j].LegalNextMove = true;
                            }
                            if ((isCellOnBoard(currentCell.columnNumber + i, currentCell.rowNumber - j) // ignore out of bounds
                                    && theGrid[currentCell.columnNumber + i][currentCell.rowNumber - j] != theGrid[currentCell.columnNumber][currentCell.rowNumber])) {
                                theGrid[currentCell.columnNumber + i][currentCell.rowNumber - j].LegalNextMove = true;
                            }
                        }
                    }
                }
                break;
        }

        theGrid[currentCell.columnNumber][currentCell.rowNumber].currentlyOccupied = true;

    }
}
