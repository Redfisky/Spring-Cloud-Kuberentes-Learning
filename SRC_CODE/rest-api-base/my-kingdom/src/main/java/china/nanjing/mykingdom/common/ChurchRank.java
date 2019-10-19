package china.nanjing.mykingdom.common;

/**
 * 教士等级
 *
 * @author Chen Hongyu
 */
public enum ChurchRank {

    // 教会序列

    // 神父
    PRIEST("Priest", 5),
    // 主教
    BISHOP("Bishop", 3),
    // 大主教
    ARCHBISHOP("Archbishop", 2),
    // 枢机主教
    CARDINAL("Cardinal", 1),
    // 教宗
    PONTIFF("Pontiff", 0);


    private String churchRank;
    private Integer level;

    ChurchRank(String churchRank, Integer level) {
        this.churchRank = churchRank;
        this.level = level;
    }

    public String getChurchRank() {
        return churchRank;
    }

    public void setChurchRank(String churchRank) {
        this.churchRank = churchRank;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
