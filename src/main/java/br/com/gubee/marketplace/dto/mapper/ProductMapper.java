package br.com.gubee.marketplace.dto.mapper;

import br.com.gubee.marketplace.dto.request.ProductDTO;
import br.com.gubee.marketplace.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toModel(ProductDTO productDTO);

    ProductDTO toDTO(Product product);
}
