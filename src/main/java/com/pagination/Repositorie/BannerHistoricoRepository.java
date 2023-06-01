package com.pagination.Repositorie;

import com.pagination.ItemModel.BannerHistoricoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface BannerHistoricoRepository extends PagingAndSortingRepository<BannerHistoricoEntity, Integer> {

    @Query(value = "SELECT * FROM fms.banner", nativeQuery = true)
    Page<BannerHistoricoEntity> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM fms.banner WHERE fms.banner.titulo ILIKE '%:titulo%'", nativeQuery = true)
    Page<BannerHistoricoEntity> findByFilterAndTitle(Pageable pageable, String titulo);

    @Query(value = "SELECT * FROM fms.banner", nativeQuery = true)
    Page<BannerHistoricoEntity> findByFilter(Pageable pageable);

}
