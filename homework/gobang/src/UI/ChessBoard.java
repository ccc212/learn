package src.UI;

import javafx.util.Pair;
import src.Gobang;
import src.Info;
import src.Logic;
import src.Player;
import src.thread.OutRunnable;
import sun.rmi.runtime.Log;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;

public class ChessBoard extends JPanel {

    private int rows;
    private int columns;
    public static int CELL_SIZE = 50;
    private static boolean player = false;//下一个下棋的玩家,false玩家1,true玩家2

//    private HashMap<Pair<Integer,Integer>,ChessPiece> map;
    public HashMap<Point,ChessPiece> map;

    public int row,column;
    public static boolean isWinMode = false;
    public Stack<Point>stack;
    public int[][] board;
    private Point lastClickPoint;
    public static boolean isEnabled = true;
    public ChessBoard(int rows, int columns) {
        setBackground(Color.getHSBColor(
                Color.RGBtoHSB(210, 132, 0,null)[0],
                Color.RGBtoHSB(210, 132, 0,null)[1],
                Color.RGBtoHSB(210, 132, 0,null)[2]));
        this.rows = rows;
        this.columns = columns;
        board = new int[rows][columns];

//        Stack<Pair<Integer,Integer>>stack = new Stack<>();
        stack = new Stack<>();

        map = new HashMap<>();

        if(isEnabled()) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (isWinMode) return;
                    click(e.getX(), e.getY());
                    lastClickPoint = e.getPoint();
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
                    if (key == KeyEvent.VK_R) {
                        System.out.printf("R");
                        isWinMode = false;
                        try {
                            OutRunnable.oos.writeObject(new Info("R"));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
//                        Logic.back(board, stack, map, row, column);
                        player = !player;
//                        updateUI();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
        }
    }

    public boolean judge(int x,int y){
        float xt = (float)x / CELL_SIZE,yt = (float)y / CELL_SIZE;
        row = ((yt - (int)yt) > 0.5) ? (int)yt + 1 : (int)yt;
        column = ((xt - (int)xt) > 0.5) ? (int)xt + 1 : (int)xt;
        if(row < 1 || column < 1 ||
                row > rows || column > columns ||
                Logic.judge(board, row - 1, column - 1)){
            return false;
        }
        return true;
    }

    public void click(int x,int y) {
        float xt = (float)x / CELL_SIZE,yt = (float)y / CELL_SIZE;
        row = ((yt - (int)yt) > 0.5) ? (int)yt + 1 : (int)yt;
        column = ((xt - (int)xt) > 0.5) ? (int)xt + 1 : (int)xt;
        if(row < 1 || column < 1 || row > rows || column > columns || Logic.judge(board, row - 1, column - 1)){
            System.out.println("点击无效");
        }
        else if(player){
//                    System.out.println("玩家2");
            Logic.put(board,player,stack,row - 1,column - 1);
            ChessPiece piece = new ChessPiece(row, column, Color.WHITE);

//                    map.put(new Pair<>(row - 1,column - 1),piece);
            map.put(new Point(row - 1,column - 1),piece);

            player = !player;
        }
        else if(!player){
//                    System.out.println("玩家1");
            Logic.put(board,player,stack,row - 1,column - 1);
            ChessPiece piece = new ChessPiece(row, column, Color.BLACK);

//                    map.put(new Pair<>(row - 1,column - 1),piece);
            map.put(new Point(row - 1,column - 1),piece);

            player = !player;
        }

        Logic.victory(board,rows,columns,player,this);
        updateUI();

//                Gobang.display(board);
//                System.out.println(player ? "玩家2" : "玩家1");
    }

    public Point getLastClickPoint() {
        return lastClickPoint;
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
        SwingUtilities.getWindowAncestor(this).dispose();
    }
    
    public static void init(){
        player = false;
        isWinMode = false;
    }

}
