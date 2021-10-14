package br.com.gubee.marketplace.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    @NotEmpty
    @Size(min = 2, max = 256)
    private String name;

    @NotEmpty
    @Size(min = 8, max = 512)
    private String description;
    private double price;
    private List<TargetMarketDTO> targetMarkets;
    private List<StackDTO> stacks;
}
