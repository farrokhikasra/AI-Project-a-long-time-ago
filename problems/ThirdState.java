package com.AI.problems;

import com.AI.optimizationModel.State;

/**
 * Created by Kasra on 11/06/2018.
 */
public class ThirdState extends State {

    public char[] leftKeys;
    public char[] rightKeys;

    public ThirdState(char[] l, char[] r) {
        leftKeys = l;
        rightKeys = r;
    }

    @Override
    public boolean isEqual(State s) {
        ThirdState temp = (ThirdState) s;
        for (int i = 0; i < 13; ++i) {
            if (leftKeys[i] != temp.leftKeys[i]) {
                return false;
            }
            if (rightKeys[i] != temp.rightKeys[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {

        String str = new String();
        for (int i = 0; i < 5; ++i) {
            str += leftKeys[i] + " ";
        }
        for (int i = 0; i < 5; ++i) {
            str += rightKeys[i] + " ";
        }
        str += "\n";
        for (int i = 5; i < 9; ++i) {
            str += leftKeys[i] + " ";
        }
        for (int i = 5; i < 9; ++i) {
            str += rightKeys[i] + " ";
        }
        str += "\n";
        for (int i = 9; i < 14; ++i) {
            str += leftKeys[i] + " ";
        }
        for (int i = 9; i < 14; ++i) {
            str += rightKeys[i] + " ";
        }
        return str;
    }
}
