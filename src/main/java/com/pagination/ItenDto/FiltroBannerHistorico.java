package com.pagination.ItenDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltroBannerHistorico {

    private String titulo;

    private Boolean ordenarTitulo;

    private Boolean ordenarPorLocais;

    private Boolean ordenarPorDataInicio;

    private Boolean ordenarPorDataTermino;

    private Boolean ordenarPorAutor;

    private Boolean ordenarPorPatrocinador;

    private Boolean ordenarPorStatus;

    private Integer pagina;

    private Integer itensPorPagina;
}
