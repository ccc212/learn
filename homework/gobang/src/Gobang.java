package src;

import javafx.util.Pair;

import java.util.Scanner;
import java.util.Stack;

public class Gobang {
    static Scanner sc = new Scanner(System.in);
    static int row,column;
    static int[][] board;

    public Gobang(){
        System.out.print("输入棋盘行数和列数:");
        boolean winner;
        row = sc.nextInt();
        column = sc.nextInt();
        board = new int[row][column];
        winner = game(board);
        if(winner) System.out.println("玩家2获胜");
        else System.out.println("玩家1获胜");
    }

    private static boolean game(int[][] board) {
        //玩家1:false     玩家2:true
        boolean player = false;
        Stack<Pair<Integer,Integer>>stack = new Stack<>();
        Game:
        while(true){
            System.out.println("1.落子\t2.悔棋");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    put(board,player,stack);
                    player = !player;
                    break;
                case 2:
                    back(board,stack);
                    player = !player;
                    break;
                default:
                    break Game;
            }
            display(board);
            if(victory(board)){
                player = !player;
                break;
            }
        }
        return player;
    }

    private static boolean victory(int[][] board) {
        row = board.length;
        column = board[0].length;
        for(int i=0;i<row;i++) {
            int l = 0, r = l + 4, temp = 0;
            for (int j = l; j <= r; j++) {
                temp += board[i][j];
            }
            while (r < column) {
                if (Math.abs(temp) == 5) return true;
                else{
                    temp -= board[i][l++];
                    temp += board[i][r++];
                }
            }
        }
        for (int i = 0; i < column; i++) {
            int l = 0, r = l + 4, temp = 0;
            for (int j = l; j <= r; j++) {
                temp += board[i][j];
            }
            while (r < row) {
                if (Math.abs(temp) == 5) return true;
                else{
                    temp -= board[i][l++];
                    temp += board[i][r++];
                }
            }
        }
        return false;
    }

    private static void display(int[][] board) {
        System.out.println("当前棋局:");
        for (int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void back(int[][] board, Stack<Pair<Integer, Integer>> stack) {
        if(stack.empty())return;
        Pair<Integer,Integer>back = stack.pop();
        row = (int)back.getKey();
        column = (int)back.getValue();
//        test(row,column);
        board[row][column] = 0;
    }

    private static void test(int row, int column) {
        System.out.println("row:"+row);
        System.out.println("column:"+column);
    }

    private static void put(int[][] board, boolean player, Stack<Pair<Integer, Integer>> stack) {
        System.out.print("落子的位置:");
        row = sc.nextInt();
        column = sc.nextInt();
        while(board[row][column] != 0){
            System.out.println("该位置已下过,请重新输入:");
            row = sc.nextInt();
            column = sc.nextInt();
        }
        stack.push(new Pair<>(row,column));
//        test(row,column);
        //玩家1:1     玩家2:-1
        if(player)board[row][column] = -1;
        else board[row][column] = 1;
    }
}
