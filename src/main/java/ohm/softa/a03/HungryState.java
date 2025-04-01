package ohm.softa.a03;

public class HungryState extends State {
    public HungryState(int duration) {
        super(duration);
    }

    /**
     * Successor of {@link HungryState} is {@link DeathState}.
     * <p>
     * See {@link #feed(Cat)} if you want to keep the cat alive
     * @return new {@link DeathState}
     */
    @Override
    State successor(Cat cat) {
        logStateTransition(cat, "DeathState");
        return new DeathState();
    }

    /**
     * @return new {@link DigestingState}
     */
    State feed(Cat cat) {
        logStateTransition(cat, "DigestingState");
        return new DigestingState(cat.getDigestTime(), getDuration() - getTime());
    }
}
