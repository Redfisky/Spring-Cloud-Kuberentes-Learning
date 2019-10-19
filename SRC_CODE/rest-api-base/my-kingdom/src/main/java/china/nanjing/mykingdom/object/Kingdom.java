package china.nanjing.mykingdom.object;

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
 * 王国
 *
 * @author Chen Hongyu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Kingdom")
@Table(name = "t_kingdom")
public class Kingdom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 王国名
     */
    private String kingdomName;

    /**
     * 王国描述
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
    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    private Date foundedDate;

    /**
     * 影响力
     * 小数点3位
     */
    @Column(scale = 3)
    private Double influence;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kingdom", orphanRemoval = true)
    List<Duchy> duchies = new ArrayList<>();

    @Version
    private Integer version;


}
