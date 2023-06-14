package model.sender;

import model.sesssion.StateSession;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import model.mediator.Mediator;


public abstract class Sender {
    protected StateSession stateSession;
    protected final Mediator mediator;

    public Sender(Mediator mediator) {
        this.mediator = mediator;
    }

    /** Получить сообщение */
    public abstract void onMessageReceived(String message);

    /** Отправить сообщение */
    public abstract SendMessage createSendMessage();
}
