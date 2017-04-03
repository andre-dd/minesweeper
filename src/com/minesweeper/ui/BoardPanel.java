package com.minesweeper.ui;

import com.minesweeper.render.BoardRenderer;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private int border;
    private int fieldSize;
    private int borderSize;
    private BoardRenderer boardRenderer;

    /**
     * Constructor
     */
    BoardPanel(BoardRenderer boardRenderer, int border, int fieldSize) {
        this.boardRenderer = boardRenderer;
        this.fieldSize = fieldSize;
        this.border = border;
        this.borderSize = border * fieldSize;

        setFont(new Font("Dialog", Font.PLAIN, 16));
    }

    /**
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        boardRenderer.draw(g, borderSize, fieldSize);
    }

    /**
     * @return int
     */
    int getBorderSize() {
        return border;
    }

    /**
     * @return int
     */
    int getFieldSize() {
        return fieldSize;
    }
}
