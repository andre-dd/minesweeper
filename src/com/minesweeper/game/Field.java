package com.minesweeper.game;

public class Field {
    private boolean isBomb;
    private boolean isRevealed;
    private int neighborBombs;
    private boolean marked;

    /**
     * @param isBomb boolean
     */
    Field(boolean isBomb) {
        this.isBomb = isBomb;
        this.isRevealed = false;
        this.neighborBombs = 0;
        this.marked = false;
    }

    /**
     * @return boolean
     */
    public boolean isBomb() {
        return isBomb;
    }

    /**
     * @param bomb boolean
     */
    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    /**
     * @return boolean
     */
    public boolean isRevealed() {
        return isRevealed;
    }

    /**
     * @param revealed boolean
     */
    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    /**
     * @return int
     */
    public int getNeighborBombs() {
        return neighborBombs;
    }

    /**
     * @param neighborBombs int
     */
    public void setNeighborBombs(int neighborBombs) {
        this.neighborBombs = neighborBombs;
    }

    /**
     * @return boolean
     */
    public boolean isMarked() {
        return marked;
    }

    /**
     * @param marked boolean
     */
    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
