package br.com.brunobandeiraf.ioc_di;

import org.springframework.stereotype.Service;

@Service
// ou @Component
public class MeuComponente {
    public String meuPrimeiroComponente(){
        return "Meu primeiro component";
    }
}
