package com.pagination.ItemModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity(name = "Item")
@Data
public class ItemModel {

    public ItemModel(){
        this.id = UUID.randomUUID();
    }

    @Id
    private UUID id;
    private String description;
}
