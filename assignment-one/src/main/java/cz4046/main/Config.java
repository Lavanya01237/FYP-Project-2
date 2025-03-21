package cz4046.main;

/**
 * Config class is used to store the constants
 */
public class Config {

    public static final int NUM_COLS = 6;
    public static final int NUM_ROWS = 6;

    // public static final String START_POINT = "5,3";
    // public static final String REWARD_POINTS = "2,1;1,4";
    // public static final String PENALTY_POINTS =
    // "0,1;0,3;2,3;3,3;3,4;4,4;5,1;5,5";
    // public static final String WALLS_POINTS = "0,2;2,0;2,2;1,5;4,1";
    public static final String START_POINT = "3,2";
    public static final String REWARD_POINTS = "0,0;0,2;0,5;1,3;2,4;3,5";
    public static final String PENALTY_POINTS = "1,1;1,5;2,2;3,3;4,4";
    public static final String WALLS_POINTS = "0,1;1,4;4,1;4,2;4,3";

    // Reward functions
    public static final double E_REWARD = -0.050;
    public static final double R_REWARD = +1.000;
    public static final double P_REWARD = -1.000;
    public static final double W_REWARD = 0.000;

    /// Transition model

    // Intended outcome probability
    public static final double INTENDED_PROB = 0.800;

    // Clock-wise probability
    public static final double CW_PROB = 0.100;

    // Anti Clock-wise probability
    public static final double ACW_PROB = 0.100;
    // public static final double OPP_PROB = 0.000;

    // Discount factor
    public static final double DISCOUNT = 0.990;

    public static final double MAX_REWARD = 1.000;

    // Constant c
    public static final double C = 0.100;

    // Epsilon = c * Rmax
    public static final double EPSILON = C * MAX_REWARD;

    // Constant k (i.e. number of times simplified Bellman update is executed
    // to produce the next utility estimate)
    public static final int K = 30;
}