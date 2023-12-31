package src;

import src.UI.ChessBoard;
import src.UI.ChessPiece;
import src.UI.Menu;
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

    public static boolean win(int temp,ChessBoard chessBoard){
        if(Math.abs(temp) == 5){
            String name = ChessBoard.player == Player.isRoomOwner() ? Menu.instance.name : Menu.instance.otherName;
            new Result(name,chessBoard, Status.WIN);
            ChessBoard.isWinMode = true;
            return true;
        }
        return false;
    }

    public static void victory(int[][] board,int rows,
                        int columns,
                        ChessBoard chessBoard) {
        //横
        flag1:
        if(columns >= 5) {
            for (int i = 0; i < rows; i++) {
                int l = 0, r = l + 4, temp = 0;
                for (int j = l; j <= r; j++) {
                    temp += board[i][j];
                }
                if (win(temp, chessBoard)) break;
                while (r < columns) {
                    if (r + 1 == columns) break;
                    if (win(temp, chessBoard)) break flag1;
                    temp -= board[i][l++];
                    temp += board[i][(r++) + 1];
                    if (win(temp, chessBoard)) break flag1;
                }
            }
        }

        //竖
        flag2:
        if(rows >= 5) {
            for (int i = 0; i < columns; i++) {
                int l = 0, r = l + 4, temp = 0;
                for (int j = l; j <= r; j++) {
                    temp += board[j][i];
                }
                if (win(temp, chessBoard)) break;
                while (r < rows) {
                    if (r + 1 == rows) break;
                    if (win(temp, chessBoard)) break flag2;
                    temp -= board[l++][i];
                    temp += board[(r++) + 1][i];
                    if (win(temp, chessBoard)) break flag2;
                }
            }
        }

        //斜
        flag3:
        if(rows >= 5 && columns >= 5) {
            for (int i = 0; i < rows - 4; i++) {
                //左上-右下
                for (int j = 0; j < columns - 4; j++) {
                    int top = board[i][j];
                    if (top == 0) continue;
                    int k = 1;
                    for (; k < 5; k++) {
                        if (board[i + k][j + k] != top) break;
                    }
                    if (win(k, chessBoard)) break flag3;
                }

                //左下-右上
                for (int j = 4; j < columns; j++) {
                    int top = board[i][j];
                    if (top == 0) continue;
                    int k = 1;
                    for (; k < 5; k++) {
                        if (board[i + k][j - k] != top) break;
                    }
                    if (win(k, chessBoard)) break flag3;
                }
            }
        }

        draw(board,rows,columns,chessBoard);
    }

    public static void leave(ChessBoard chessBoard,boolean isRoomOwner){
        if(isRoomOwner)
            new Result(Menu.instance.otherName,chessBoard,Status.LEAVE);
        else
            new Result(Menu.instance.name,chessBoard,Status.LEAVE);
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
        new Result(null,chessBoard,Status.DRAW);
    }

    public static boolean judge(int[][] board, int row, int column) {
        if(board[row][column] != 0){
//            System.out.println("该位置已下过,请重新输入:");
            return true;
        }
        return false;
    }

}
