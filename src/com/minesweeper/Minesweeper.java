package com.minesweeper;

import com.minesweeper.game.Board;
import com.minesweeper.ui.Window;

public class Minesweeper {
    /**
     * @param args String[]
     */
    public static void main(String[] args)  {
        int fieldSize = 30;
        int width = 360;
        int height = 425;
        int boarder = 1;
        int rows = 10;
        int columns = 10;

        new Window(new Board(rows, columns), width, height, boarder, fieldSize);
    }
}
