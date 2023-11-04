package br.com.brunobandeiraf.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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

    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario usuario){
        return "metodoComBodyParams " + usuario.username();
    }

    // Headers
    @PostMapping("/metodoComHeaders")
    public String metodoComHeaders(@RequestHeader("name") String name){
        return "metodoComHeaders " + name;
    }
    @PostMapping("/metodoComListHeaders")
    public String metodoComListHeaders(@RequestHeader("name") Map<String, String> headers){
        return "metodoComListHeaders " + headers.entrySet();
    }

    @GetMapping("/metodoResponseEntity")
    public ResponseEntity<Object> metodoResponseEntity(@PathVariable Long number){
        var user = new Usuario("brunobandeira");

        if(number > 10){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.badRequest().body("Número menor do que 100")
    }

    // Criando uma classe simples, utilizando o record 
    // sem obrigação de criar construtores e métodos getters e setters
    record Usuario(String username){}

}
