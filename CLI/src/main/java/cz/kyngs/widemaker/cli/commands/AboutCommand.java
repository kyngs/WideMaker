package cz.kyngs.widemaker.cli.commands;

import cz.kyngs.logger.command.CommandExecutionResult;
import cz.kyngs.logger.command.CommandExecutor;
import cz.kyngs.logger.command.CommandSender;

public class AboutCommand implements CommandExecutor {
    @Override
    public void exec(String[] strings, CommandSender commandSender) {
        commandSender.sendMessage("WideMaker CLI - Version 1.0");
        commandSender.sendMessage("Created by: kyngs.");
    }
}
