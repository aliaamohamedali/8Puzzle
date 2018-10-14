/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eight_Puzzle_Game;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Abd El Rahman
 */
public class AI {

    public boolean BFS(Board initialState, Board goalTest) {
        Board state;
        Queue<Board> frontier = new LinkedList<>();
        Set<Board> explored = new HashSet<>();

        frontier.add(initialState);

        while (!frontier.isEmpty()) {
            state = frontier.poll();
            explored.add(state);

            if (state.equals(goalTest)) {
                return success(state);
            }

            for (Board neighbour : state.getNeighbours()) {
                if (!frontier.contains(neighbour) && !explored.contains(neighbour)) {
                    frontier.add(neighbour);
                }
            }
        }

        return false;
    }

    public boolean DLS(Board initialState, Board goalTest, int limit) {
        Board state;
        Stack<Board> frontier = new Stack<>();
        Set<Board> explored = new HashSet<>();

        frontier.push(initialState);
        while (!frontier.isEmpty()) {
            state = frontier.pop();
            print(state.getBoard());
            explored.add(state);

            if (state.equals(goalTest)) {
                return success(state);
            }

            if(state.getDepth()< limit){
                for (Board neighbour : state.getNeighbours()) {
                    if (!frontier.contains(neighbour) && !explored.contains(neighbour)) {
                        // neighbour.setDepth(neighbour.getParent().getDepth()+1);
                        frontier.push(neighbour);
                    }
                }
            }
        }
        return false;
    }
        
    public boolean aStar(Board initialState, Board goalTest){
        
        Board state;
        PriorityQueue<Board> frontier = new PriorityQueue<>();
        Set<Board> explored = new HashSet<>();

        frontier.add(initialState);

        while (!frontier.isEmpty()) {
            state = frontier.poll();
            explored.add(state);
            
            print(state.getBoard());
            System.out.println(state.getCost());
            
            if (state.equals(goalTest)) {
                return success(state);
            }

            for (Board neighbour : state.getNeighbours()) {
                if (!frontier.contains(neighbour) && !explored.contains(neighbour)) {
                    frontier.add(neighbour);
                }else if (frontier.contains(neighbour)){
                    frontier.remove(neighbour);
                    frontier.add(neighbour);
                }
            }
        }
        return false;
        
    }

    public static void print(int[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((board[i][j] == 0 ? " " : board[i][j]) + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
        System.out.println();

    }

    private boolean success(Board state) {
        Stack<String> moves = new Stack<>();

        while (state.getParent() != null) {
            moves.add(state.getPreviousMove());
            state = state.getParent();
        }
        System.out.println(moves);
        return true;
    }
}
