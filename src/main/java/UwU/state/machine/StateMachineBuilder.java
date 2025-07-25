package uwu.state.machine;

import uwu.state.machine.base.StateMachine;
import uwu.state.machine.bean.StateActionKey;

import java.util.HashMap;
import java.util.Map;

public class StateMachineBuilder<State, Action> {
    private StateMachine<State, Action> abstractStateMachine;

    public enum StateMachineType {
        Base,
    }

    private final Map<StateActionKey<State, Action>, State> transitions = new HashMap<>();

    private StateMachineBuilder() {
    }

    public static <State, Action> StateMachineBuilder<State, Action> builder() {
        return new StateMachineBuilder<State, Action>();
    }

    public StateMachine<State, Action> build(StateMachineType type) {
        return switch (type) {
            case Base -> new BaseStateMachine<>(transitions);
        };
    }

    public StateMachineBuilder<State, Action> addTransition(State from, Action action, State to) {
        transitions.put(new StateActionKey<>(from, action), to);
        return this;
    }

}