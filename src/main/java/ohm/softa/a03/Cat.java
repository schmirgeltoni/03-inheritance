package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cat {

    private static final Logger logger = LogManager.getLogger();

    // state durations (set via constructor), i.e. the number of ticks in each state
    private final int sleepTime;
    private final int awakeTime;
    private final int digestTime;

    private State currentState;

    private final String name;

    public Cat(String name, int sleep, int awake, int digest) {
        this.name = name;
        this.sleepTime = sleep;
        this.awakeTime = awake;
        this.digestTime = digest;
        currentState = new SleepingState(getSleepTime());
    }

    public void tick() {
        this.currentState = currentState.tick(this);
    }

    /**
     * This would be a user interaction: feed the cat to change its state!
     */
    public void feed() {
        if (!isHungry())
            throw new IllegalStateException("Can't stuff a cat...");

        logger.info("You feed the cat...");
        this.currentState = ((HungryState) currentState).feed(this);
    }

    public boolean isAsleep() {
        return currentState instanceof SleepingState;
    }

    public boolean isPlayful() {
        return currentState instanceof PlayfulState;
    }

    public boolean isHungry() {
        return currentState instanceof HungryState;
    }

    public boolean isDigesting() {
        return currentState instanceof DigestingState;
    }

    public boolean isDead() {
        return currentState instanceof DeathState;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public int getAwakeTime() {
        return awakeTime;
    }

    public int getDigestTime() {
        return digestTime;
    }

    public String getName() {
        return name;
    }

}
