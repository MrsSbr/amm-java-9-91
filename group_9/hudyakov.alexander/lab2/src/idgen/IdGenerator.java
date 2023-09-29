package idgen;

public class IdGenerator {
    private static int nextId = 0;
    public static synchronized int getNextId() {
        int res = nextId;
        ++nextId;
        return res;
    }
}
