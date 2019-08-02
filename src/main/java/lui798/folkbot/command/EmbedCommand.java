package lui798.folkbot.command;

import lui798.folkbot.command.util.CommandResult;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmbedCommand extends Command {

    private final Logger LOG = LoggerFactory.getLogger(EmbedCommand.class);

    public EmbedCommand() {
        setName("embed");
        setPerms(Arrays.asList(Permission.MESSAGE_WRITE, Permission.MESSAGE_MANAGE));
    }

    @Override
    public CommandResult run(Message message, List<String> arguments) {
        EmbedBuilder builder = new EmbedBuilder();
        List<String> lines = new ArrayList<>(parseInput(message.getContentRaw()));
        
        for (String line : lines) {
            List<String> parts = new ArrayList<>(parseLine(line));
            LOG.info("LINE : " + line);
            for (String part : parts) {
                LOG.info("PART : " + part);
            }
        }

        return null;
    }

    private List<String> parseInput(String message) {
        return Arrays.asList(message.split("\\s*\\n\\s*"));
    }

    private List<String> parseLine(String input) {
        return Arrays.asList(input.split("\"\\s*,\\s*\""));
    }
}
