package com.abraaofaher.hrpayroll.model.entities;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Worker implements Serializable {
    private Long id;
    private String name;
    private Double dailyIncome;


}