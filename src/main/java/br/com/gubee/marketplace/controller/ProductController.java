package br.com.gubee.marketplace.controller;

import br.com.gubee.marketplace.dto.request.ProductDTO;
import br.com.gubee.marketplace.dto.response.MessageResponseDTO;
import br.com.gubee.marketplace.exception.ProductNotFoundException;
import br.com.gubee.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO add(@RequestBody @Valid ProductDTO productDTO){
        return this.productService.add(productDTO);
    }

    @GetMapping
    public List<ProductDTO> listAll(){
        return this.productService.listAll();
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) throws ProductNotFoundException {
        return this.productService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid ProductDTO productDTO) throws ProductNotFoundException {
        return this.productService.update(id, productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ProductNotFoundException {
        this.productService.delete(id);
    }
}
