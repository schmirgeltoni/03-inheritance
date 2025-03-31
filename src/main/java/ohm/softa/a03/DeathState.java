package ohm.softa.a03;

public class DeathState extends State {
    public DeathState() {
        super(0);
    }

    @Override
    State successor(Cat cat) {
        logger.info("I may have nine lives, but I'm still dead");
        return this;
    }
}
