package model.sesssion;

import model.Start;

public class StartSession implements StateSession {
    State stateSession;
    Start start;

    public StartSession() {
        stateSession = State.INIT;
        start = new Start();
    }

    @Override
    public String action() {
        stateSession = State.ACTION;
        return start.action();
    }

    @Override
    public void calculate(String answer) {
        if (stateSession == State.ACTION){
            stateSession = State.CHECK;
            start.calculate(answer);
            stateSession = State.END;
        }
    }

    @Override
    public String end() {
        if (stateSession == State.END) {
            return start.end();
        }
        return "Calculation end.";
    }

    @Override
    public State getState() {
        return stateSession;
    }
}
