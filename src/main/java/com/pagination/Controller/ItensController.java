package com.pagination.Controller;

import com.pagination.ItemModel.ItemModel;
import com.pagination.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItensController {


    @Autowired
    ItemService itemService;

    @CrossOrigin("*")
    @GetMapping("/getAll")
    public ResponseEntity<List<ItemModel>> getAll(){
        List<ItemModel> itens = itemService.getAll();
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping("/getItens")
    public ResponseEntity<Page<ItemModel>> getItens(Pageable pagination){
        Page<ItemModel> itens = itemService.getItens(pagination);
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }
}
