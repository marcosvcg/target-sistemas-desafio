package com.marcosvcg.targetsistemasdesafio.questao2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OcorrenciasLetraA {

    @GetMapping("/questao2")
    public String verificarOcorrenciasLetraA(@RequestParam(defaultValue = "") String texto,
                                             Model model
    ) {
        if(!texto.isEmpty()) {
            int quantidade = ocorrenciasLetraA(texto);
            model.addAttribute("quantidade", quantidade);
        }
        model.addAttribute("texto", texto);
        return "questao2";
    }

    public int ocorrenciasLetraA(String texto) {
        int quantidade = 0;

        for(char letra : texto.toLowerCase().toCharArray()) {
            if(letra == 'a') {
                quantidade++;
            }
        }

        return quantidade;
    }
}
