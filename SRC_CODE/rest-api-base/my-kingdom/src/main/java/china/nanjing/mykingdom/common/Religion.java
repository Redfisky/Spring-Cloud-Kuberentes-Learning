package china.nanjing.mykingdom.common;

/**
 * 宗教
 *
 * @author Chen Hongyu
 */
public enum Religion {

    // 天主教
    CATHOLIC("Catholic", 0),

    // 路德教
    PROTESTANT("Protestant", 1),

    // 加尔文教
    REFORMED("Reformed", 2),

    // 英国国教
    ANGLICAN("Anglican ", 3),
    ;

    private String religion;

    private Integer index;

    Religion(String religion, Integer index) {
        this.religion = religion;
        this.index = index;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
