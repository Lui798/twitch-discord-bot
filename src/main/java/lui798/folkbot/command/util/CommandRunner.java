package lui798.folkbot.command.util;

import lui798.folkbot.Bot;

public class CommandRunner {

    private String name;
    private RunnableC com;

    public CommandRunner(String name) {
        this.name = name;
    }

    public void setCom(RunnableC com) {
        this.com = com;
    }

    public String getName() {
        return name;
    }

    private String getArgument(String input) {
        String result;
        try {
            result = input.substring(input.indexOf(" "));
            result = input.substring(input.indexOf(" ")+1);
        }
        catch (StringIndexOutOfBoundsException e) {
            result = null;
        }
        return result;
    }

    public boolean equalsInput(String input) {
        if (getArgument(input) == null) {
            if (input.equals(Bot.prefix + name))
                return true;
        }
        else {
            if (input.substring(0, input.indexOf(" ")).equals(Bot.prefix + name))
                return true;
        }
        return false;
    }

    public void run(String input) {
        new Thread(() -> {
            if (getArgument(input) == null) {
                com.run();
            }
            else {
                com.run(getArgument(input));
            }
        }).start();
    }
}
