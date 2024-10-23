package com.marcosvcg.targetsistemasdesafio.questao1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Fibonacci {

    @GetMapping("/questao1")
    public String verificarNumeroNoFibonacci(@RequestParam(defaultValue = "0") int numeroInformado,
                                             @RequestParam(defaultValue = "0") int tamanhoDaSequencia,
                                             Model model
    ) {
        String resultado = fibonacci(numeroInformado, tamanhoDaSequencia);
        model.addAttribute("resultado", resultado);
        return "questao1";
    }

    private String fibonacci(int numeroInformado, int tamanhoDaSequencia) {
        long anterior = 0L, posterior = 1L;
        boolean estaNaSequencia = false;
        StringBuilder sequenciaFibonacci = new StringBuilder();

        for (int i = 0; i < tamanhoDaSequencia; i++) {
            sequenciaFibonacci.append(anterior).append(" ");
            if(anterior == numeroInformado) {
                estaNaSequencia = true;
            }
            long aux = posterior + anterior;
            anterior = posterior;
            posterior = aux;
        }

        return estaNaSequencia
                ? sequenciaFibonacci + "<br>O número informado pertence a sequência!"
                : sequenciaFibonacci + "<br>Não pertence a sequência.";
    }
}
