package com.GUI;

import com.company.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class ChessAppGui {
    private JComboBox comboBox1;
    private JTextField thisIsSomeImportTextField;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private String chosenPiece = String.valueOf(comboBox1.getSelectedItem());
    Board GameBoard = new Board(8);
    public JButton[][] btnGrid = new JButton[GameBoard.size][GameBoard.size];
    JFrame frame = new JFrame("Chess app");

    public void initiateGui(){
        buttonPanel.setSize(600,600);
        buttonPanel.setLayout(null);
        int buttonSize = buttonPanel.getWidth() / GameBoard.size;
        System.out.println(buttonPanel.getWidth());
        System.out.println(GameBoard.size);
        for (int i = 0; i < GameBoard.size; i++){
            for (int j = 0; j < GameBoard.size; j++){
                btnGrid[i][j] = new JButton(i+":"+j);
                btnGrid[i][j].setSize(buttonSize,buttonSize);
                buttonPanel.add(btnGrid[i][j]);
                btnGrid[i][j].setLocation(buttonSize*i,buttonSize*j);
                btnGrid[i][j].setName("i,j");
                btnGrid[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        String response = actionEvent.getSource().toString();
                        String response_trimmed = actionEvent.getSource().toString().substring(24,response.length()-1);
                        ArrayList<String> list = new ArrayList<String>(Arrays.asList(response_trimmed.split(",")));

                        // Coords holds the point at which the buttons are placed.
                        int x_coord =  Integer.parseInt(list.get(0));
                        int y_coord = Integer.parseInt(list.get(1));

                        // Positions holds the location on the grid i.e. (i,j).
                        int x_pos = x_coord/buttonSize;
                        int y_pos = y_coord/buttonSize;

                        GameBoard.MarkLegalNextMove(GameBoard.theGrid[x_pos][y_pos],chosenPiece);
                        updateButtonTexts();
                    }
                });
            }
        }
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public void updateButtonTexts(){
        String emptyField = "  ";
        String OccupiedField = " X ";
        String LegalMoveField = " + ";
        String currentField = " x ";
        String field_to_print;
        for (int i = 0; i < GameBoard.size; i++){
            for (int j = 0; j < GameBoard.size; j++){
                field_to_print = emptyField;
                if (GameBoard.theGrid[i][j].LegalNextMove){
                    field_to_print = LegalMoveField;
                }
                if (GameBoard.theGrid[i][j].currentlyOccupied){
                    field_to_print = OccupiedField;
                }
                btnGrid[i][j].setText(field_to_print);
            }
        }
    }

    public ChessAppGui() {
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //When someone chooses a new selectiond in the dropdown menu
                chosenPiece = String.valueOf(comboBox1.getSelectedItem());
            }
        });
    }

    public void initialiseGUI(){

    }
}
