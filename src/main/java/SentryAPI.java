import lombok.extern.log4j.Log4j2;
import org.apache.commons.cli.*;
import parser.ConfigParser;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

@Log4j2
public class SentryAPI {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("h", "help", false, "Показать справку");
        options.addOption("c", "config", true, "Путь к конфиг файлу для запуска");

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("help")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("SentryAPI", options);
            }
            else if(cmd.hasOption("config"))
            {
                File cfgFile = new File(cmd.getOptionValue("config"));
                if(cfgFile.exists())
                {
                    ConfigParser configParser = new ConfigParser(cfgFile);
                }
                else
                {
                    log.fatal("Конфиг файл " + cfgFile.getAbsolutePath() + " не найден");
                }
            }
            else
            {
                log.fatal("Даун блять конфиг файл укажи уродец, -c=<file>");
            }
        } catch (ParseException e) {
            log.error("Ошибка при парсинге аргументов: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
