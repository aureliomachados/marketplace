package br.com.gubee.marketplace.dto.mapper;

import br.com.gubee.marketplace.dto.request.TargetMarketDTO;
import br.com.gubee.marketplace.entity.TargetMarket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TargetMarketMapper {
    TargetMarketMapper INSTANCE = Mappers.getMapper(TargetMarketMapper.class);

    TargetMarket toModel(TargetMarketDTO targetMarketDTO);

    TargetMarketDTO toDTO(TargetMarket targetMarket);
}
