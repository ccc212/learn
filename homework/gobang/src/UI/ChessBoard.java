package src.UI;

import src.Gobang;
import src.Info;
import src.Logic;
import src.thread.OutRunnable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class ChessBoard extends JPanel {

    private int rows;
    private int columns;
    public static int CELL_SIZE = 50;
    public static boolean player = false;//下一个下棋的玩家,false玩家1,true玩家2

    public HashMap<Point,ChessPiece> map;

    public int row,column;
    public static boolean isWinMode = false;
    public Stack<Point>stack;
    public int[][] board;
    private Point lastClickPoint;
    private boolean clickable = true;
    public boolean keyEnable = true;

    public ChessBoard(int rows, int columns) {
        setBackground(Color.getHSBColor(
                Color.RGBtoHSB(210, 132, 0,null)[0],
                Color.RGBtoHSB(210, 132, 0,null)[1],
                Color.RGBtoHSB(210, 132, 0,null)[2]));
        this.rows = rows;
        this.columns = columns;
        board = new int[rows][columns];

        stack = new Stack<>();

        map = new HashMap<>();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (isWinMode) return;
                    if(clickable) {
                        click(e.getX(), e.getY());
                        lastClickPoint = e.getPoint();
                    }
                }
            });

            setFocusable(true);
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if(keyEnable) {
                        int key = e.getKeyCode();
                        if (stack.empty()) {
                            JOptionPane.showMessageDialog(ChessBoard.this, "无法悔棋");
                        } else if (key == KeyEvent.VK_R) {
                            System.out.println("R");
                            isWinMode = false;
                            try {
                                OutRunnable.oos.writeObject(new Info("R"));
                                Game.instance.setChessBoardClickable(!Game.instance.getChessBoard().getClickable());
                                keyEnable = false;
                                Game.instance.setChessBoardClickable(false);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });

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
            Logic.put(board,player,stack,row - 1,column - 1);
            ChessPiece piece = new ChessPiece(row, column, Color.WHITE);

            map.put(new Point(row - 1,column - 1),piece);

            player = !player;
        }
        else if(!player){
            Logic.put(board,player,stack,row - 1,column - 1);
            ChessPiece piece = new ChessPiece(row, column, Color.BLACK);

            map.put(new Point(row - 1,column - 1),piece);

            player = !player;
        }

        Logic.victory(board,rows,columns,this);
        updateUI();

//                Gobang.display(board);
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

    public boolean getClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

}
