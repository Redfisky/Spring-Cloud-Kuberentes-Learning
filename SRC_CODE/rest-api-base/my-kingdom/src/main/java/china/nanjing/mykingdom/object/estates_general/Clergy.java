package china.nanjing.mykingdom.object.estates_general;

import china.nanjing.mykingdom.common.ChurchRank;
import china.nanjing.mykingdom.object.Duchy;
import china.nanjing.mykingdom.object.converter.ChurchRankConverter;
import china.nanjing.mykingdom.object.converter.RankConverter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * 教士
 *
 * @author Chen Hongyu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SuperBuilder
@Entity(name = "Clergy")
@Table(name = "t_clergy")
public class Clergy extends Subject {



    /**
     * 等级
     */
    @Convert(converter = ChurchRankConverter.class)
    private ChurchRank churchRank;

    /**
     * 荣誉头衔
     */
    private String honorableTitle;

    /**
     * 外交技能
     */
    private Integer diplomacySkill;

    /**
     * 行政技能
     */
    private Integer administrativeSkill;

    /**
     * 威望
     */
    private Integer prestige;

    /**
     * 虔诚
     */
    private Integer devotion;

    /**
     * 从属公国
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duchy_id")
    public Duchy duchy;

}
