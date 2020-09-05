package com.AI.optimizationModel;

import java.util.ArrayList;

/**
 * Created by Kasra on 09/06/2018.
 */
public abstract class Model {

    public abstract State setInitialState();

    public abstract boolean isGoalState(State s);

    public abstract ArrayList<State> actions(State s);

    public abstract int calValue(State state);
}
