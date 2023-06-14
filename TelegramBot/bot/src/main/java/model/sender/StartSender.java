package model.sender;

import model.sesssion.StartSession;
import model.sesssion.StateSession;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import model.mediator.Mediator;


public class StartSender extends Sender{
    public StartSender(Mediator mediator) {
        super(mediator);
        stateSession = new StartSession();
    }
    @Override
    public void onMessageReceived(String message) {
        stateSession.calculate(message);
    }

    @Override
    public SendMessage createSendMessage() {
        SendMessage sendMsg = new SendMessage();

        if (stateSession.getState() == StateSession.State.ACTION ||
                stateSession.getState() == StateSession.State.INIT) {
            String str = stateSession.action();
            sendMsg.setText(str);
        }
        else { sendMsg.setText("" + stateSession.end()); }
        return sendMsg;
    }
}
