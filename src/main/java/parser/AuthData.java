package parser;

import org.jetbrains.annotations.NotNull;

public interface AuthData {

    @NotNull String username();
    @NotNull String password();

}
