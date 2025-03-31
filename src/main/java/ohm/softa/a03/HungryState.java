package ohm.softa.a03;

public class HungryState extends State {
    public HungryState(int duration) {
        super(duration);
    }

    @Override
    State successor(Cat cat) {
        logStateTransition(cat, "DeathState");
        return new DeathState();
    }
    State feed (Cat cat){
        logStateTransition(cat, "DigestingState");
        return new DigestingState(cat.getDigest(), getDuration() - getTime());
    }
}
