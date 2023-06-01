package com.pagination.Service;


import com.pagination.ItemModel.BannerHistoricoEntity;
import com.pagination.ItenDto.FiltroBannerHistorico;
import com.pagination.Repositorie.BannerHistoricoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor(force = true)
@Service
public class BannerHistoricoService {

    @Autowired
    private final BannerHistoricoRepository bannerHistoricoRepository;

    public Page<BannerHistoricoEntity> findAll(){

        Pageable pageable = PageRequest.of(0,2);
        return bannerHistoricoRepository.findAll(pageable);
    }

    public Page<BannerHistoricoEntity> findByFilter(FiltroBannerHistorico filtro) {
        String titulo = filtro.getTitulo();
        if(titulo != null){
            Pageable pageable = PageRequest.of(filtro.getPagina(), filtro.getItensPorPagina());
            return bannerHistoricoRepository.findByFilterAndTitle(pageable, titulo);
        }


        String campoOrdenar = "";
        if(filtro.getOrdenarTitulo()){
            campoOrdenar = "titulo";
        }
        if(filtro.getOrdenarPorLocais()){
            campoOrdenar = ""
        }

    }
}
