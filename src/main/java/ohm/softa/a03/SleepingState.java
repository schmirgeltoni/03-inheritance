package ohm.softa.a03;

public class SleepingState extends State {

    public SleepingState(int duration) {
        super(duration);
    }

    /**
     * @return new {@link HungryState}
     */
    @Override
    State successor(Cat cat) {
        logStateTransition(cat, "HungryState");
        // here we need awakeTime in case cat gets fed in HungryState
        return new HungryState(cat.getAwakeTime());
    }
}
