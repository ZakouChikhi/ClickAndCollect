package com.orleans.univ.microservices.servicecatalogue.web.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemFilterRequest{

    private List<Long> itemIds;
}
