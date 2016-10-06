package jpa.attribute_converters;

import jpa.converters_example.MonetaryAmount;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, String> {

    @Override
    public String convertToDatabaseColumn(MonetaryAmount attribute) {
        return  attribute.toString();
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(String dbData) {
        return MonetaryAmount.fromString(dbData);
    }
}
