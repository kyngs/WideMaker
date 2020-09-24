package cz.kyngs.widemaker.cli.commands;

import cz.kyngs.logger.command.CommandExecutor;
import cz.kyngs.logger.command.CommandSender;
import cz.kyngs.widemaker.core.WideCore;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class WideImgCommand implements CommandExecutor {
    @Override
    public void exec(String[] strings, CommandSender commandSender) {
        if (strings.length != 2){
            commandSender.sendMessage("Incorrect usage! Correct usage: img <source_img_name> <target_img_name>");
            return;
        }

        File source = new File(strings[0]);

        if (!source.exists()){
            commandSender.sendMessage("Source file does not exist!");
            return;
        }

        commandSender.sendMessage("Converting!");

        Instant start = Instant.now();

        try {
            WideCore.wideImgFromFileToFile(source, new File(strings[1]));
        } catch (IOException e) {
            commandSender.sendMessage(String.format("Error occured while attempting to wide image! %s", e.getMessage()));
            return;
        }

        Instant end = Instant.now();

        commandSender.sendMessage(String.format("Completed and saved in %d seconds!", Duration.between(start, end).getSeconds()));

    }
}
