package br.edu.ifsp.arq.ads.petpar.application.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.SpecieType;

@Component
public class StringToSpecieTypeConverter implements Converter<String, SpecieType> {

    @Override
    public SpecieType convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        try {
            return SpecieType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid SpecieType value: " + source);
        }
    }
}
