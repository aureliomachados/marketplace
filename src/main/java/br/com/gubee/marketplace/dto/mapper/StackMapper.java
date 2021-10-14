package br.com.gubee.marketplace.dto.mapper;

import br.com.gubee.marketplace.dto.request.StackDTO;
import br.com.gubee.marketplace.entity.Stack;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StackMapper {
    StackMapper INSTANCE = Mappers.getMapper(StackMapper.class);

    Stack toModel(StackDTO stackDTO);
    StackDTO toDTO(Stack stack);
}
