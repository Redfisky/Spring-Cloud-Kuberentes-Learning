package china.nanjing.mykingdom.object.estates_general;

import china.nanjing.mykingdom.object.Duchy;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * 平民 -- 资产阶级
 *
 * @author Chen Hongyu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SuperBuilder
@Entity(name = "Commoner")
@Table(name = "t_commoner")
public class Commoner extends Subject {



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
     * 职业
     */
    private String profession;

    /**
     * 行会
     */
    private String guild;

    /**
     * 从属公国
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duchy_id")
    public Duchy duchy;

}
