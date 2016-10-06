package jpa.converters_example;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

public class MonetaryAmount {
    protected final BigDecimal value;
    protected final Currency currency;

    public MonetaryAmount(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonetaryAmount that = (MonetaryAmount) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        return currency != null ? currency.equals(that.currency) : that.currency == null;

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getValue() + " " + getCurrency();
    }

    public static MonetaryAmount fromString(String str) {
        String[] arr = str.split(" ");

        return new MonetaryAmount(new BigDecimal(arr[0]), Currency.getInstance(arr[1]));
    }
}
