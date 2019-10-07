package com.company;

public class Cell {
    public int columnNumber;
    public int rowNumber;
    public boolean currentlyOccupied;
    public boolean LegalNextMove;

    Cell(int x, int y){
        columnNumber = x;
        rowNumber = y;
    }
}
