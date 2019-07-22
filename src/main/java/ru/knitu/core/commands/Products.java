package ru.knitu.core.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.knitu.core.Command;
import ru.knitu.vk.VkManager;

public class Products extends Command {
    public Products(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VkManager().sendMessage(getProducts(), message.getUserId());
    }

    private String getProducts() {
        String url = "https://vk.com/market-35764439";
        return  url;
    }
}
