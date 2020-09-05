package com.AI.problems;

import com.AI.optimizationModel.Model;
import com.AI.optimizationModel.State;

import java.util.ArrayList;

/**
 * Created by Kasra on 10/06/2018.
 */
public class Second extends Model {

    private String[] words;
    private int height, width;
    private char[][] initial;

    public Second(int h, int wi, String[] wo, char[][] i) {
        height = h;
        width = wi;
        words = wo;
        initial = i;
    }

    @Override
    public State setInitialState() {
        State init = new SecondState(height, width, initial);
        return init;
    }

    @Override
    public boolean isGoalState(State s) {
        SecondState temp = (SecondState) s;
        return calValue(temp) == 0;
    }

    @Override
    public ArrayList<State> actions(State s) {
        ArrayList<State> action = new ArrayList<State>();
        SecondState state = (SecondState) s;
        for (int i = 0; i < state.height; ++i) {
            for (int j = 0; j < state.width; ++j) {
                for (int k = i; k < state.height; ++k) {
                    for (int l = j; l < state.width; ++l) {
                        char[][] temp = new char[state.height][state.width];
                        for (int i1 = 0; i1 < state.height; ++i1) {
                            for (int j1 = 0; j1 < state.width; ++j1) {
                                temp[i1][j1] = state.table[i1][j1];
                            }
                        }
                        char temp1 = temp[i][j];
                        temp[i][j] = temp[k][l];
                        temp[k][l] = temp1;
                        State tempstate = new SecondState(state.height, state.width, temp);
                        action.add(tempstate);
                    }
                }
            }
        }
        return action;
    }

    @Override
    public int calValue(State state) {
        SecondState temp = (SecondState) state;
        boolean[][] isviewed = new boolean[temp.height][temp.width];
        int value = words.length * 10;
        for (String s : words) {
            value += s.length();
        }
        for (String ss : words) {
            for (int i1 = 0; i1 < temp.height; ++i1) {
                for (int j1 = 0; j1 < temp.width; ++j1) {
                    isviewed[i1][j1] = false;
                }
            }
            int i = 0;
            int j = 0;
            boolean flag = false;
            for (; i < temp.height; ++i) {
                for (j = 0; j < temp.width; ++j) {
                    if (ss.charAt(0) == temp.table[i][j]) {
                        isviewed[i][j] = true;
                        flag = true;
                        --value;
                        break;
                    }
                }
                if (flag) break;
            }
            int k = 1;
            if (i == height || j == width) {
                continue;
            }
            do {
                if (i + 1 < temp.height && ss.charAt(k) == temp.table[i + 1][j]) {
                    i = i + 1;
                    isviewed[i][j] = true;
                    ++k;
                    --value;
                } else if (i - 1 >= 0 && ss.charAt(k) == temp.table[i - 1][j]) {
                    i = i - 1;
                    isviewed[i][j] = true;
                    ++k;
                    --value;
                } else if (j + 1 < temp.width && ss.charAt(k) == temp.table[i][j + 1]) {
                    j = j + 1;
                    isviewed[i][j] = true;
                    ++k;
                    --value;
                } else if (j - 1 >= 0 && ss.charAt(k) == temp.table[i][j - 1]) {
                    j = j - 1;
                    isviewed[i][j] = true;
                    ++k;
                    --value;
                } else {
                    break;
                }
            } while (k < ss.length());
            if (k >= ss.length()) {
                value -= 10;
            }
        }
        return value;
    }
}
