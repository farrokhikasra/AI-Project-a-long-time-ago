package com.AI.problems;

import com.AI.optimizationModel.Model;
import com.AI.optimizationModel.State;

import java.util.ArrayList;

/**
 * Created by Kasra on 09/06/2018.
 */
public class First extends Model {
    private int[][] graph;
    private int nodenumber;
    private int color;

    public First(int n, int[][] graph, int color) {
        this.graph = graph;
        this.color = color;
        nodenumber = n;
    }

    @Override
    public State setInitialState() {
        FirstState state = new FirstState(nodenumber);
        return state;
    }

    @Override
    public boolean isGoalState(State s) {
        FirstState state = (FirstState) s;
        if (calValue(state) == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<State> actions(State s) {
        ArrayList<State> states = new ArrayList<State>();
        FirstState firstState = (FirstState) s;
        for (int k = 0; k < nodenumber; ++k) {
            for (int j = 0; j < color; ++j) {
                int[] temp = new int[nodenumber];
                for (int i = 0; i < nodenumber; ++i) {
                    temp[i] = firstState.colornumber[i];
                }
                temp[k] = j;
                State ss = new FirstState(nodenumber, temp);
                states.add(ss);
            }
        }
        return states;
    }

    @Override
    public int calValue(State state) {
        FirstState firstState = (FirstState) state;
        int value = 0;
        for (int i = 0; i < nodenumber; ++i) {
            for (int j = 0; j < nodenumber; ++j) {
                if (graph[i][j] == 1 && firstState.colornumber[i] == firstState.colornumber[j]) {
                    ++value;
                }
            }
        }
        return value;
    }
}
