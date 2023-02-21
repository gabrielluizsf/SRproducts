package br.com.api.products.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.products.model.ProductModel;

@Repository
public interface ProdutoRepositorio extends CrudRepository<ProductModel, Long>{

}
