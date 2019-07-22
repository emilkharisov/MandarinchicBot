package ru.knitu.core.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.knitu.core.Command;
import ru.knitu.vk.VkManager;

public class FeedBacks extends Command {
    public FeedBacks(String name) {
        super(name);
    }
    @Override
    public void exec(Message message) {
     new VkManager().sendMessage(getFeedBack(),message.getUserId());
    }

    private String getFeedBack() {
        String url = "https://vk.com/mandarinchic.djalil?w=app6326142_-35764439";
        return url;
    }
}
