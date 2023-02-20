/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import persistence.ProdutoDAO;

/**
 *
 * @author iapereira
 */
@RestController
@RequestMapping(value = "/produtos")
@ComponentScan("persistence.")
public class ProdutoController {     
    @Autowired
    private ProdutoDAO produtoDAO;
    
    @GetMapping("/listar")
    public ModelAndView listar() {
        Map<String, Object> template = new HashMap();
        template.put("vetProduto", this.produtoDAO.list());
        return new ModelAndView("listar", template);
    }    
    
    @GetMapping("/deletar/{id}")      
    public ModelAndView deletar(@PathVariable("id") int id) {      
        this.produtoDAO.delete(id);
        return this.listar();
    }    
}