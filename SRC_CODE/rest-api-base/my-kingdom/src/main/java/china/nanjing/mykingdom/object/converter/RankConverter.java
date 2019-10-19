package china.nanjing.mykingdom.object.converter;

import china.nanjing.mykingdom.common.FedualRank;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * JPA 2.1+ Converter https://www.baeldung.com/jpa-persisting-enums-in-jpa
 * @author Chen Hongyu
 */
@Converter(autoApply = true)
public class RankConverter implements AttributeConverter<FedualRank, String> {
    @Override
    public String convertToDatabaseColumn(FedualRank fedualRank) {
        if (Objects.isNull(fedualRank)) {
            return null;
        }
        return fedualRank.getFedualRank();
    }

    @Override
    public FedualRank convertToEntityAttribute(String s) {
        if (Objects.isNull(s)) {
            return null;
        }
        return Stream.of(FedualRank.values()).filter((xx) -> xx.getFedualRank().equalsIgnoreCase(s)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
