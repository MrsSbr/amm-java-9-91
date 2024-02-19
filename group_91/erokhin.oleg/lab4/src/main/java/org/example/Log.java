package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Log {
    private final LocalDate date;
    private final String resource;
    private final String ip;
    private final HttpStatusCode code;

    public Log(LocalDate date, String resource, String ip, HttpStatusCode code) {
        this.date = date;
        this.resource = resource;
        this.ip = ip;
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getResource() {
        return resource;
    }

    public String getIp() {
        return ip;
    }

    public HttpStatusCode getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(date, log.date) &&
                Objects.equals(resource, log.resource) &&
                Objects.equals(ip, log.ip) && code == log.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, resource, ip, code);
    }

    @Override
    public String toString() {
        return "Log{" +
                "date=" + date +
                ", resource='" + resource + '\'' +
                ", ip='" + ip + '\'' +
                ", code=" + code +
                '}';
    }
}
