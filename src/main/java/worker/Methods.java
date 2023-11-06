package worker;

import org.jetbrains.annotations.Nullable;

public enum Methods {
    FLOOD,
    QUERY,
    HYPERNIX,
    BYPASS,
    CRYPTO,
    VULCAN,
    TCP,
    UDP,
    ACK,
    DNS,
    NTP,
    LDAP,
    SADP,
    SOCKET,
    SSH,
    OVH_TCP,
    GUDP,
    PUDP,
    OVHRAW,
    NFORAW,
    HANDSHAKE,
    TCPSOCKET,
    TCPBYPASS;


    public static @Nullable Methods getMethodFromName(String name) {
        if (name != null) {
            name = name.toLowerCase();
            for (Methods method : values()) {
                if (method.name().toLowerCase().replace("-", "_").equals(name)) {
                    return method;
                }
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return name().replace("_", "-");
    }
}
