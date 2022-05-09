package it.amorabito.coursinho.model.dtos;

import lombok.Data;

@Data
public class Paginator {

    private int numPage;
    private int elementsPerPage;
    private String orderBy;
}
