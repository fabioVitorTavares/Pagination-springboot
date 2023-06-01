package com.pagination.Controller;


import com.pagination.ItemModel.BannerHistoricoEntity;
import com.pagination.ItenDto.FiltroBannerHistorico;
import com.pagination.Service.BannerHistoricoService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor(force = true)
@RestController
@RequestMapping("/api/bannerHistorico")
public class BannerHistoricoApiResource {

    @Autowired
    private final BannerHistoricoService bannerHistoricoService;

    @GetMapping("/list")
    public ResponseEntity<Page<BannerHistoricoEntity>> findAll(){
        return ResponseEntity.ok().body(bannerHistoricoService.findAll());
    }

    @PostMapping("/findByFilter")
    public ResponseEntity<Page<BannerHistoricoEntity>> findByFilter(@RequestBody FiltroBannerHistorico filtro){
        return ResponseEntity.ok().body(bannerHistoricoService.findByFilter(filtro));
    }
}
