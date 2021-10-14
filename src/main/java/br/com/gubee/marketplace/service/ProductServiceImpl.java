package br.com.gubee.marketplace.service;

import br.com.gubee.marketplace.dto.mapper.ProductMapper;
import br.com.gubee.marketplace.dto.request.ProductDTO;
import br.com.gubee.marketplace.dto.response.MessageResponseDTO;
import br.com.gubee.marketplace.entity.Product;
import br.com.gubee.marketplace.exception.ProductNotFoundException;
import br.com.gubee.marketplace.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public MessageResponseDTO add(ProductDTO productDTO){
        Product productToSave = productMapper.toModel(productDTO);
        Product productSaved = productRepository.save(productToSave);
        return createMessageResponse(productSaved, "Produto salvo");
    }

    public List<ProductDTO> listAll(){
        List<Product> allProducts = productRepository.findAll();

        return allProducts.stream()
                .map(this.productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) throws ProductNotFoundException {
        Product product = verifyIfExists(id);
        return productMapper.toDTO(product);
    }

    public void delete(Long id) throws ProductNotFoundException {
        Product product = verifyIfExists(id);

        productRepository.delete(product);
    }

    public MessageResponseDTO update(Long id, ProductDTO productDTO) throws ProductNotFoundException {
        Product product = verifyIfExists(id);

        Product productToUpdate = productMapper.toModel(productDTO);

        Product productUpdated = productRepository.save(productToUpdate);
        return createMessageResponse(productUpdated, "Produto atualizado");

    }

    private Product verifyIfExists(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() ->new ProductNotFoundException(id));
    }


    private MessageResponseDTO createMessageResponse(Product productSaved, String message) {
        return MessageResponseDTO.builder()
                .message(message + " Id: " + productSaved.getId())
                .build();
    }
}
