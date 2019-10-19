package china.nanjing.mykingdom;

import china.nanjing.mykingdom.common.ChurchRank;
import china.nanjing.mykingdom.common.Gender;
import china.nanjing.mykingdom.common.FedualRank;
import china.nanjing.mykingdom.common.Religion;
import china.nanjing.mykingdom.object.Duchy;
import china.nanjing.mykingdom.object.Kingdom;
import china.nanjing.mykingdom.object.estates_general.Clergy;
import china.nanjing.mykingdom.object.estates_general.Commoner;
import china.nanjing.mykingdom.object.estates_general.Noble;
import china.nanjing.mykingdom.object.estates_general.Subject;
import china.nanjing.mykingdom.repository.*;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyKingdomApplicationTests {

    @Autowired
    private KingdomRepository kingdomRepository;

    @Autowired
    private DuchyRepository duchyRepository;

    @Autowired
    private CommonerRepository commonerRepository;

    @Autowired
    private ClergyRepository clergyRepository;

    @Autowired
    private NobleRepository nobleRepository;

    @Test
    public void contextLoads() {
    }

    @Before
    public void beforeAllTests() {

    }

    @After
    public void afterAllTests() {

    }

//    @Test
//    public void givenUsingApache_whenGeneratingRandomAlphabeticString_thenCorrect() {
//        String generatedString = RandomStringUtils.randomAlphabetic(12);
//        System.out.println(generatedString);
//    }

    /**
     * 清空王国-公国数据
     */
    @Test
    public void jpaDeleteDataTests() {
        kingdomRepository.deleteAll();
        duchyRepository.deleteAll();
    }

    /**
     * 清空臣民数据
     */
    @Test
    public void jpaDeleteSubjectsDataTests() {
        nobleRepository.deleteAll();
        commonerRepository.deleteAll();
        clergyRepository.deleteAll();
    }

//    @Test
//    public void jpaCreateTables() {
//
//        Kingdom kingdom = Kingdom.builder().build();
//        Kingdom save = kingdomRepository.save(kingdom);
//
//        Duchy duchy = Duchy.builder().kingdom(save).build();
//        Duchy save1 = duchyRepository.save(duchy);
//
//        Noble noble = Noble.builder().duchy(save1).build();
//        Noble save2 = nobleRepository.save(noble);
//
//        Clergy clergy = Clergy.builder().duchy(save1).build();
//        Clergy save3 = clergyRepository.save(clergy);
//
//        Commoner commoner = Commoner.builder().duchy(save1).build();
//        Commoner save4 = commonerRepository.save(commoner);
//    }

    /**
     * 初始化一些王国 -- 公国数据
     */
    @Test
    public void jpaCreateDuchiesDataTests() {
//        Date date = java.util.Calendar.getInstance().getTime();
        int max = 50;
        int min = 10;
        // 30个王国，每个王国3个公国
        for (int i = 0; i < 10; i++) {
            String kingdomName = RandomStringUtils.randomAlphabetic(12);
            String name1 = RandomStringUtils.randomAlphabetic(12);
            String name2 = RandomStringUtils.randomAlphabetic(12);
            String name3 = RandomStringUtils.randomAlphabetic(12);
            int randomNum = (int) (Math.random() * ((max - min) + 1)) + min;
            Kingdom kingdom = Kingdom.builder()
                    .army(new BigDecimal(randomNum * 1000))
                    .navy(new BigDecimal(randomNum * 100 / 2))
                    .kingdomName("Kingdom Of " + kingdomName)
                    .description("一个强大且繁荣的王国 -- " + randomNum)
                    .income(new BigDecimal(randomNum * 100))
//                    .foundedDate(date)
                    .influence((double) randomNum * 3)
                    .area(new BigDecimal(randomNum))
                    .population(new BigDecimal(randomNum * 100000))
                    .stability(3)
                    .build();
            Kingdom save = kingdomRepository.save(kingdom);
            Duchy duchy = Duchy.builder()
                    .army(new BigDecimal(randomNum * 1000))
                    .navy(new BigDecimal(randomNum * 100 / 2))
                    .duchyName("Duchy Of " + name1)
                    .description("一个稳定的公国 -- " + randomNum)
                    .income(new BigDecimal(randomNum * 100))
//                    .foundedDate(date)
                    .influence((double) randomNum * 3)
                    .area(new BigDecimal(randomNum))
                    .population(new BigDecimal(randomNum * 100000))
                    .stability(3)
                    // 多对一关联
                    .kingdom(save)
                    .build();
            Duchy duchy2 = Duchy.builder()
                    .army(new BigDecimal(randomNum * 1000))
                    .navy(new BigDecimal(randomNum * 100 / 2))
                    .duchyName("Duchy Of " + name2)
                    .description("第二个稳定的公国 -- " + randomNum)
                    .income(new BigDecimal(randomNum * 100))
//                    .foundedDate(date)
                    .influence((double) randomNum * 4)
                    .area(new BigDecimal(randomNum))
                    .population(new BigDecimal(randomNum * 100000))
                    .stability(3)
                    // 多对一关联
                    .kingdom(save)
                    .build();
            Duchy duchy3 = Duchy.builder()
                    .army(new BigDecimal(randomNum * 1000))
                    .navy(new BigDecimal(randomNum * 100 / 2))
                    .duchyName("Duchy Of " + name3)
                    .description("第三个稳定的公国 -- " + randomNum)
                    .income(new BigDecimal(randomNum * 100))
//                    .foundedDate(date)
                    .influence((double) randomNum * 5)
                    .area(new BigDecimal(randomNum))
                    .population(new BigDecimal(randomNum * 100000))
                    .stability(3)
                    // 多对一关联
                    .kingdom(save)
                    .build();
            duchyRepository.save(duchy);
            duchyRepository.save(duchy2);
            duchyRepository.save(duchy3);
        }

    }

    /**
     * 初始化一些臣民数据
     */
    @Test
    public void jpaCreateSubjectsDataTests() {

        // 公国id范围
        // 测试前去数据库看一下表id范围，不然报错
        int minDuchyId = 456;
        int maxDychyId = 494;

        int max = 50;
        int min = 20;

        // 30个公国，每个公国10名贵族/10名教士/10名资产阶级
        int duchyId = minDuchyId;
        for (int i = 0; i < 30; i++) {
//            int randomDuchyId = (int) (Math.random() * ((maxDychyId - minDuchyId) + 1)) + minDuchyId;
            Optional<Duchy> duchy = duchyRepository.findById((long) duchyId);
            LinkedList<Subject> subjects = new LinkedList<>();

            // 新建贵族
            for (int j = 0; j < 10; j++) {
                int random = (int) (Math.random() * ((max - min) + 1)) + min;
                String str = RandomStringUtils.randomAlphabetic(10);
                String str2 = RandomStringUtils.randomAlphabetic(50);
                String str3 = RandomStringUtils.randomAlphabetic(20);
                String str4 = RandomStringUtils.randomAlphabetic(6);
                String nickName = "";
                if (random >= 35) {
                    nickName = "The Strong";
                } else if (random >= 25) {
                    nickName = "The Drunk";
                } else {
                    nickName = "The Pious";
                }
                String finalNickName = nickName;
                duchy.ifPresent((dd) -> {
                    Subject noble = Noble.builder()
                            .duchy(duchy.get())
                            .age(random)
                            .birthPlace(str)
                            .experience(str2)
                            .gender(Gender.MALE)
                            .house("de " + str3)
                            .name(str4)
                            .religion(Religion.REFORMED)
                            .wealth(BigDecimal.valueOf(random * 10))
                            .martialSkill(6)
                            .diplomacySkill(5)
                            .administrativeSkill(4)
                            .fedualRank(FedualRank.COUNT)
                            .prestige(random * 2)
                            .nickName(finalNickName)
                            .build();
                    subjects.add(noble);
                });
            }
            List<Noble> collect = subjects.stream().map((xx) -> (Noble) xx).collect(Collectors.toList());
            nobleRepository.saveAll(collect);
            subjects.clear();

            // 新建教士
            for (int j = 0; j < 10; j++) {
                int random = (int) (Math.random() * ((max - min) + 1)) + min;
                String str = RandomStringUtils.randomAlphabetic(10);
                String str2 = RandomStringUtils.randomAlphabetic(50);
                String str3 = RandomStringUtils.randomAlphabetic(20);
                String str4 = RandomStringUtils.randomAlphabetic(6);
                duchy.ifPresent((dd) -> {
                    Subject clergy = Clergy.builder()
                            .duchy(duchy.get())
                            .age(random)
                            .birthPlace(str)
                            .experience(str2)
                            .gender(Gender.MALE)
                            .house("von " + str3)
                            .name(str4)
                            .religion(Religion.CATHOLIC)
                            .wealth(BigDecimal.valueOf(random * 15))
                            .diplomacySkill(4)
                            .administrativeSkill(5)
                            .churchRank(ChurchRank.BISHOP)
                            .prestige(random)
                            .devotion(random * 2)
                            .build();
                    subjects.add(clergy);
                });
            }
            List<Clergy> collect2 = subjects.stream().map((xx) -> (Clergy) xx).collect(Collectors.toList());
            clergyRepository.saveAll(collect2);
            subjects.clear();

            // 新建资产阶级
            for (int j = 0; j < 10; j++) {
                int random = (int) (Math.random() * ((max - min) + 1)) + min;
                String str = RandomStringUtils.randomAlphabetic(10);
                String str2 = RandomStringUtils.randomAlphabetic(50);
                String str3 = RandomStringUtils.randomAlphabetic(20);
                String str4 = RandomStringUtils.randomAlphabetic(6);
                String guild = "";
                if (random >= 35) {
                    guild = "Guild of Flanders";
                } else if (random >= 25) {
                    guild = "Guild of Calais";
                } else {
                    guild = "Guild of Caux";
                }
                String finalGuild = guild;
                duchy.ifPresent((dd) -> {
                    Subject commoner = Commoner.builder()
                            .duchy(duchy.get())
                            .age(random)
                            .birthPlace(str)
                            .experience(str2)
                            .gender(Gender.MALE)
                            .house("of " + str3)
                            .name(str4)
                            .religion(Religion.ANGLICAN)
                            .wealth(BigDecimal.valueOf(random * 30))
                            .diplomacySkill(4)
                            .administrativeSkill(4)
                            .prestige(random / 2)
                            .profession("merchant")
                            .guild(finalGuild)
                            .build();
                    subjects.add(commoner);
                });
            }
            List<Commoner> collect3 = subjects.stream().map((xx) -> (Commoner) xx).collect(Collectors.toList());
            commonerRepository.saveAll(collect3);
            subjects.clear();

            duchyId++;
        }
    }
}
