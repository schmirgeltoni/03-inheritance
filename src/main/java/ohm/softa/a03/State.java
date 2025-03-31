package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract public class State {
    Logger logger = LogManager.getLogger();
    private int time = 0;
    private final int duration;

    protected State(int duration){
        this.duration = duration;
    }

    final State tick(Cat cat) {
        logger.info("tick()");
        //time++;
        if (++time < duration){
            logger.info("{} is still in {}", cat.toString(), this.getClass().getSimpleName());
            return this;
        }
        else
            return successor(cat);
    }

    abstract State successor(Cat cat);

    int getTime() { return time; }
    int getDuration() { return duration; }

    protected final void logStateTransition(Cat cat, String stateName) {
        logger.info("{} is going into {}", cat.toString(), stateName);
    }
}
