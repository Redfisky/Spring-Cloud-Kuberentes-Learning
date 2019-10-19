package china.nanjing.mykingdom.common;

/**
 * 封建制度下的贵族等级枚举
 *
 * @author Chen Hongyu
 */
public enum FedualRank {

    // 世俗序列

    // 国王
    KING("King", 0),
    // 公爵
    DUKE("Duke", 1),
    // 侯爵
    MARQUIS("Marquis", 2),
    // 伯爵
    COUNT("Count", 3),
    // 男爵
    BARON("Baron", 4),
    // 骑士
    KNIGHT("Knight", 5),
    // 平民
    COMMONER("Commoner", 6);


    /**
     * 封建等级
     */
    private String fedualRank;

    /**
     * 级别, 越小越高贵
     */
    private Integer level;

    FedualRank(String fedualRank, Integer level) {
        this.fedualRank = fedualRank;
        this.level = level;
    }

    public String getFedualRank() {
        return fedualRank;
    }

    public void setFedualRank(String fedualRank) {
        this.fedualRank = fedualRank;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
