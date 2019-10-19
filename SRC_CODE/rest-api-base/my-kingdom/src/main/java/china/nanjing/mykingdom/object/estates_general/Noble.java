package china.nanjing.mykingdom.object.estates_general;

import china.nanjing.mykingdom.common.FedualRank;
import china.nanjing.mykingdom.object.Duchy;
import china.nanjing.mykingdom.object.converter.RankConverter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * 贵族
 *
 * @author Chen Hongyu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SuperBuilder
@Entity(name = "Noble")
@Table(name = "t_noble")
public class Noble extends Subject {


    /**
     * 等级
     */
    @Convert(converter = RankConverter.class)
    private FedualRank fedualRank;


    /**
     * 绰号
     */
    private String nickName;

    /**
     * 荣誉头衔
     */
    private String honorableTitle;

    /**
     * 战争技能
     */
    private Integer martialSkill;

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
     * 从属公国
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duchy_id")
    public Duchy duchy;

}
