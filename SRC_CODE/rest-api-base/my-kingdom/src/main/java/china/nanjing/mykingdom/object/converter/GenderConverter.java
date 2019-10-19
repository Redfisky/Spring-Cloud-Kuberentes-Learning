package china.nanjing.mykingdom.object.converter;

import china.nanjing.mykingdom.common.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Chen Hongyu
 */
@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {
    @Override
    public String convertToDatabaseColumn(Gender gender) {
        if (Objects.isNull(gender)) {
            return null;
        }
        return gender.getGender();
    }

    @Override
    public Gender convertToEntityAttribute(String s) {
        if (Objects.isNull(s)) {
            return null;
        }
        return Stream.of(Gender.values()).filter((xx) -> xx.getGender().equalsIgnoreCase(s)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
