package br.com.brunobandeiraf.ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/component")
public class MeuControllerComponent {
   
    // Não é uma maneira utilizada
    // Spring Boot realiza o gerenciamento do ciclo de vida dos componentes (bean)
    // @GetMapping("/")
    // public String chamandoComponent(){
    //     var meuComponente = new MeuComponente();
    //     var resultado = meuComponente.meuPrimeiroComponente();
    //     return resultado;
    // }

    @Autowired
    MeuComponente meuComponente;

    @GetMapping("/")
    public String chamandoComponent(){

        var resultado = meuComponente.meuPrimeiroComponente();
        return resultado;
    }
}
