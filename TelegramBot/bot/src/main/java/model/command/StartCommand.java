package model.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import model.mediator.Mediator;
import model.sender.Sender;
import model.sender.StartSender;

public class StartCommand extends Command{
    private Mediator mediator;

    public StartCommand(Mediator mediator) {
        this.mediator = mediator;
    }
    @Override
    public Sender execute(SendMessage sendMsg) {
        Sender startSender = new StartSender(mediator);
        startSender.onMessageReceived(sendMsg.getText());
        return startSender;
    }
}
