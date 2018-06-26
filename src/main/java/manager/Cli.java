package manager;

import java.util.logging.Level;

import java.util.logging.Logger;

import org.apache.commons.cli.*;

public class Cli {
    private static final Logger log = Logger.getLogger(Cli.class.getName());

    private String[] args = null;
    private Options options = new Options();

    public Cli(String[] args) {
        this.args = args;
        options.addOption("s", "suite", true, "suite run");
        options.addOption("d", "driver", true, "driver");
        options.addOption("t", "thread", true, "thread");
        options.addOption("l", "listener", true, "listener");
    }

    public void parse() {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
            if (cmd.hasOption("driver"))
                ProjectProperties.getProperties().setProperty("browser", cmd.getOptionValue("driver"));
            if (cmd.hasOption("thread"))
                ProjectProperties.getProperties().setProperty("thread", cmd.getOptionValue("thread"));
            } catch (ParseException e) {
            log.log(Level.SEVERE, "Failed to parse command line properties", e);
        }
    }
}
