package com.AI.problems;

import com.AI.optimizationModel.Model;
import com.AI.optimizationModel.State;

import java.util.ArrayList;

/**
 * Created by Kasra on 11/06/2018.
 */
public class Third extends Model {

    private int populationNumber;
    private ThirdState[] population;

    public Third(int pn) {
        populationNumber = pn;


    }

    @Override
    public State setInitialState() {
        return null;
    }

    @Override
    public boolean isGoalState(State s) {
        return false;
    }

    @Override
    public ArrayList<State> actions(State s) {
        return null;
    }

    @Override
    public int calValue(State state) {
        ThirdState state1 = (ThirdState) state;
        int value;
        int num = 0;
        for (int i = 0; i < 13; ++i) {
            if (state1.leftKeys[i] == 'E' || state1.leftKeys[i] == 'T' || state1.leftKeys[i] == 'A') {
                ++num;
            } else if (state1.leftKeys[i] == 'I' || state1.leftKeys[i] == 'N' || state1.leftKeys[i] == 'O') {
                ++num;
            } else if (state1.leftKeys[i] == 'S' || state1.leftKeys[i] == 'H' || state1.leftKeys[i] == 'R') {
                ++num;
            }
        }
        if (5 - Math.abs(num - 5) > 5 - Math.abs(num - 4)) {
            value = 5 - Math.abs(num - 5);
        }else {
            value = 5 - Math.abs(num - 4);
        }
        for (int i = 0; i < 13; ++i) {
            if (state1.leftKeys[i] == 'T' || state1.leftKeys[i] == 'H') {
                for (int j = 0; j < 13; ++j) {
                    if (state1.rightKeys[j] == 'T' || state1.rightKeys[j] == 'H') {
                        ++value;
                        break;
                    }
                }
            }
            if (state1.leftKeys[i] == 'E' || state1.leftKeys[i] == 'R') {
                for (int j = 0; j < 13; ++j) {
                    if (state1.rightKeys[j] == 'E' || state1.rightKeys[j] == 'R') {
                        ++value;
                        break;
                    }
                }
            }
            if (state1.leftKeys[i] == 'O' || state1.leftKeys[i] == 'N') {
                for (int j = 0; j < 13; ++j) {
                    if (state1.rightKeys[j] == 'O' || state1.rightKeys[j] == 'N') {
                        ++value;
                        break;
                    }
                }
            }
            if (state1.leftKeys[i] == 'A' || state1.leftKeys[i] == 'R') {
                for (int j = 0; j < 13; ++j) {
                    if (state1.rightKeys[j] == 'A' || state1.rightKeys[j] == 'R') {
                        ++value;
                        break;
                    }
                }
            }
            if (state1.leftKeys[i] == 'A' || state1.leftKeys[i] == 'N') {
                for (int j = 0; j < 13; ++j) {
                    if (state1.rightKeys[j] == 'A' || state1.rightKeys[j] == 'N') {
                        ++value;
                        break;
                    }
                }
            }
            if (state1.leftKeys[i] == 'R' || state1.leftKeys[i] == 'E') {
                for (int j = 0; j < 13; ++j) {
                    if (state1.rightKeys[j] == 'R' || state1.rightKeys[j] == 'E') {
                        ++value;
                        break;
                    }
                }
            }
            if (state1.leftKeys[i] == 'H' || state1.leftKeys[i] == 'E') {
                for (int j = 0; j < 13; ++j) {
                    if (state1.rightKeys[j] == 'H' || state1.rightKeys[j] == 'E') {
                        ++value;
                        break;
                    }
                }
            }
            if (state1.leftKeys[i] == 'I' || state1.leftKeys[i] == 'N') {
                for (int j = 0; j < 13; ++j) {
                    if (state1.rightKeys[j] == 'I' || state1.rightKeys[j] == 'N') {
                        ++value;
                        break;
                    }
                }
            }
        }
        return value;
    }
}
