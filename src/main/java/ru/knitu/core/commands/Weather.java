package ru.knitu.core.commands;




import com.vk.api.sdk.objects.messages.Message;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.knitu.core.Command;
import ru.knitu.core.commands.Model;
import ru.knitu.vk.VkManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;


//f3f445ae98c306d06e5019aa15a9b788
public class Weather extends Command{
    public Weather(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        Model model = new Model();
        try {
            new VkManager().sendMessage(getWeather(model), message.getUserId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getWeather(Model model) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Dzhalil&units=metric&appid=f3f445ae98c306d06e5019aa15a9b788");
        Scanner in = new Scanner((InputStream) url.getContent());
        String result_1 = "";
        while (in.hasNext()) {
            result_1 += in.nextLine();
        }
        JSONObject jsonObject = new JSONObject(result_1);
        model.setName(jsonObject.getString("name"));
        JSONObject jsonObject1 = jsonObject.getJSONObject("main");
        model.setTemp(jsonObject1.getDouble("temp"));
        model.setHumidity(jsonObject1.getDouble("humidity"));

        JSONArray jsonArray = jsonObject.getJSONArray("weather");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            model.setIcon((String) jsonObject2.get("icon"));
            model.setMain((String) jsonObject2.get("main"));
        }
        return model.getName() + "\n" +
                "Температура - " + model.getTemp() + "\n" +
                "Влажность - " + model.getHumidity() + "\n" +
                "Осадки - " + model.getMain() + "\n" +
                "http://openweathermap.org/img/wn/" + model.getIcon() + "@2x.png";
    }
}
