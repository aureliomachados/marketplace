package br.com.gubee.marketplace.service;

import br.com.gubee.marketplace.dto.request.StackDTO;
import br.com.gubee.marketplace.dto.response.MessageResponseDTO;
import br.com.gubee.marketplace.exception.StackNotFoundException;

import java.util.List;

public interface StackService {
    public MessageResponseDTO add(StackDTO stackDTO);
    public List<StackDTO> listAll();
    public StackDTO findById(Long id)  throws StackNotFoundException;
    public void delete(Long id) throws StackNotFoundException;
    public MessageResponseDTO update(Long id, StackDTO thStackDTO) throws StackNotFoundException;
}
