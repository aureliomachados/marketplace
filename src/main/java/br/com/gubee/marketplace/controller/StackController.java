package br.com.gubee.marketplace.controller;

import br.com.gubee.marketplace.dto.request.StackDTO;
import br.com.gubee.marketplace.repository.StackRepository;
import br.com.gubee.marketplace.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stacks")
public class StackController {

    private final StackService stackService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<StackDTO> all(){
        return stackService.listAll();
    }
}
