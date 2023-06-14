package model.sesssion;

public interface StateSession {
    enum State {INIT, ACTION, CHECK, END};
    public String action();
    public void calculate(String answer);
    public String end();
    public State getState();
}
