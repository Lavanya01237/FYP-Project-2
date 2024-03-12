package cz4046.main;

import cz4046.classes.PolicyIteration;
import cz4046.classes.UtilityAndAction;
import cz4046.classes.ValueIteration;
import cz4046.methods.WriteToFile;
import cz4046.maze.Maze;
import cz4046.maze.MazeState;

import static cz4046.main.Config.*;
import static cz4046.methods.DisplayManager.*;

/**
 * (Part 2)
 * ComplicatedMazeEnvScale class is executable file to run the Complicated Maze
 * Environment which is increasing the scale of the environment
 */
public class ComplicatedMazeThree {

    public static int scale = 2;
    public static boolean complicated = false;

    public static void main(String[] args) {

        // complicated = false - means that the maze environment created will be the
        // maze that is defined in the assignment document
        // 0 - means it will just use the original coordinates for each states
        // (PENALTY,REWARD,WALL,EMPTY,START)
        // Since scale is increased from 1 to 2, the coordinates of the state will be
        // multiplied hence, the number of states will increase
        Maze map = new Maze(NUM_ROWS, NUM_COLS, scale, complicated, 0);
        map.showMazeWorld();

        MazeState[][] mapObject = map.getMazeMap();

        // VALUE ITERATION
        ValueIteration valueIteration = new ValueIteration(map, EPSILON, DISCOUNT);

        System.out.println("========================");
        System.out.println("Value Iteration");
        System.out.println("========================");
        System.out.println("Discount: " + DISCOUNT);
        System.out.println("Maximum Reward Value : " + MAX_REWARD);
        System.out.println("Constant(c): " + C);
        System.out.println("Epsilon(c*Rmax): " + EPSILON);
        System.out.println("No of Iterations: " + valueIteration.getNumOfIterations());
        System.out.println("Convergence Criteria: " + valueIteration.getConvergenceCriteria());

        UtilityAndAction[][] OP_valueIteration = valueIteration.getOptimalPolicy();

        showActionsInGrid(OP_valueIteration);
        showUtilities(mapObject, OP_valueIteration);
        showUtilitiesInGrid(OP_valueIteration);

        // Output to csv file to plot utility estimates as a function of iteration
        WriteToFile.writeToFile(valueIteration.getUtilityEstimates(), scale, "results/",
                "part2_scale_value_iteration_utility_estimates");

        // POLICY ITERATION
        PolicyIteration policyIteration = new PolicyIteration(map, DISCOUNT, K);

        System.out.println("========================");
        System.out.println("Policy Iteration");
        System.out.println("========================");
        System.out.println("Discount: " + DISCOUNT);
        System.out.println("Maximum Reward Value: " + MAX_REWARD);
        System.out.println("Constant(c): " + C);
        System.out.println("No of times Simplified bellman update is executed: " + K);
        System.out.println("No of Iterations: " + policyIteration.getNoOfIterations());

        UtilityAndAction[][] OP_policyIteration = policyIteration.getOptimalPolicy();

        showActionsInGrid(OP_policyIteration);

        showUtilities(mapObject, OP_policyIteration);
        showUtilitiesInGrid(OP_policyIteration);

        // Output to csv file to plot utility estimates as a function of iteration
        WriteToFile.writeToFile(policyIteration.getUtilityEstimates(), scale, "results/",
                "part2_scale_policy_iteration_utility_estimates");

    }
}