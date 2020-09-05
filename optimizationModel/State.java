package com.AI.optimizationModel;

/**
 * Created by Kasra on 09/06/2018.
 */
public abstract class State {
    protected boolean viewed;

    public State() {
        viewed = false;
    }

    public abstract boolean isEqual(State s);

    public abstract String toString();

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public boolean isViewed() {
        return viewed;
    }


}
