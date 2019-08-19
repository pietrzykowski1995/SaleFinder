package pl.atos.finalworkshop.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {

        if (source.isEmpty()) {
            return LocalDate.now();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(source, formatter);
    }
}
