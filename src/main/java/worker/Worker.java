package worker;

import lombok.Getter;

public class Worker {

    @Getter private final String apiURL;
    @Getter private final String username;
    @Getter private final String key;
    @Getter private final int loop;

    public Worker(String apiURL, String username, String key, int loop) {
        this.apiURL = apiURL;
        this.username = username;
        this.key = key;
        this.loop = loop;
    }
}
