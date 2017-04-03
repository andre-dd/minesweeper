package com.minesweeper.ui;

import com.minesweeper.game.Board;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardPanelMouseListener implements MouseListener {
    private BoardPanel boardPanel;
    private ControlPanelMediator controlPanelMediator;
    private Board board;

    /**
     * @param board Board
     */
    BoardPanelMouseListener(BoardPanel boardPanel, ControlPanelMediator controlPanelMediator, Board board) {
        this.boardPanel = boardPanel;
        this.controlPanelMediator = controlPanelMediator;
        this.board = board;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int column = this.transformRow(e.getX());
        int row = this.transformColumn(e.getY());

        if (column < 0 || column >= board.getColumns() || row < 0 || row >= board.getRows()) {
            return;
        }

        if (MouseEvent.BUTTON3 == e.getButton()) {
            board.toggleFieldMarked(row, column);
            boardPanel.repaint();
            return;
        }

        if (board.isMarkedField(row, column)) {
            return;
        }

        board.revealField(row, column);

        if (board.isBombField(row, column)) {
            controlPanelMediator.updateGameResult("Game lost!");
        }

        if (board.areOnlyBombsLeftOnBoard()) {
            controlPanelMediator.updateGameResult("Game won!");
        }

        boardPanel.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * @param x int
     *
     * @return int
     */
    private int transformRow(int x) {
        return x / boardPanel.getFieldSize() - boardPanel.getBorderSize();
    }

    /**
     * @param y int
     *
     * @return int
     */
    private int transformColumn(int y) {
        return y / boardPanel.getFieldSize() - boardPanel.getBorderSize();
    }

}
