package src.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ChessBoard extends JPanel {
    private int rows;
    private int columns;
    static int CELL_SIZE = 30;
    private ArrayList<ChessPiece> chessPieces;

    public ChessBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        setPreferredSize(new Dimension(columns * CELL_SIZE, rows * CELL_SIZE));
        setBackground(Color.CYAN);
        chessPieces = new ArrayList<>();
        initChessPieces();
    }

    private void initChessPieces() {
//        ChessPiece blackPiece = new ChessPiece(3, 3, Color.BLACK);
//        ChessPiece whitePiece = new ChessPiece(5, 5, Color.WHITE);
//        chessPieces.add(blackPiece);
//        chessPieces.add(whitePiece);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int row = y / CELL_SIZE;
                int column = x / CELL_SIZE;
                System.out.println(row);
                System.out.println(column);
                if(row < 1 || column < 1 || row > rows || column > columns){
                    System.out.println("点击无效");
                }
                else
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 1; i <= rows; i++) {
            int coordinate = i * CELL_SIZE;
            g.drawLine(CELL_SIZE, coordinate, rows * CELL_SIZE , coordinate);
            g.drawLine(coordinate, CELL_SIZE, coordinate, columns * CELL_SIZE);
        }

        for (ChessPiece piece : chessPieces) {
            piece.draw(g, CELL_SIZE);
        }
    }
}
