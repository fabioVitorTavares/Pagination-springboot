package com.pagination.ItenDto;

import com.pagination.ItemModel.ItemModel;
import lombok.Data;
import java.util.List;

@Data
public class PageItensDto {

    private List<ItemModel> Itens;
    private Integer page;
    private Integer total;
}
