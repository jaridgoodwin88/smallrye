package io.smallrye.graphql.websocket.graphqltransportws;

public enum MessageType {

    CONNECTION_INIT("connection_init"),
    CONNECTION_ACK("connection_ack"),
    PING("ping"),
    PONG("pong"),
    SUBSCRIBE("subscribe"),
    NEXT("next"),
    ERROR("error"),
    COMPLETE("complete");

    private static final MessageType[] VALUES = values();

    private final String str;

    MessageType(String str) {
        this.str = str;
    }

    public static MessageType fromString(String text) {
        for (MessageType b : VALUES) {
            if (b.str.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unknown message type: " + text);
    }
}
