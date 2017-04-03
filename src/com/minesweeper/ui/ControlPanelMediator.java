package com.minesweeper.ui;

import javax.swing.*;

public class ControlPanelMediator {
    private JLabel gameResultLabel;

    /**
     * @param gameResultLabel JLabel
     */
    public void registerGameResultLabel(JLabel gameResultLabel) {
        this.gameResultLabel = gameResultLabel;
    }

    /**
     * @param result String
     */
    public void updateGameResult(String result) {
        gameResultLabel.setText(result);
    }
}
