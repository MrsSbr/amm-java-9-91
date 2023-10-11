import java.util.regex.Pattern;

public final class ValidationIpUtil {
    private static final String IPV4_REGEX =
            "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])((\\.(?!$))|$)){4}$";
    public static final String IPV6_REGEX =
            "^(([0-9a-fA-F]{1,4})((:(?!$))|$)){8}$";
    public static final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);
    public static final Pattern IPV6_PATTERN = Pattern.compile(IPV6_REGEX);

    private ValidationIpUtil() {
    }

    public static IpStatus getStatusValidationIp(String string) {
        if (IPV4_PATTERN.matcher(string).matches()) {
            return IpStatus.IPV4;
        }
        if (IPV6_PATTERN.matcher(string).matches()) {
            return IpStatus.IPV6;
        }
        return IpStatus.NEITHER;
    }
}
