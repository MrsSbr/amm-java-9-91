public enum IpStatus {
    IPV4("IPv4"),
    IPV6("IPv6"),
    NEITHER("Neither");

    private final String description;

    IpStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
