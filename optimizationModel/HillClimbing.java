package com.AI.optimizationModel;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by Kasra on 09/06/2018.
 */
public class HillClimbing {

    int expanded, seen;

    public int getExpanded() {
        return expanded;
    }

    public int getSeen() {
        return seen;
    }

    public State Simple(Model model) {
        State initial = model.setInitialState();
        State best = initial;
        initial.setViewed(true);
        expanded = 0;
        seen = 1;
        State next;
        next = initial;
        while (next != null) {
            ++expanded;
            if (model.isGoalState(next)) {
                return next;
            }
            boolean flag = false;
            ArrayList<State> action = model.actions(next);
            for (State temp : action) {
                if (!temp.isViewed()) {
                    if (model.calValue(temp) < model.calValue(next)) {
                        next = temp;
                        flag = true;
                    }
                    ++seen;
                }
                temp.setViewed(true);
            }
            if (model.calValue(best) > model.calValue(next)) {
                best = next;
            }
            if (flag == false) {
                return best;
            }
        }
        return best;
    }

    public State Stochastic(Model model) {
        State initial = model.setInitialState();
        State best = initial;
        initial.setViewed(true);
        expanded = 0;
        seen = 1;
        State next;
        next = initial;
        while (next != null) {
            ++expanded;
            if (model.isGoalState(next)) {
                return next;
            }
            boolean flag = false;
            ArrayList<State> action = model.actions(next);
            ArrayList<State> chosenact = new ArrayList<State>();
            for (State temp : action) {
                if (!temp.isViewed()) {
                    if (model.calValue(temp) < model.calValue(next)) {
                        chosenact.add(temp);
                        flag = true;
                    }
                    ++seen;
                }
                temp.setViewed(true);
            }
            Random rand = new Random();
            int randint = 0;
            if (chosenact.size() > 1) {
                randint = rand.nextInt(chosenact.size());
                next = chosenact.get(randint);
            } else if (chosenact.size() == 1) {
                next = chosenact.get(0);
            } else {
                return best;
            }
            if (model.calValue(best) > model.calValue(next)) {
                best = next;
            }
            if (flag == false) {
                return best;
            }
        }
        return best;
    }

    public State FirstChoice(Model model) {
        State initial = model.setInitialState();
        State best = initial;
        initial.setViewed(true);
        expanded = 0;
        seen = 1;
        State next;
        next = initial;
        while (next != null) {
            ++expanded;
            if (model.isGoalState(next)) {
                return next;
            }
            boolean flag = false;
            ArrayList<State> action = model.actions(next);
            for (State temp : action) {
                if (!temp.isViewed()) {
                    ++seen;
                    if (model.calValue(temp) < model.calValue(next)) {
                        next = temp;
                        flag = true;
                        break;
                    }
                }
                temp.setViewed(true);
            }
            if (model.calValue(best) > model.calValue(next)) {
                best = next;
            }
            if (flag == false) {
                return best;
            }
        }
        return best;
    }

    public State RandomRestart(Model model) {
        State initial = model.setInitialState();
        ArrayList<State> nextmove = new ArrayList<State>();
        State best = initial;
        initial.setViewed(true);
        expanded = 0;
        seen = 1;
        State next;
        next = initial;
        while (next != null) {
            ++expanded;
            if (model.isGoalState(next)) {
                return next;
            }
            ArrayList<State> action = model.actions(next);
            for (State ss : action) {
                if (!ss.isViewed() && model.calValue(ss) < model.calValue(next)) {
                    nextmove.add(ss);
                    ss.setViewed(true);
                    ++seen;
                }
            }
            State temp;
            do {
                Random rand = new Random();
                int randint = rand.nextInt(nextmove.size());
                temp = nextmove.get(randint);
                nextmove.remove(randint);
            } while (!temp.isViewed());
            next = temp;
            temp.setViewed(true);
            if (model.calValue(best) > model.calValue(next)) {
                best = next;
            }
            if (nextmove.isEmpty()) {
                return best;
            }
        }
        return best;
    }
}
