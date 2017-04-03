package com.minesweeper.ui;

import javax.swing.*;

class ControlPanel extends JPanel {
    /**
     *
     * @param controlPanelMediator ControlPanelMediator
     * @param controlPanelActionListener ControlPanelActionListener
     */
    ControlPanel(ControlPanelMediator controlPanelMediator, ControlPanelActionListener controlPanelActionListener) {
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(controlPanelActionListener);
        resetButton.setActionCommand(ControlPanelActionListener.Actions.RESET.name());

        JLabel gameResult = new JLabel("Game in progress.");
        controlPanelMediator.registerGameResultLabel(gameResult);

        add(resetButton);
        add(gameResult);
    }
}
