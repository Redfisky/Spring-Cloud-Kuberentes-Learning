package china.nanjing.mykingdom.object;

import china.nanjing.mykingdom.object.estates_general.Clergy;
import china.nanjing.mykingdom.object.estates_general.Commoner;
import china.nanjing.mykingdom.object.estates_general.Noble;
import china.nanjing.mykingdom.object.estates_general.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Id;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 公国
 *
 * @author Chen Hongyu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Duchy")
@Table(name = "t_duchy")
public class Duchy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 公国名
     */
    private String duchyName;

    /**
     * 公国描述
     * 字段长度1024
     */
    @Column(length = 1024)
    private String description;

    /**
     * 人口
     */
    private BigDecimal population;

    /**
     * 陆军
     */
    private BigDecimal army;

    /**
     * 海军
     */
    private BigDecimal navy;

    /**
     * 疆域
     */
    private BigDecimal area;

    /**
     * 收入
     */
    private BigDecimal income;

    /**
     * 稳定度
     */
    private Integer stability;

    /**
     * 建国日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date foundedDate;

    /**
     * 影响力
     * 小数点3位
     */
    @Column(scale = 3)
    private Double influence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kingdom_id")
    Kingdom kingdom;

    /**
     * 隶属臣民 -- 贵则
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duchy", orphanRemoval = true)
    List<Noble> nobles = new ArrayList<>();

    /**
     * 隶属臣民 -- 教士
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duchy", orphanRemoval = true)
    List<Clergy> clergies = new ArrayList<>();

    /**
     * 隶属臣民 -- 资产阶级
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duchy", orphanRemoval = true)
    List<Commoner> commoners = new ArrayList<>();

    @Version
    private Integer version;

}
