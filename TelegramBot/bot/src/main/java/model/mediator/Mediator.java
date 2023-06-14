package model.mediator;

import model.sender.Sender;

public interface Mediator {
    void notify(Sender sender, String message);
}