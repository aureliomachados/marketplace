package br.com.gubee.marketplace.controller;

import br.com.gubee.marketplace.dto.request.TargetMarketDTO;
import br.com.gubee.marketplace.service.TargetMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/markets")
public class TargetMarketController {

    private final TargetMarketService targetMarketService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<TargetMarketDTO> all(){
        return this.targetMarketService.listAll();
    }
}
