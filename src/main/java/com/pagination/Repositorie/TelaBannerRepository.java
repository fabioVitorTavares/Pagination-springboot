package com.pagination.Repositorie;

import com.pagination.ItemModel.BannerHistoricoEntity;
import com.pagination.ItemModel.TelaBannerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TelaBannerRepository extends JpaRepository<TelaBannerEntity, String> {

    @Query(value = "SELECT nome FROM fms.tela_banner WHERE id IN (" +
            "SELECT id_tela FROM fms.rel_banner_tela WHERE id_banner = :id" +
            ")", nativeQuery = true)
    List<String> findByIdBanner(@Param("id") Integer id);
}
