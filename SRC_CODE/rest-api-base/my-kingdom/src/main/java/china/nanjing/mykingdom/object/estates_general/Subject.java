package china.nanjing.mykingdom.object.estates_general;

import china.nanjing.mykingdom.common.Gender;
import china.nanjing.mykingdom.common.Religion;
import china.nanjing.mykingdom.object.Duchy;
import china.nanjing.mykingdom.object.Kingdom;
import china.nanjing.mykingdom.object.converter.GenderConverter;
import china.nanjing.mykingdom.object.converter.RankConverter;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Chen Hongyu
 */
// @MappedSuperclass https://blog.csdn.net/zty1317313805/article/details/80524900
// https://www.baeldung.com/lombok-builder-inheritance lombok继承写法
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SuperBuilder
@MappedSuperclass
public class Subject {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    @Version
    private Integer version;

    /**
     * 名
     */
    private String name;

    /**
     * 家族 -- 姓氏
     */
    private String house;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    /**
     * 出生地
     */
    private String birthPlace;

    /**
     * 人生经历
     */
    @Column(length = 1024)
    private String experience;

    /**
     * 个人财富
     */
    private BigDecimal wealth;

    /**
     * 出生日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date birthDate;


    /**
     * 死亡日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date deathDate;

    /**
     * 个人宗教
     */
    private Religion religion;



}
