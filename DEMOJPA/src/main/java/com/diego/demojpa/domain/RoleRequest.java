package com.diego.demojpa.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequest {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 1, max = 10)
    @NotNull
    private String name;

    
}
