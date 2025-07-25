package uwu.state.machine.base;

import java.util.List;
import java.util.Optional;

public interface StateMachine<State, Action> {

    Optional<State> transfer(State state,Action action);

    List<Action> permit(State now);
}
