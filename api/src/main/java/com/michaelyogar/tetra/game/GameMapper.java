package com.michaelyogar.tetra.game;

import com.michaelyogar.tetra.choice.ChoiceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ChoiceMapper.class)
public abstract class GameMapper {
    public static final GameMapper MAPPER = Mappers.getMapper(GameMapper.class);

    public abstract Game gameDtoToGame(GameDto gameDto);
}
