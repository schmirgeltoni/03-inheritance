package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract public class State {
    protected Logger logger = LogManager.getLogger();
    private int time = 0;
    private final int duration;

    protected State(int duration){
        this.duration = duration;
    }

    /**
     * Advances time by one and checks if a state transition should
     * happen if {@link State#time} has exceeded {@link State#duration}.
     * @param cat The cat whose state should be checked.
     * @return The successor state according to the state machine
     * if enough time has elapsed. Otherwise, itself.
     */
    final State tick(Cat cat) {
        logger.info("tick({})", time);
        if (++time < duration){
            logger.info("{} is still in {}", cat.getName(), this.getClass().getSimpleName());
            return this;
        }
        else
            return successor(cat);
    }

    /**
     * Returns the successor state of the current one
     * according to the state machine logic once enough
     * time has elapsed.
     * @param cat Cat is needed to find out the duration
     * of the next {@link State}.
     * @return Successor {@link State}
     */
    abstract State successor(Cat cat);

    /**
     * @return Elapsed time of current state
     */
    int getTime() { return time; }

    /**
     * @return total duration of current state.
     */
    int getDuration() { return duration; }

    protected final void logStateTransition(Cat cat, String stateName) {
        logger.info("{} is going into {}", cat.getName(), stateName);
    }
}
