package com.minesweeper.game;

import java.util.Random;

public class Board {
    private int rows;
    private int columns;
    private Field[][] fields;
    private int[][] neighborFields = {
        {-1, -1}, {0, -1}, {1, -1},
        {-1,  0},          {1,  0},
        {-1,  1}, {0,  1}, {1,  1},
    };

    /**
     * @param rows int
     * @param columns int
     */
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.fields = new Field[rows][columns];

        init();
    }

    /**
     * @return int
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return int
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @return Field[][]
     */
    public Field[][] getFields() {
        return fields;
    }

    public void reset() {
        init();
    }

    /**
     *
     * @param row int
     * @param column int
     */
    public void revealField(int row, int column) {
        Field field = fields[row][column];

        field.setRevealed(true);

        if (field.isBomb()) {
            return;
        }

        if (0 == field.getNeighborBombs()) {
            revealAdjacentFields(row, column);
        }
    }

    /**
     * @return boolean
     */
    public boolean areOnlyBombsLeftOnBoard() {
        int bombCount = 0;
        int unRevealedFieldsCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!fields[i][j].isRevealed()) {
                    unRevealedFieldsCount++;
                }

                if (fields[i][j].isBomb()) {
                    bombCount++;
                }
            }
        }

        return bombCount == unRevealedFieldsCount;
    }

    /**
     * @param row int
     * @param column int
     *
     * @return boolean
     */
    public boolean isBombField(int row, int column) {
        return fields[row][column].isBomb();
    }

    /**
     * @param row int
     * @param column int
     *
     * @return boolean
     */
    public boolean isMarkedField(int row, int column) {
        return fields[row][column].isMarked();
    }

    /**
     * @param row int
     * @param column int
     */
    public void toggleFieldMarked(int row, int column) {
        Field field = fields[row][column];

        if (field.isMarked()) {
            fields[row][column].setMarked(false);
            return;
        }

        fields[row][column].setMarked(true);
    }

    private void init() {
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fields[i][j] = new Field(false);

                if (85 < random.nextInt(100)) {
                    fields[i][j].setBomb(true);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fields[i][j].setNeighborBombs(countNeighborBombs(i, j));
            }
        }
    }

    /**
     * @param row int
     * @param column int
     */
    private void revealAdjacentFields(int row, int column) {
        for (int[] neighborCell: neighborFields) {
            int x = row + neighborCell[0];
            int y = column + neighborCell[1];

            if (isOutOfBounds(x, y)) {
                continue;
            }

            Field field = fields[x][y];

            if (field.isRevealed()) {
                continue;
            }

            if (0 < field.getNeighborBombs() && !field.isRevealed()) {
                field.setRevealed(true);
                continue;
            }

            if (0 == field.getNeighborBombs() && !field.isRevealed()) {
                field.setRevealed(true);
                revealAdjacentFields(x, y);
            }
        }
    }

    /**
     * @param i int
     * @param j int
     *
     * @return int
     */
    private int countNeighborBombs(int i, int j) {
        int neighborBombCount = 0;

        for (int[] neighborCell: neighborFields) {
            int x = i + neighborCell[0];
            int y = j + neighborCell[1];

            if (isOutOfBounds(x, y)) {
                continue;
            }

            if (fields[x][y].isBomb()) {
                neighborBombCount++;
            }
        }

        return neighborBombCount;
    }

    /**
     * @param x int
     * @param y int
     *
     * @return boolean
     */
    private boolean isOutOfBounds(int x, int y) {
        return !(x >= 0 && x < rows && y >= 0 && y < columns);
    }
}
