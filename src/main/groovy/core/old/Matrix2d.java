package core.old;

import java.lang.reflect.Array;

/**
 * Created by anonymous on 29.10.2018.
 * states for porcessing and storing temporal data about activity element
 * true = Active, selected, processed
 * false = not active, not selected, not processed
 * null = processed, no element, no need to onProcess, excluded from processing
 */
public class Matrix2d<T> {
    private Class<T> elementClass;
    protected T[][] values;
    public int sizeX;
    public int sizeY;

    /**
     * create empty class with values = null
     */
    public Matrix2d(Class<T> clazz) {
        this.sizeX = 1;
        this.sizeY = 1;
        elementClass = clazz;
        this.values = (T[][]) Array.newInstance(clazz, this.sizeY, this.sizeX);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }

    /**
     * create Matrix2d with all values equal null
     * @param clazz
     * @param xSize
     * @param ySize
     */
    public Matrix2d(Class<T> clazz, int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        elementClass = clazz;
        this.values = (T[][]) Array.newInstance(clazz, ySize, xSize);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }

    /**
     * set all elements as single instance of defaultValue
     * @param clazz
     * @param xSize
     * @param ySize
     * @param defaultValue
     */
    public Matrix2d(Class<T> clazz, int xSize, int ySize, T defaultValue) {
        elementClass = clazz;
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.values = (T[][]) Array.newInstance(clazz, ySize, xSize);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, defaultValue);
            }
        }
    }

    /**
     * setBufferedImage into Matrix2d
     * @param xPos
     * @param yPos
     * @param value
     */
    public void setValue(int xPos, int yPos, T value) {
        if (xPos >= 0 && xPos < this.sizeX && yPos >= 0 && yPos < this.sizeY) {
            this.values[yPos][xPos] = value;
        }
    }

    /**
     * getValue from Matrix2d
     * @param xPos
     * @param yPos
     * @return
     */
    public T getValue(int xPos, int yPos) {
        if (xPos >= 0 && xPos < this.sizeX && yPos >= 0 && yPos < this.sizeY) {
            return this.values[yPos][xPos];
        }
        return null;
    }

    /**
     * set new size of Matrix2d, all data will be rewritten with "null" value
     * @param xSize
     * @param ySize
     */
    public void setSizeXY(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.values = (T[][]) Array.newInstance(this.elementClass, ySize, xSize);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }

}