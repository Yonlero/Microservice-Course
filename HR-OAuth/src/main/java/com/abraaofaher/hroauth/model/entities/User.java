package com.abraaofaher.hroauth.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User implements Serializable {

    private long id;
    @NotNull(message = "Campo Nome é Obrigatorio")
    private String name;
    @NotNull(message = "Campo E-mail é Obrigatorio")
    @Column(unique = true)
    private String email;
    @NotNull(message = "Campo Senha é Obrigatorio")
    private String password;

    Set<Role> roles = new HashSet<>();
}