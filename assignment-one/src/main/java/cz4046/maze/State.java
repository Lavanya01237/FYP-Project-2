package cz4046.maze;

import static cz4046.methods.RepeatedFunctions.generateRandomInt;

/**
 * State class stores the states (penalty, empty, reward, wall, start)
 */
public enum State {
    START("S "),
    EMPTY("  "),
    PENALTY("--"),
    REWARD("+R"),
    // REWARD(new String(Character.toChars(0x221A))), // √
    WALL("X ");

    private String strRep;

    State(String strRep) {
        this.strRep = strRep;
    }

    @Override
    public String toString() {
        return this.strRep;
    }

    private static final State[] AVAILABLE_STATES = values();

}