package br.com.brunobandeiraf.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {
    @GetMapping("/primeiroMetodo")
    public String primeiroMetodo(){
        return "Meu primeiro Método da API Rest";
    }

    @GetMapping("/segundoMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id){
        return "O parâmetro é " + id;
    }

    // add ? após o nome do parâmetro
    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam String id){
        return "O parâmetro com  metodoComQueryParams é" + id;
    }

    @GetMapping("/metodoComQueryParamsMultiplos")
    public String metodoComQueryParamsMultiplos(@RequestParam Map<String, String> allParams){
        return "O parâmetro com  metodoComQueryParamsMultiplos é" + allParams.entrySet();
    }
}
