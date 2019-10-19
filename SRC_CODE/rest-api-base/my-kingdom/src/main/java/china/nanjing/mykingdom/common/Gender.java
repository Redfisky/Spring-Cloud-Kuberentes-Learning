package china.nanjing.mykingdom.common;

/**
 * 性别枚举
 *
 * @author Chen Hongyu
 */
public enum Gender {

    MALE("male"),
    FEMALE("female");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
