package src.UI;

import javafx.util.Pair;
import src.Logic;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Stack;

public class ChessBoard extends JPanel {

    private int rows;
    private int columns;
    public static int CELL_SIZE = 50;
    private static boolean player = false;//下一个下棋的玩家,false玩家1,true玩家2
    private HashMap<Pair<Integer,Integer>,ChessPiece> map;

    private int row,column;
    public static boolean isVectorMode = false;
    public ChessBoard(int rows, int columns) {
        setBackground(Color.getHSBColor(
                Color.RGBtoHSB(210, 132, 0,null)[0],
                Color.RGBtoHSB(210, 132, 0,null)[1],
                Color.RGBtoHSB(210, 132, 0,null)[2]));
        this.rows = rows;
        this.columns = columns;
        int[][] board = new int[rows][columns];
        Stack<Pair<Integer,Integer>>stack = new Stack<>();
//        setPreferredSize(new Dimension(columns * CELL_SIZE, rows * CELL_SIZE));
        map = new HashMap<>();



        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isVectorMode)return;
                float x = e.getX();
                float y = e.getY();
                float xt = x / CELL_SIZE,yt = y / CELL_SIZE;
                row = ((yt - (int)yt) > 0.5) ? (int)yt + 1 : (int)yt;
                column = ((xt - (int)xt) > 0.5) ? (int)xt + 1 : (int)xt;
                if(row < 1 || column < 1 || row > rows || column > columns || Logic.judge(board, row - 1, column - 1)){
                    System.out.println("点击无效");
                }
                else if(player){
//                    System.out.println("玩家2");
                    Logic.put(board,player,stack,row - 1,column - 1);
                    ChessPiece piece = new ChessPiece(row, column, Color.WHITE);
                    map.put(new Pair<>(row - 1,column - 1),piece);
                    player = !player;
                }
                else if(!player){
//                    System.out.println("玩家1");
                    Logic.put(board,player,stack,row - 1,column - 1);
                    ChessPiece piece = new ChessPiece(row, column, Color.BLACK);
                    map.put(new Pair<>(row - 1,column - 1),piece);
                    player = !player;
                }
                Logic.victory(board,rows,columns,player,new ChessBoard(rows,columns));
                updateUI();
//                Gobang.display(board);
//                System.out.println(player ? "玩家2" : "玩家1");
            }
        });

        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_R){
                    System.out.printf("R");
                    isVectorMode = false;
                    Logic.back(board,stack,map,row,column);
                    player = !player;
                    updateUI();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    public void updateUI() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        for(int i=1;i<=rows;i++){
            int coordinate = i * CELL_SIZE;
            g.drawLine(CELL_SIZE, coordinate, columns * CELL_SIZE , coordinate);
        }
        for(int j=1;j<=columns;j++){
            int coordinate = j * CELL_SIZE;
            g.drawLine(coordinate, CELL_SIZE, coordinate, rows * CELL_SIZE);
        }

        map.forEach((k,v)->{
            v.draw(g,CELL_SIZE);
        });
    }

    public void close() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }
}
