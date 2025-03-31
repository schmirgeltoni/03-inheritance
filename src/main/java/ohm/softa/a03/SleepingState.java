package ohm.softa.a03;

public class SleepingState extends State {

    public SleepingState(int duration) {
        super(duration);
    }

    @Override
    State successor(Cat cat) {
        logStateTransition(cat, "HungryState");
        return new HungryState(cat.getAwake());
    }
}
