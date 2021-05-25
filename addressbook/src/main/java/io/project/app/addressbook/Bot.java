package io.project.app.addressbook;

import io.project.app.addressbook.domain.Account;
import io.project.app.addressbook.domain.Address;
import io.project.app.addressbook.dto.AccountDTO;
import io.project.app.addressbook.dto.AddressDTO;
import io.project.app.addressbook.services.AccountService;
import io.project.app.addressbook.services.AddressService;
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

    @Autowired
    AddressService addressService;

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

        AccountDTO accountDTO = new AccountDTO();
        AddressDTO addressDTO = new AddressDTO();
        if (update.hasMessage()) {
            Message message = update.getMessage();

            String messageText = update.getMessage().getText();

            if (messageText.startsWith("/register")) {
                String[] separated = messageText.split(" ");
                accountDTO.setChatId(chat_id);
                accountDTO.setFirstname(separated[1]);
                accountDTO.setFirstname(separated[2]);
                Optional<Account> registeredAccount = accountService.createAccount(accountDTO);
                if (registeredAccount.isEmpty()) {
                    sendMsg("user with that chat id already exists, you should login instead", chat_id);
                } else {
                    sendMsg("You registered successfully", chat_id);
                }

            }

            if (messageText.startsWith("/login")) {
                String[] separated = messageText.split(" ");
                accountDTO.setChatId(chat_id);
                accountDTO.setFirstname(separated[1]);
                accountDTO.setFirstname(separated[2]);
                Optional<Account> loginedAccount = accountService.login(accountDTO);
                if (loginedAccount.isEmpty()) {
                    sendMsg("Didn't found user, register instead", chat_id);
                } else {
                    sendMsg("You logined successfully", chat_id);
                }

            }

            if (messageText.startsWith("/contact create")) {
                String[] separated = messageText.split(" ");
                addressDTO.setChatId(chat_id);

                addressDTO.setContactName(separated[2] + " " + separated[3]);
                addressDTO.setPhoneNumber(separated[4]);
                addressDTO.setZoomId(separated[5]);
                Optional<Address> savedAddress = addressService.createAddress(addressDTO);
                if (savedAddress.isEmpty()) {
                    sendMsg("Contact with phone number " + addressDTO.getPhoneNumber() + " already exists", chat_id);
                } else {
                    sendMsg("You've created contact with phone number " + addressDTO.getPhoneNumber(), chat_id);
                }

            }

            if (messageText.startsWith("/contact all")) {

                List<Address> addressList = addressService.findAll();
                if (addressList.isEmpty()) {
                    sendMsg("There aren't any contacts yet", chat_id);
                } else {
                    for (Address addressItem : addressList) {
                        sendMsg("Contact id: " + addressItem.getContactId() + "\n"
                                + "Contact name: " + addressItem.getContactName() + "\n"
                                + "Contact phone: " + addressItem.getPhoneNumber() + "\n"
                                + "Contact email: " + addressItem.getEmail()+ "\n"
                                + "Contact register date: " + addressItem.getRecordDate() + "\n", chat_id);

                    }

                }

            }

            if (messageText.startsWith("/contact update email")) {

                String[] separated = messageText.split(" ");

                addressDTO.setContactId(Long.parseLong(separated[3]));
                addressDTO.setEmail(separated[4]);

                Optional<Address> savedAddress = addressService.
                        updateEmail(addressDTO.getContactId(), addressDTO.getEmail());
                if (savedAddress.isEmpty()) {
                    sendMsg("Contact with contact id " + addressDTO.getContactId() + " not found", chat_id);
                } else {
                    sendMsg("You've updated contact with contact id " + addressDTO.getContactId(), chat_id);
                }

            }

        }

    }

    @SneakyThrows
    public synchronized void sendMsg(String s, long chat_id) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id + "");
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(null);
        execute(sendMessage);
    }

}
