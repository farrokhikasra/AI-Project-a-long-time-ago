package com.AI;

import com.AI.optimizationModel.HillClimbing;
import com.AI.optimizationModel.SimulatedAnnealing;
import com.AI.optimizationModel.State;
import com.AI.problems.First;
import com.AI.problems.Second;
import com.AI.problems.SecondState;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //runFirst();
        //rusSecond();
        runThird();

    }

    public static void runThird() {



    }

    public static void rusSecond() {
//        int height, width;
//        System.out.println("Please enter height and width of the table:");
//        Scanner sc = new Scanner(System.in);
//        height = sc.nextInt();
//        width = sc.nextInt();
//        char[][] table = new char[height][width];
//        System.out.println("Please enter the initial table:");
//        for (int i = 0; i < height; ++i) {
//            for (int j = 0; j < width; ++j) {
//                table[i][j] = sc.next().charAt(0);
//            }
//        }
//        System.out.println("Please enter number of strings you want to add:");
//        int strnum = sc.nextInt();
//        String[] str = new String[strnum];
//        for (int i = 0; i < strnum; ++i) {
//            str[i] = sc.next();
//        }
//        Second ss = new Second(height, width, str, table);

        //Sample Question
        Second ss = new Second(4, 3, new String[]{"cool", "cat", "talk"}, new char[][]{{'a', 'p', 't'}, {'m', 'l', 'b'}, {'k', 'l', 'o'}, {'u', 'o', 'c'}});
        SimulatedAnnealing sa = new SimulatedAnnealing();
//        SecondState ss1 = new SecondState(4 , 3, new char[][]{{'c', 'o', 'o'}, {'a', 't', 'l'}, {'l', 'm', 'b'}, {'k', 'u', 'p'}});
//        System.out.println(ss.calValue(ss1));
        System.out.println(sa.expSA(ss).toString());
//        System.out.println(sa.randomSA(ss).toString());
//        System.out.println(sa.linearSA(ss).toString());
    }

    public static void runFirst() {
        int color, nodes;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number of nodes:");
        nodes = sc.nextInt();
        int[][] graph = new int[nodes][nodes];
        System.out.println("Please enter the graph:");
        for (int i = 0; i < nodes; ++i) {
            for (int j = 0; j < nodes; ++j) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println("Please enter color numbers:");
        color = sc.nextInt();
        First first = new First(nodes, graph, color);
        //Sample Question
//        First first = new First(6, new int[][]{{0, 1, 0, 0, 0, 1}, {1, 0, 1, 0, 0, 1}, {0, 1, 0, 1, 0, 1}, {0, 0, 1, 0, 1, 1}, {0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 0}}, 3);
//        First first = new First(4, new int[][]{{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}}, 2);
        HillClimbing hill = new HillClimbing();
        State ans = hill.Simple(first);
//        State ans = hill.Stochastic(first);
//        State ans = hill.FirstChoice(first);
//        State ans = hill.RandomRestart(first);
        System.out.println("Answer is: " + ans.toString());
        System.out.println("Number of errors in problem: " + first.calValue(ans));
        System.out.println("Expanded nodes: " + hill.getExpanded());
        System.out.println("Seen nodes: " + hill.getSeen());


    }
}
