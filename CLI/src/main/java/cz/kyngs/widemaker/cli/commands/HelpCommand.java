package cz.kyngs.widemaker.cli.commands;

import cz.kyngs.logger.command.CommandExecutor;
import cz.kyngs.logger.command.CommandSender;

public class HelpCommand implements CommandExecutor {
    @Override
    public void exec(String[] strings, CommandSender commandSender) {
        commandSender.sendMessage("help - Shows this.");
        commandSender.sendMessage("about - Shows some information about this program.");

    }
}
