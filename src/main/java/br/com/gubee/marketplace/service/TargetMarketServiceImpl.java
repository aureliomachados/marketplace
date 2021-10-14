package br.com.gubee.marketplace.service;

import br.com.gubee.marketplace.dto.mapper.TargetMarketMapper;
import br.com.gubee.marketplace.dto.request.TargetMarketDTO;
import br.com.gubee.marketplace.dto.response.MessageResponseDTO;
import br.com.gubee.marketplace.entity.TargetMarket;
import br.com.gubee.marketplace.exception.TargetMarketNotFoundException;
import br.com.gubee.marketplace.repository.TargetMarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TargetMarketServiceImpl implements TargetMarketService{

    private final TargetMarketRepository targetMarketRepository;
    private final TargetMarketMapper targetMarketMapper = TargetMarketMapper.INSTANCE;

    @Override
    public MessageResponseDTO add(TargetMarketDTO targetMarketDTO) {
        TargetMarket targetMarketToSave = targetMarketMapper.toModel(targetMarketDTO);
        TargetMarket targetMarketSaved = targetMarketRepository.save(targetMarketToSave);
        return createMessageResponse(targetMarketSaved, "Market alvo salvo");
    }

    @Override
    public List<TargetMarketDTO> listAll() {
        List<TargetMarket> allMarkets = targetMarketRepository.findAll();

        return allMarkets.stream()
                .map(this.targetMarketMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TargetMarketDTO findById(Long id) throws TargetMarketNotFoundException {
        TargetMarket targetMarket = verifyIfExists(id);
        return this.targetMarketMapper.toDTO(targetMarket);
    }

    @Override
    public void delete(Long id) throws TargetMarketNotFoundException {
        TargetMarket targetMarket = verifyIfExists(id);
        this.targetMarketRepository.delete(targetMarket);
    }

    @Override
    public MessageResponseDTO update(Long id, TargetMarketDTO targetMarketDTO) throws TargetMarketNotFoundException {
        TargetMarket targetMarket = verifyIfExists(id);

        TargetMarket targetMarketToUpdate = targetMarketMapper.toModel(targetMarketDTO);

        TargetMarket targetMarketUpdated = targetMarketRepository.save(targetMarketToUpdate);
        return createMessageResponse(targetMarketUpdated, "Mercado alvo atualizado");
    }

    private TargetMarket verifyIfExists(Long id) throws TargetMarketNotFoundException {
        return targetMarketRepository.findById(id).orElseThrow(() ->new TargetMarketNotFoundException(id));
    }


    private MessageResponseDTO createMessageResponse(TargetMarket targetMarket, String message) {
        return MessageResponseDTO.builder()
                .message(message + " Id: " + targetMarket.getId())
                .build();
    }
}
