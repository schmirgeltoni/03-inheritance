package ohm.softa.a03;

public class PlayfulState extends State {

    public PlayfulState(int duration) {
        super(duration);
    }

    /**
     * @return new {@link SleepingState}
     */
    @Override
    State successor(Cat cat) {
        logStateTransition(cat, "SleepingState");
        return new SleepingState(cat.getSleepTime());
    }
}
