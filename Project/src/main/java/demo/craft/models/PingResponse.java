package demo.craft.models;

import demo.craft.Application;

import java.util.Date;

public class PingResponse {

    private final Date timestamp = new Date();

    private final String version = Application.VERSION;

    public String getTimestamp() {
        return "PING: " + timestamp.toString();
    }

    public String getVersion() {
        return version;
    }

}
