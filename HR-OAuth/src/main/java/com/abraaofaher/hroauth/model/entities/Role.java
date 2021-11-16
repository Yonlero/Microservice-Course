package com.abraaofaher.hroauth.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Role implements Serializable {

    private long id;
    @NotNull(message = "É obrigatorio preencher o nome da Role")
    private String roleName;
}