import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IpRunner {
    private static final String INPUT_STRING_MESSAGE = "Input: ";

    public static void main(String[] args) {
        try (var bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String queryIp;
            do {
                System.out.print(INPUT_STRING_MESSAGE);
                queryIp = bufferedReader.readLine();
                IpStatus statusIp = ValidationIpUtil.getStatusValidationIp(queryIp);
                String stringStatusIP = statusIp.getDescription();
                System.out.println(stringStatusIP);
            } while (!queryIp.isBlank());
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}