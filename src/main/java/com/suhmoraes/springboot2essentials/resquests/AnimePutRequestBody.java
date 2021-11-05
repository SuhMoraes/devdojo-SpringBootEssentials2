package com.suhmoraes.springboot2essentials.resquests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimePutRequestBody {

    private Long id;

    private String name;

}
