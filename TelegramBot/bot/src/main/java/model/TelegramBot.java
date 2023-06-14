package model;

import model.command.Command;
import model.command.StartCommand;
import model.mediator.BotMediator;
import model.sender.Sender;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


import java.util.HashMap;

public class TelegramBot extends TelegramLongPollingBot {
    final private String BOT_TOKEN = "6047852249:AAFh4IgwW18hh6iwjzJUlF1Hq5_ClyYRjUY";

    final private String BOT_NAME = "Telegatask16_Bot";
    private final BotMediator botMediator;
    private final HashMap<String, Command> commandMap = new HashMap<>();

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    public TelegramBot() {
        botMediator = new BotMediator();
        commandMap.put("/start", new StartCommand(botMediator));
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message inMsg = update.getMessage();
            String text = inMsg.getText();
            Long chatID = inMsg.getChatId();
            SendMessage sendMsg = new SendMessage();

            // Определение текущего режима бота
            if (text.startsWith("/")) {
                Command currentCommand = commandMap.get(text);
                if (currentCommand != null) {
                    Sender stateSession = currentCommand.execute(sendMsg);
                    botMediator.addUserChat(chatID, stateSession);
                    sendMsg = stateSession.createSendMessage();
                } else {sendMsg.setText("Ошибочная команда!");}
            } else {
                Sender stateSession = botMediator.getUserChat(chatID);
                if(stateSession != null){
                    botMediator.notify(stateSession, text);
                    sendMsg = stateSession.createSendMessage();
                } else {sendMsg.setText("Выберите команду!");}
            }
            sendMsg.setChatId(chatID.toString());
            try {
                execute(sendMsg);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        try
        {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
        }
        catch(TelegramApiException e)
        {
            e.printStackTrace();    }
    }



}

