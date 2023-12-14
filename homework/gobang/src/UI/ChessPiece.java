package src.UI;

import java.awt.*;

public class ChessPiece {
    private int row;
    private int column;
    private Color color;

    public ChessPiece(int row, int column, Color color) {
        this.row = row;
        this.column = column;
        this.color = color;
    }

    public void draw(Graphics g, int cellSize) {
        int x = column * cellSize - cellSize/2;
        int y = row * cellSize - cellSize/2;

        g.setColor(color);
        g.fillOval(x, y, cellSize, cellSize);
    }
}
