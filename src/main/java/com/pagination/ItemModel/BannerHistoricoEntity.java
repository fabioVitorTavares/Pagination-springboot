package com.pagination.ItemModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
public class BannerHistoricoEntity {

    @Id
    @Column(name ="id")
    private  Integer id;

    @Column(name = "titulo")
    private  String titulo;

    @Column(name = "pecuaria")
    private  Boolean pecuaria;

    @Column(name = "agricultura")
    private  Boolean agricultura;

    @Column(name = "patrocinador")
    private  String patrocinador;

    @Column(name = "id_produto")
    private  String idProduto;

    @Column(name = "id_servico")
    private  String idServico;

    @Column(name = "redirecionamento")
    private  String redirecionamento;

    @Column(name = "link_redirecionamento")
    private  String linkRedirecionamento;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Column(name = "data_publicacao")
    private  Date dataPublicacao;

    @Column(name = "data_exclusao")
    private  Date dataExclusao;

    @Column(name = "ativo")
    private  Boolean ativo;
}
