package uwu.state.machine;

import uwu.state.machine.base.StateMachine;
import uwu.state.machine.bean.StateActionKey;

import java.util.*;

public class BaseStateMachine<State, Action> implements StateMachine<State, Action> {
    private final Map<StateActionKey<State, Action>, State> transitionFlow;
    private final Map<State, List<Action>> allowanceMap = new HashMap<>();

    protected BaseStateMachine(Map<StateActionKey<State, Action>, State> init) {
        transitionFlow = init;

        for (StateActionKey<State, Action> key : init.keySet())
            allowanceMap.computeIfAbsent(key.state(), k -> new ArrayList<>()).add(key.action());
    }

    @Override
    public Optional<State> transfer(State now, Action next) {
        return Optional.ofNullable(transitionFlow.get(new StateActionKey<>(now, next)));
    }

    @Override
    public List<Action> permit(State now) {
        return allowanceMap.getOrDefault(now, Collections.emptyList());
    }

}