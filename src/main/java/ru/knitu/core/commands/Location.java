package ru.knitu.core.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.knitu.core.Command;
import ru.knitu.vk.VkManager;

public class Location extends Command {
    public Location(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
     new VkManager().sendMessage(getLocation(),message.getUserId());
    }

    private String getLocation() {
        String url = "https://vk.com/mandarinchic.djalil?w=address-35764439";
        return url;
    }
}
