package src.UI;

import javafx.util.Pair;
import src.Gobang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;

public class ChessBoard extends JPanel {
    private int rows;
    private int columns;
    public static int CELL_SIZE = 50;
    private static boolean player = false;//下一个下棋的玩家,false玩家1,true玩家2
    private ArrayList<ChessPiece> chessPieces;

    public static int row,column;
    private boolean isVectorMode = false;

    public ChessBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        int[][] board = new int[rows][columns];
        Stack<Pair<Integer,Integer>>stack = new Stack<>();
        setPreferredSize(new Dimension(columns * CELL_SIZE, rows * CELL_SIZE));
        chessPieces = new ArrayList<>();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isVectorMode)return;
                float x = e.getX();
                float y = e.getY();
                float xt = x / CELL_SIZE,yt = y / CELL_SIZE;
                row = ((yt - (int)yt) > 0.5) ? (int)yt + 1 : (int)yt;
                column = ((xt - (int)xt) > 0.5) ? (int)xt + 1 : (int)xt;
                if(row < 1 || column < 1 || row > rows || column > columns || judge(board, row - 1, column - 1)){
                    System.out.println("点击无效");
                }
                else if(player){
//                    System.out.println("玩家2");
                    put(board,player,stack,row - 1,column - 1);
                    ChessPiece piece = new ChessPiece(row, column, Color.WHITE);
                    chessPieces.add(piece);
                    player = !player;
                }
                else if(!player){
//                    System.out.println("玩家1");
                    put(board,player,stack,row - 1,column - 1);
                    ChessPiece piece = new ChessPiece(row, column, Color.BLACK);
                    chessPieces.add(piece);
                    player = !player;
                }
                victory(board,row,column);
                updateUI();
//                Gobang.display(board);
//                System.out.println(player ? "玩家2" : "玩家1");
            }
        });

    }

    private boolean judge(int[][] board, int row, int column) {
        if(board[row][column] != 0){
            System.out.println("该位置已下过,请重新输入:");
            return true;
        }
        return false;
    }

    public void victory(int[][] board,int row,int column) {
        //横
        flag1:
        for(int i=0;i<this.rows;i++) {
            int l = 0, r = l + 4, temp = 0;
            for (int j = l; j <= r; j++) {
                temp += board[i][j];
            }
            while (r < this.columns) {
                if(r + 1 == this.columns)break;
                if (Math.abs(temp) == 5) {
                    new Win(!player,this);
                    isVectorMode = true;
                    break flag1;
                }
                else{
                    temp -= board[i][l++];
                    temp += board[i][(r++) + 1];
                }
            }
        }

        //竖
        flag2:
        for(int i=0;i<this.columns;i++) {
            int l = 0, r = l + 4, temp = 0;
            for (int j = l; j <= r; j++) {
                temp += board[j][i];
            }
            while (r < this.rows) {
                if(r + 1 == this.rows)break;
                if (Math.abs(temp) == 5) {
                    new Win(!player,this);
                    isVectorMode = true;
                    break flag2;
                }
                else{
                    temp -= board[l++][i];
                    temp += board[(r++) + 1][i];
                }
            }
        }

        //斜
        flag3:
        for(int i = 0;i < this.rows - 4;i++) {
            //左上-右下
            for (int j = 0; j < this.columns - 4; j++) {
                int top = board[i][j];
                if(top == 0)continue;
                int k = 1;
                for(;k < 5;k++){
                    if(board[i+k][j+k]!=top)break;
                }
                if(k == 5){
                    new Win(!player,this);
                    isVectorMode = true;
                    break flag3;
                }
                else{
                    for(int m  = 1;m < k;m++){
                        board[i+m][j+m] = 0;
                    }
                }
            }

            //左下-右上
            for (int j = 4; j < this.columns; j++) {
                int top = board[i][j];
                if(top == 0)continue;
                int k = 1;
                for(;k < 5;k++){
                    if(board[i+k][j-k]!=top)break;
                }
                if(k == 5){
                    new Win(!player,this);
                    isVectorMode = true;
                    break flag3;
                }
                else{
                    for(int m  = 1;m < k;m++){
                        board[i+m][j-m] = 0;
                    }
                }
            }
        }
    }

    private static void put(int[][] board, boolean player, Stack<Pair<Integer, Integer>> stack,int row,int column) {
        stack.push(new Pair<>(row,column));
        //玩家1:1     玩家2:-1
        if(player)board[row][column] = -1;
        else board[row][column] = 1;
    }

    public void updateUI() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        setBackground(Color.CYAN);

        for (int i = 1; i <= rows; i++) {
            int coordinate = i * CELL_SIZE;
            g.drawLine(CELL_SIZE, coordinate, rows * CELL_SIZE , coordinate);
            g.drawLine(coordinate, CELL_SIZE, coordinate, columns * CELL_SIZE);
        }

        for (ChessPiece piece : chessPieces) {
            piece.draw(g, CELL_SIZE);
        }
    }

    public void closeBoard() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.dispose();
        }
    }
}
