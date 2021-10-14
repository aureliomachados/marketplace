package br.com.gubee.marketplace.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    private String targetMarket;
}
