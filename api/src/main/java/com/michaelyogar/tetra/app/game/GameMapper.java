package com.michaelyogar.tetra.app.game;

import com.michaelyogar.tetra.app.choice.ChoiceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ChoiceMapper.class)
public abstract class GameMapper {
    public static final GameMapper MAPPER = Mappers.getMapper(GameMapper.class);

    public abstract Game gameDtoToGame(GameDto gameDto);
}
