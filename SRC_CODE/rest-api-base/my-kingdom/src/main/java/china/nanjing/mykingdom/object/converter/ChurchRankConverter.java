package china.nanjing.mykingdom.object.converter;

import china.nanjing.mykingdom.common.ChurchRank;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Chen Hongyu
 */
@Converter(autoApply = true)
public class ChurchRankConverter implements AttributeConverter<ChurchRank, String> {
    @Override
    public String convertToDatabaseColumn(ChurchRank churchRank) {
        if (Objects.isNull(churchRank)) {
            return null;
        }
        return churchRank.getChurchRank();
    }

    @Override
    public ChurchRank convertToEntityAttribute(String s) {
        if (Objects.isNull(s)) {
            return null;
        }
        return Stream.of(ChurchRank.values()).filter((xx) -> xx.getChurchRank().equalsIgnoreCase(s)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
