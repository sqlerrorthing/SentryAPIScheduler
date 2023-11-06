package parser;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;
import worker.Concurrent;

import java.io.File;
import java.lang.annotation.Annotation;
import java.nio.file.Path;

@Log4j2
public class ConfigParser implements IConfig {

    private ConfigFile configFile;

    public ConfigParser(File cfgFile) throws Exception
    {
        configFile = new ConfigFile(cfgFile);

        log.info("Начинаю парсить конфиг...");
        validateStringIsNotNull("settings.api.url");
        validateStringIsNotNull("settings.api.username");
        validateStringIsNotNull("settings.api.password");
        validateRangeInt("settings.api.loop", new Range()
        {
            public Class<? extends Annotation> annotationType() {return Range.class;}
            public long from() {return 1;}
            public long to() {return 1500;}
        });
    }

    private void validateStringIsNotNull(String str)
    {
        if (configFile.getString(str) == null || configFile.getString(str).isEmpty())
            throw new RuntimeException(str + " в "+configFile.config.getName()+" не может быть null!");
    }

    private void validateInt(String path)
    {
        if(configFile.getInt(path) == 0)
            throw new RuntimeException(path+" в "+configFile.config.getName()+" не может быть нулем!");
    }

    private void validateRangeInt(String path, Range range)
    {
        if(configFile.getInt(path) < range.from() || configFile.getInt(path) > range.to())
            throw new RuntimeException(path+" ("+configFile.getInt(path)+") в "+configFile.config.getName()+" выходит за рамки от " + range.from() + " до " + range.to() + "!");
    }

    private void validateList(String path)
    {
        if(configFile.getList(path).isEmpty())
            throw new RuntimeException(path+" в "+configFile.config.getName()+" не может быть пустым!");
    }

    @Override
    public @NotNull String username() {
        return null;
    }

    @Override
    public @NotNull String password() {
        return null;
    }

    @Override
    public @NotNull @Range(from = 1, to = 4) Concurrent[] concurrents() {
        return new Concurrent[0];
    }

    @Override
    public @NotNull String getApiURL() {
        return null;
    }
}
