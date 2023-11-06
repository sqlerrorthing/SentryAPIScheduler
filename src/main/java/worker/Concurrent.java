package worker;

import org.jetbrains.annotations.NotNull;

public interface Concurrent {

    @NotNull String getURL();
    int getPort();
    int getTime();
    Methods method();

}
