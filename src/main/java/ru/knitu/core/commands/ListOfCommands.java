package ru.knitu.core.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.knitu.core.Command;
import ru.knitu.vk.VkManager;

import java.util.ArrayList;
import java.util.List;


public class ListOfCommands extends Command {
    public ListOfCommands(String name) {
        super(name);
    }
    @Override
    public void exec(Message message) {
        String mes = getCommands_ofBot();
        new VkManager().sendMessage(mes, message.getUserId());
    }

    private String getCommands_ofBot() {
        List <String> commands = new ArrayList<String>();
        commands.add("weather");
        commands.add("товары");
        commands.add("отзывы");
        commands.add("местоположение");
        return commands.get(0) + "\n" + commands.get(1) +"\n" + commands.get(2) +"\n" + commands.get(3);
    }
}
