package cz.kyngs.widemaker.cli;

import cz.kyngs.logger.LogBuilder;
import cz.kyngs.logger.Logger;
import cz.kyngs.logger.command.CommandHandler;
import cz.kyngs.logger.command.LogCommandHandler;
import cz.kyngs.widemaker.cli.commands.AboutCommand;
import cz.kyngs.widemaker.cli.commands.HelpCommand;
import cz.kyngs.widemaker.cli.commands.WideImgCommand;

public class CLI {

    public static final Logger LOGGER;

    static {
        LOGGER = new LogBuilder()
                .setConsolePrefix("WideMaker Console > ")
                .build();
    }

    public static void main(String[] args) {
        new CLI();
    }

    private final CommandHandler commandHandler;

    public CLI(){

        LOGGER.info("Welcome to CLI WideMaker!");
        LOGGER.info("Type \"help\" for help!");

        commandHandler = new LogCommandHandler(LOGGER);

        commandHandler.onUnknownCommandFoundAction((commandSender) -> commandSender.sendMessage("Unknown command! Are you lost? You may want to try the \"help\" command!"));

        commandHandler.register("help", new HelpCommand());
        commandHandler.register("about", new AboutCommand());
        commandHandler.register("img", new WideImgCommand());


    }


}
