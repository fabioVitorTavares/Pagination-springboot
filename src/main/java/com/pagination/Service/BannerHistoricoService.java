package com.pagination.Service;


import com.pagination.ItemModel.BannerHistoricoEntity;
import com.pagination.ItenDto.FiltroBannerHistorico;
import com.pagination.Repositorie.BannerHistoricoRepository;
import com.pagination.Repositorie.TelaBannerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@NoArgsConstructor(force = true)
@Service
public class BannerHistoricoService {

    @Autowired
    private final BannerHistoricoRepository bannerHistoricoRepository;

    @Autowired
    private final TelaBannerRepository telaBannerRepository;

    public List<String> findByIdBanner(Integer id){
        return telaBannerRepository.findByIdBanner(id);
    }

    public Page<BannerHistoricoEntity> findAll(){

        Pageable pageable = PageRequest.of(0,2);
        return bannerHistoricoRepository.findAll(pageable);
    }

    public Page<BannerHistoricoEntity> findByFilter(FiltroBannerHistorico filtro) throws Exception {

        String campoOrdenar = "";

        if(filtro.getOrdenarTitulo()){
            campoOrdenar = "titulo";
        }
        if(filtro.getOrdenarPorDataInicio()){
            campoOrdenar = "data_publicacao";
        }
        if(filtro.getOrdenarPorDataTermino()){
            campoOrdenar = "data_exclusao";
        }
        if(filtro.getOrdenarPorPatrocinador()){
            campoOrdenar = "patrocinador";
        }
        if(filtro.getOrdenarPorStatus()){
            campoOrdenar = "ativo";
        }

        Pageable pageable = null;

        if(campoOrdenar != ""){
            pageable = PageRequest.of(filtro.getPagina(), filtro.getItensPorPagina(), Sort.by(campoOrdenar));
        }
        else{
            pageable = PageRequest.of(filtro.getPagina(), filtro.getItensPorPagina());
        }

        if(filtro.getTitulo() != null){
            Page<BannerHistoricoEntity> banners =  bannerHistoricoRepository.findByFilterAndTitle(pageable, filtro.getTitulo());
            banners.forEach(banner -> banner.setTelas(findByIdBanner(banner.getId())));
            return banners;
        }
        Page<BannerHistoricoEntity> banners = bannerHistoricoRepository.findByFilter(pageable);
        banners.forEach(banner -> banner.setTelas(findByIdBanner(banner.getId())));
        return banners;
    }


}
