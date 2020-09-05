package com.AI.problems;

import com.AI.optimizationModel.State;

/**
 * Created by Kasra on 10/06/2018.
 */
public class SecondState extends State {

    public int height, width;
    public char[][] table;

    public SecondState(int h, int w, char[][] t) {
        height = h;
        width = w;
        table = t;
    }

    @Override
    public boolean isEqual(State s) {
        SecondState ss = (SecondState) s;
        if (ss.height != height || ss.width != width) {
            return false;
        }
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (table[i][j] != ss.table[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String str = new String();
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                str += table[i][j] + " ";
            }
            str +="\n";
        }
        return str;
    }
}
