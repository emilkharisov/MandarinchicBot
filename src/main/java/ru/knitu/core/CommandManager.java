package ru.knitu.core;

import ru.knitu.core.commands.*;

import java.util.HashSet;

public class CommandManager {
    private static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new Unknown("unknown"));
        commands.add(new Weather("weather"));
        commands.add(new ListOfCommands("команды"));
        commands.add(new Products("товары"));
        commands.add(new FeedBacks("отзывы"));
        commands.add(new Location("местоположение"));

    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
    public static void addCommand(Command command) { commands.add(command);}
}
