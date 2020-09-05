package com.AI.optimizationModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kasra on 11/06/2018.
 */
public class SimulatedAnnealing {

    private int expanded;
    private double coolRate = 0.0005;
    private double temp;

    State SA(Model model, int kind) {
        State initial = model.setInitialState();
        State best = initial;
        initial.setViewed(true);
        expanded = 0;
        temp = 1000000;
        State next;
        next = initial;
        while (temp > 1) {
            System.out.println(next);
            System.out.println(best);
            ++expanded;
            if (model.isGoalState(next)) {
                return next;
            } else if (model.calValue(best) < model.calValue(next)) {
                best = next;
            }
            ArrayList<State> action = model.actions(next);
            State state;
            Random rand = new Random();
            do {
                int index = rand.nextInt(action.size());
                state = action.get(index);
            } while (state.isViewed());
            boolean flag = false;
            if (model.calValue(state) > model.calValue(next)) {
                next = state;
                flag = true;
            } else if (Math.exp(model.calValue(state) - (model.calValue(next)) / temp) > rand.nextDouble()) {
                next = state;
                state.setViewed(true);
                flag = true;
            }
            if (kind == 0 && flag) {
                temp *= 1 - coolRate;
            } else if (kind == 1 && flag) {
                temp -= rand.nextDouble() * coolRate;
            } else if (kind == 2 && flag) {
                temp -= coolRate;
            }
        }
        return best;
    }

    public State expSA(Model model) {
        return SA(model, 0);
    }

    public State linearSA(Model model) {
        return SA(model, 2);
    }

    public State randomSA(Model model) {
        return SA(model, 1);
    }


}
