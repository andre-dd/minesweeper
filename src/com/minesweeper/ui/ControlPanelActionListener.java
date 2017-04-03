package com.minesweeper.ui;

import com.minesweeper.game.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanelActionListener implements ActionListener {
    enum Actions {
        RESET
    }

    private Window window;
    private ControlPanelMediator controlPanelMediator;
    private Board board;

    public ControlPanelActionListener(Window window, ControlPanelMediator controlPanelMediator, Board board) {
        this.window = window;
        this.controlPanelMediator = controlPanelMediator;
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(Actions.RESET.name())) {
            controlPanelMediator.updateGameResult("Game in progress.");
            board.reset();
            window.repaint();
        }
    }
}
