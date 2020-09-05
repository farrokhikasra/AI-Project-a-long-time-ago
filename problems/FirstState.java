package com.AI.problems;

import com.AI.optimizationModel.State;

/**
 * Created by Kasra on 09/06/2018.
 */
public class FirstState extends State {

    private int nodenumber;
    public int[] colornumber;

    public FirstState(int n) {
        nodenumber = n;
        colornumber = new int[nodenumber];
        for (int i = 0; i < nodenumber; ++i) {
            colornumber[i] = 0;
        }
    }

    public FirstState(int n, int[] c) {
        nodenumber = n;
        colornumber = new int[nodenumber];
        for (int i = 0; i < nodenumber; ++i) {
            colornumber[i] = c[i];
        }
    }

    @Override
    public boolean isEqual(State s) {
        FirstState state = (FirstState) s;
        if (nodenumber != state.nodenumber) {
            return false;
        }
        for (int i = 0; i < nodenumber; ++i) {
            if (colornumber[i] != state.colornumber[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String str = new String();
        for (int i = 0; i < nodenumber; ++i) {
            str += colornumber[i] + " ";
        }
        str += "\n";
        return str;
    }

    public int getNodenumber() {
        return nodenumber;
    }

}
