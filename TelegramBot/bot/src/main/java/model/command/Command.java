package model.command;



import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import model.sender.Sender;

public abstract class Command {
    public abstract Sender execute(SendMessage sendMsg);
}
