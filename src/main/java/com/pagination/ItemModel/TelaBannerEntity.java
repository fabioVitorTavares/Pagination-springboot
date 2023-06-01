package com.pagination.ItemModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TelaBannerEntity {

    @Id
    @Column(name = "nome")
    private String nome;
}
