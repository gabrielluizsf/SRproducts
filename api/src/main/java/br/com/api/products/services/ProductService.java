package br.com.api.products.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.products.model.ProductModel;
import br.com.api.products.model.ModelResponse;
import br.com.api.products.repositorio.ProdutoRepositorio;

@Service
public class ProductService {

    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private ModelResponse rm;

    // Método para listar todos os produtos
    public Iterable<ProductModel> listar(){
        return pr.findAll();
    }

    // Método para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(ProductModel pm, String acao){

        if(pm.getNome().equals("")){
            rm.setMessage("O nome do produto é obrigatório!");
            return new ResponseEntity<ModelResponse>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setMessage("O nome da marca é obrigatório!");
            return new ResponseEntity<ModelResponse>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProductModel>(pr.save(pm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ProductModel>(pr.save(pm), HttpStatus.OK);
            }
        }

    }

    // Método para remover produtos
    public ResponseEntity<ModelResponse> remover(long codigo){

        pr.deleteById(codigo);

        rm.setMessage("O produto foi removido com sucesso!");
        return new ResponseEntity<ModelResponse>(rm, HttpStatus.OK);

    }

}