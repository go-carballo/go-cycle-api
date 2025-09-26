package com.biciman.go.persistence.mapper;

import com.biciman.go.domain.Types;
import org.mapstruct.Named;

public class GenreMapper {


    @Named("stringToGenre")
    public static Types stringToGenre(String genero) {
        if (genero == null) return null;

        return switch (genero.toUpperCase()) {
            case "MOUNTAIN" -> Types.MOUNTAIN;
            case "URBAN" -> Types.URBAN;
            case "ELECTRIC" -> Types.ELECTRIC;
            default -> null;
        };
    }

    @Named("genreToString")
    public static  Types typesToString(Types types) {
        if (types == null) return null;

        return switch (types) {
            case MOUNTAIN -> Types.MOUNTAIN;
            case URBAN -> Types.URBAN;
            case ELECTRIC -> Types.ELECTRIC;
        };
    }
}
