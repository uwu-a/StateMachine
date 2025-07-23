package uwu.state.machine.impl;

import uwu.state.machine.base.StateMachine;
import uwu.state.machine.bean.DualKey;

import java.util.Map;
import java.util.Optional;

public class BaseStateMachine<State, Action> implements StateMachine<State, Action> {
    private final Map<DualKey<State, Action>, State> transitionFlow;

    protected BaseStateMachine(Map<DualKey<State, Action>, State> init) {
        transitionFlow = init;
    }

    @Override
    public Optional<State> transfer(State now, Action next) {
        return Optional.ofNullable(transitionFlow.get(new DualKey<>(now, next)));
    }
}
