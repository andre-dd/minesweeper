package com.minesweeper.render;

import com.minesweeper.game.Board;
import com.minesweeper.game.Field;

import java.awt.*;

public class BoardRenderer {
    private Board board;

    public BoardRenderer(Board board) {
        this.board = board;
    }

    /**
     * @param g Graphics
     * @param cellSize int
     */
    public void draw(Graphics g, int boarderSize, int cellSize) {
        Field[][] fields = board.getFields();

        int x = boarderSize, y = boarderSize;
        g.setColor(new Color(48, 48, 48));
        g.fillRect(x, y, cellSize * board.getColumns(), cellSize * board.getRows());

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                Field field = fields[i][j];

                if (!field.isRevealed()) {
                    g.setColor(Color.WHITE);
                    g.drawRect(x, y, cellSize, cellSize);
                }

                if (field.isRevealed() && !field.isBomb()) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x, y, cellSize, cellSize);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, cellSize, cellSize);
                    g.drawString(String.format("%s", field.getNeighborBombs()), x + 10, y + 20);
                }

                if (field.isRevealed() && field.isBomb()) {
                    g.setColor(Color.RED);
                    g.fillRect(x, y, cellSize, cellSize);
                }

                if (field.isMarked() && !field.isRevealed()) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(x, y, cellSize, cellSize);
                }

                x += cellSize;
            }
            x = boarderSize;
            y += cellSize;
        }
    }
}
