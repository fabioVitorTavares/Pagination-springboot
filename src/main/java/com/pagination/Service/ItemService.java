package com.pagination.Service;

import com.pagination.ItemModel.ItemModel;
import com.pagination.ItenDto.PageItensDto;
import com.pagination.Repositorie.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<ItemModel> getAll(){
        return itemRepository.findAll();
    }

    public Page<ItemModel> getItens(Pageable pagination) {

//        Pageable pagination = PageRequest.of(0, 2);
        return itemRepository.findAll(pagination);
    }
}
