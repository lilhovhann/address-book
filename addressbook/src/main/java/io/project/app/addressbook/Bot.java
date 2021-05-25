package io.project.app.addressbook;

import io.project.app.addressbook.domain.Account;
import io.project.app.addressbook.services.AccountService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author lilith
 */
@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    AccountService accountService;

    private static final Logger log = LoggerFactory.getLogger(Bot.class);

    public String getBotToken() {
        return "1757709513:AAH1v2ZwALWfemS-Cb6V5fsoPaNnBaQw6XY";
    }

    @Override
    public String getBotUsername() {
        return "optym_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        long chat_id = update.getMessage().getChatId();
        if (update.hasMessage()) {
            Message message = update.getMessage();

            String messageText = update.getMessage().getText();

            if (messageText.startsWith("/find")) {
                String[] separated = messageText.split(" ");
//                addressDTO.setChatId(chat_id);
//                addressDTO.setContactName(separated[2] + " " + separated[3]);
//                addressDTO.setPhoneNumber(Integer.parseInt(separated[5]));
//                addressDTO.setZoomId(Integer.parseInt(separated[6]));
//                String argument = "";
//                for (int i = 0; i < messageText.length(); i++) {
//                    if (i >= 9) {
//                        argument += messageText.charAt(i);
//                        System.out.println(argument);
//                    }
//                }
                List<Account> account = accountService.findAll();

                sendMsg("Accounts are " + account, chat_id);
//                argument = "";

            }

        }

    }

    @SneakyThrows
    public synchronized void sendMsg(String s, long chat_id) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id + "");
//        sendMessage.setText(s);
        sendMessage.setReplyMarkup(null);
        sendMessage.enableHtml(true);
        String text = "<b>Bold text</b>";
        sendMessage.setText(text);
        execute(sendMessage);
    }

    @PostConstruct
    public void start() {
        log.info("Bot has started. Let's have fun");
    }

}
