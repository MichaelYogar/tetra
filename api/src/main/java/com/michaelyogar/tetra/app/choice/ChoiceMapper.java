package com.michaelyogar.tetra.app.choice;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChoiceMapper {
    ChoiceMapper MAPPER = Mappers.getMapper(ChoiceMapper.class);

    @Mapping(target = "choiceText", source = "value")
    Choice choiceDtoToChoice(ChoiceDto choiceDto);
}
