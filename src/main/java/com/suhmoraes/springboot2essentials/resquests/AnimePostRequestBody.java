package com.suhmoraes.springboot2essentials.resquests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimePostRequestBody {

    @NotEmpty (message = "The anime name cannot be empty")
      private String name;

}