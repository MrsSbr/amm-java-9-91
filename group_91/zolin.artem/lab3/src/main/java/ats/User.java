package ats;

public record User(String fullName, int atsId, int id) {

    public static final int MAX_ATS_ID = 99;
    public static final int MAX_USER_ID = 99999;

    public User {
        if (atsId < 0 || atsId > MAX_ATS_ID || id < 0 || id > MAX_USER_ID) {
            throw new IllegalArgumentException("atdId must be 2 digits and id must be 5 digits");
        }
    }

    public String getPhoneNumber() {
        return String.format("%02d %05d", atsId, id);
    }

}
