package br.com.gubee.marketplace.service;

import br.com.gubee.marketplace.dto.mapper.StackMapper;
import br.com.gubee.marketplace.dto.request.StackDTO;
import br.com.gubee.marketplace.dto.response.MessageResponseDTO;
import br.com.gubee.marketplace.entity.Product;
import br.com.gubee.marketplace.entity.Stack;
import br.com.gubee.marketplace.exception.StackNotFoundException;
import br.com.gubee.marketplace.repository.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StackServiceImpl implements StackService {

    private final StackRepository stackRepository;

    private final StackMapper stackMapper = StackMapper.INSTANCE;

    @Override
    public MessageResponseDTO add(StackDTO stackDTO) {
        Stack stackToSave = stackMapper.toModel(stackDTO);
        Stack stackSaved = stackRepository.save(stackToSave);
        return createMessageResponse(stackSaved, "Tecnologia salva");
    }

    @Override
    public List<StackDTO> listAll() {
        List<Stack> allStacks = stackRepository.findAll();

        return allStacks.stream()
                .map(this.stackMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StackDTO findById(Long id) throws StackNotFoundException {
        Stack stack = verifyIfExists(id);
        return this.stackMapper.toDTO(stack);
    }

    @Override
    public void delete(Long id) throws StackNotFoundException {
        Stack stack = verifyIfExists(id);
        this.stackRepository.delete(stack);
    }

    @Override
    public MessageResponseDTO update(Long id, StackDTO stackDTO) throws StackNotFoundException {
        Stack stack = verifyIfExists(id);

        Stack stackToUpdate = stackMapper.toModel(stackDTO);

        Stack stackUpdated = stackRepository.save(stackToUpdate);
        return createMessageResponse(stackUpdated, "Tecnologia atualizada");
    }

    private Stack verifyIfExists(Long id) throws StackNotFoundException {
        return stackRepository.findById(id).orElseThrow(() ->new StackNotFoundException(id));
    }


    private MessageResponseDTO createMessageResponse(Stack stackSaved, String message) {
        return MessageResponseDTO.builder()
                .message(message + " Id: " + stackSaved.getId())
                .build();
    }
}
