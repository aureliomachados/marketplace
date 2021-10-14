package br.com.gubee.marketplace.service;

import br.com.gubee.marketplace.dto.request.ProductDTO;
import br.com.gubee.marketplace.dto.response.MessageResponseDTO;
import br.com.gubee.marketplace.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

public interface ProductService {
    public MessageResponseDTO add(ProductDTO productDTO);
    public List<ProductDTO> listAll();
    public ProductDTO findById(Long id)  throws ProductNotFoundException;
    public void delete(Long id) throws ProductNotFoundException;
    public MessageResponseDTO update(Long id, ProductDTO productDTO) throws ProductNotFoundException;
}
