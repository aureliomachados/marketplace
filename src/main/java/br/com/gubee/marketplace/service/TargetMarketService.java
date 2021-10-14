package br.com.gubee.marketplace.service;

import br.com.gubee.marketplace.dto.request.ProductDTO;
import br.com.gubee.marketplace.dto.request.TargetMarketDTO;
import br.com.gubee.marketplace.dto.response.MessageResponseDTO;
import br.com.gubee.marketplace.exception.ProductNotFoundException;
import br.com.gubee.marketplace.exception.TargetMarketNotFoundException;

import java.util.List;

public interface TargetMarketService {

    public MessageResponseDTO add(TargetMarketDTO targetMarketDTO);
    public List<TargetMarketDTO> listAll();
    public TargetMarketDTO findById(Long id)  throws TargetMarketNotFoundException;
    public void delete(Long id) throws TargetMarketNotFoundException;
    public MessageResponseDTO update(Long id, TargetMarketDTO targetMarketDTO) throws TargetMarketNotFoundException;
}
