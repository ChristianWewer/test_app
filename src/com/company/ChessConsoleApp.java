package com.company;

import java.text.MessageFormat;
import java.util.Scanner;

public class ChessConsoleApp {
    String chosenPiece;

    public void startChessGame(int size){
        Board GameBoard = new Board(size);
        // This method controls the flow of the game. keeps track of turns and winning conditions.

        // Create scanner for later use to get inputs:
        Scanner inputScan = new Scanner(System.in);
        // Print initial Board:
        printBoard(GameBoard);
        while (true){
            // Choose Piece:
            writePieceSelectionToConsole(GameBoard);
            chosenPiece = choosePiece(inputScan,GameBoard);
            // Choose your current position
            Cell current_cell = setCurrentCell(inputScan, GameBoard);
            GameBoard.MarkLegalNextMove(current_cell, chosenPiece);
            printBoard(GameBoard);
        }
    }
    private String choosePiece(Scanner inputScan, Board GameBoard){
        System.out.print("Please enter the number for the piece you want to choose:");
        int index = inputScan.nextInt();
        return GameBoard.pieces[index];
    }
    private String writePieceSelectionToConsole(Board GameBoard){
        // Write all pieces:
        int i = 0;
        for (String temp : GameBoard.pieces){
            System.out.println(i+". "+temp);
            i++;
        }

        return "Knight";
    }

    private Cell setCurrentCell(Scanner inputScan, Board GameBoard){
        System.out.println("Please enter the x-coordinate of the field you want to place a knight on: \n >");
        int x = inputScan.nextInt();
        System.out.println("Please enter the y-coordinate of the field you want to place a knight on: \b >");
        int y = inputScan.nextInt();
        return GameBoard.theGrid[x][y]; // Return the cell specified by the user.
    }


    private void printBoard(Board GameBoard){
        String emptyField = "  ";
        String OccupiedField = " X ";
        String LegalMoveField = " + ";
        String currentField = " x ";
        String field_to_print;

        int size = GameBoard.size;
        System.out.print("|");
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                field_to_print = emptyField;
                if (GameBoard.theGrid[i][j].LegalNextMove){
                    field_to_print = LegalMoveField;
                }
                if (GameBoard.theGrid[i][j].currentlyOccupied){
                    field_to_print = OccupiedField;
                }
                System.out.print(field_to_print); // Symbolises legal move

                System.out.print("|"); // Column
            }
            System.out.print("\n");
            System.out.println("---------------------------------"); // Next row
            System.out.print("|");
        }
        System.out.println("===================================="); // Separator
    }
}
