package src;

import src.UI.ChessBoard;
import src.UI.ChessPiece;
import src.UI.Result;
import src.UI.Status;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Stack;

public class Logic extends JPanel {
    public static void put(int[][] board, boolean player,
                           Stack<Point> stack,
                           int row, int column) {

        stack.push(new Point(row, column));

        //玩家1:1     玩家2:-1
        if(player)board[row][column] = -1;
        else board[row][column] = 1;
    }

    public static boolean back(int[][] board,
                            Stack<Point> stack,
                            HashMap<Point, ChessPiece>map) {
        if(stack.empty())return false;
        Point back = stack.pop();
        int row = back.x;
        int column = back.y;
        board[row][column] = 0;
        map.remove(back);
        return true;
    }

    public static void victory(int[][] board,int rows,
                        int columns,boolean player,
                        ChessBoard chessBoard) {
        //横
        flag1:
        for(int i=0;i<rows;i++) {
            int l = 0, r = l + 4, temp = 0;
            for (int j = l; j <= r; j++) {
                temp += board[i][j];
            }
            while (r < columns) {
                if(r + 1 == columns)break;
                if (Math.abs(temp) == 5) {
                    new Result(!player,chessBoard, Status.WIN);
                    ChessBoard.isWinMode = true;
                    break flag1;
                }
                temp -= board[i][l++];
                temp += board[i][(r++) + 1];
                if (Math.abs(temp) == 5) {
                    new Result(!player,chessBoard,Status.WIN);
                    ChessBoard.isWinMode = true;
                    break flag1;
                }
            }
        }

        //竖
        flag2:
        for(int i=0;i<columns;i++) {
            int l = 0, r = l + 4, temp = 0;
            for (int j = l; j <= r; j++) {
                temp += board[j][i];
            }
            while (r < rows) {
                if(r + 1 == rows)break;
                if (Math.abs(temp) == 5) {
                    new Result(!player,chessBoard,Status.WIN);
                    ChessBoard.isWinMode = true;
                    break flag2;
                }
                temp -= board[l++][i];
                temp += board[(r++) + 1][i];
                if (Math.abs(temp) == 5) {
                    new Result(!player,chessBoard,Status.WIN);
                    ChessBoard.isWinMode = true;
                    break flag2;
                }
            }
        }

        //斜
        flag3:
        for(int i = 0;i < rows - 4;i++) {
            //左上-右下
            for (int j = 0; j < columns - 4; j++) {
                int top = board[i][j];
                if(top == 0)continue;
                int k = 1;
                for(;k < 5;k++){
                    if(board[i+k][j+k]!=top)break;
                }
                if(k == 5){
                    new Result(!player,chessBoard,Status.WIN);
                    ChessBoard.isWinMode = true;
                    break flag3;
                }
            }

            //左下-右上
            for (int j = 4; j < columns; j++) {
                int top = board[i][j];
                if(top == 0)continue;
                int k = 1;
                for(;k < 5;k++){
                    if(board[i+k][j-k]!=top)break;
                }
                if(k == 5){
                    new Result(!player,chessBoard,Status.WIN);
                    ChessBoard.isWinMode = true;
                    break flag3;
                }
            }
        }
        draw(board,rows,columns,chessBoard);
    }

    public static void leave(ChessBoard chessBoard,boolean isRoomOwner){
        if(isRoomOwner)
            new Result(false,chessBoard,Status.LEAVE);
        else
            new Result(true,chessBoard,Status.CLOSE);
    }

    //平局
    public static void draw(int[][] board,int rows,
                               int columns,
                               ChessBoard chessBoard){
        
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < columns;j++){
                if(board[i][j] == 0)return;
            }
        }
        new Result(false,chessBoard,Status.DRAW);
    }

    public static boolean judge(int[][] board, int row, int column) {
        if(board[row][column] != 0){
//            System.out.println("该位置已下过,请重新输入:");
            return true;
        }
        return false;
    }

}
