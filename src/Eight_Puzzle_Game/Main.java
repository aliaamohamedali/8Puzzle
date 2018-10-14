/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eight_Puzzle_Game;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JLabel;

/**
 *
 * @author Abd El Rahman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animation x = new Animation();
        x.jLabel0t(")");
        x.draw();
        
        int[][] table = {{1, 2, 5}, {3, 4, 0}, {6, 7, 8}};
        int[][] goal = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        Board initialState = new Board(table);
        Board goalState = new Board(goal);

        AI solver = new AI();
        solver.aStar(initialState, goalState);

    }

    public static void print(int[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((board[i][j] == 0 ? " " : board[i][j]) + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }

    }

}
