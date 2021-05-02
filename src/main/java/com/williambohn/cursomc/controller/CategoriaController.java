package com.williambohn.cursomc.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.williambohn.cursomc.domain.Categoria;
import com.williambohn.cursomc.domain.dto.CategoriaDTO;
import com.williambohn.cursomc.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
   
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findCategoryId(@PathVariable Integer id) {
        Categoria obj =   categoriaService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Categoria categoria){
        categoria = categoriaService.insert(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
                
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id){
        categoria = categoriaService.update(categoria);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
       List<Categoria> list =  categoriaService.findAll();
       List<CategoriaDTO> listDto = list.stream()
                                    .map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/pages")
    public ResponseEntity<Page<CategoriaDTO>> findPage(
             @RequestParam(value = "page", defaultValue = "0")  Integer page, 
             @RequestParam(value = "linesPerPage", defaultValue = "24")  Integer linesPerPage, 
             @RequestParam(value = "orderBy", defaultValue = "nome")  String orderBy, 
             @RequestParam(value = "direction", defaultValue = "ASC", required = false)  String direction
        ){
            Page<Categoria> pageCat =  categoriaService.findPage(page,linesPerPage,orderBy,direction);
            Page<CategoriaDTO> pageDto = pageCat.map(obj -> new CategoriaDTO(obj));
             return ResponseEntity.ok().body(pageDto);
    }
}
