package com.minesweeper.ui;

import com.minesweeper.game.Board;
import com.minesweeper.render.BoardRenderer;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private Board board;

    /**
     * @param board Board
     */
    public Window(Board board, int width, int height, int boarder, int cellSize) {
        super("Minesweeper");

        this.board = board;

        ControlPanelMediator controlPanelMediator = new ControlPanelMediator();
        ControlPanelActionListener controlPanelActionListener =
                new ControlPanelActionListener(this, controlPanelMediator, board);
        ControlPanel controlPanel =
                new ControlPanel(controlPanelMediator, controlPanelActionListener);

        BoardPanel boardPanel = new BoardPanel(new BoardRenderer(board), boarder, cellSize);
        boardPanel.addMouseListener(new BoardPanelMouseListener(boardPanel, controlPanelMediator, board));

        add(BorderLayout.CENTER, boardPanel);
        add(BorderLayout.SOUTH, controlPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationByPlatform(true);
        setResizable(false);
        setVisible(true);
    }
}
