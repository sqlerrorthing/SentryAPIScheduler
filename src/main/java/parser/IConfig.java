package parser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;
import worker.Concurrent;

public interface IConfig extends AuthData {

    @NotNull @Range(from = 1, to = 4) Concurrent[] concurrents();
    @NotNull String getApiURL();

}
