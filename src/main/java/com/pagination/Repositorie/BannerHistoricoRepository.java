package com.pagination.Repositorie;

import com.pagination.ItemModel.BannerHistoricoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface BannerHistoricoRepository extends PagingAndSortingRepository<BannerHistoricoEntity, Integer> {

    @Query(value = "SELECT * FROM fms.banner", nativeQuery = true)
    Page<BannerHistoricoEntity> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM fms.banner WHERE fms.banner.titulo ILIKE  %:titulo%", nativeQuery = true)
    Page<BannerHistoricoEntity> findByFilterAndTitle(Pageable pageable, @Param("titulo") String titulo);

    @Query(value = "SELECT * FROM fms.banner", nativeQuery = true)
    Page<BannerHistoricoEntity> findByFilter(Pageable pageable);

}
