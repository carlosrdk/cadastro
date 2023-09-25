package br.edu.iftm.tspi.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.iftm.tspi.cadastro.model.Cadastro;

@Controller
public class CadastroController {

    List<Cadastro> cadastros = new ArrayList<>();
    int posicoesDeletadas = 0; // quando a função delete é utilizada, ela acaba diminuindo o comprimento do vetor, fazendo que o próximo cadastro tenha um id que já está sendo utilizado. Essa variável corrige o problema adicionando 1 à soma que gera o atributo ID pra cada vez que a função delete é utilizada.

    @GetMapping("/cadastro")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("cadastro", new Cadastro());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastro(Cadastro cadastro) {
        if(cadastro.getId() != null) {
            Cadastro selecionarCadastro = cadastros.stream().filter(cadastroSelecionado -> cadastro.getId().equals(cadastroSelecionado.getId())).findFirst().get();
            cadastros.set(cadastros.indexOf(selecionarCadastro), cadastro);
        } else {
            Long id = cadastros.size() + 1L + posicoesDeletadas;
            cadastros.add(new Cadastro(id, cadastro.getInputNome(), cadastro.getInputEmail(), cadastro.getInputEndereco(), cadastro.getInputTelefone()));
        
        }
        
        return "redirect:/listagem";
    }

    @GetMapping("/listagem")
    public ModelAndView listagem() {
        ModelAndView mv = new ModelAndView("listagem");
        mv.addObject("cadastros", cadastros);
        return mv;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("cadastro");
        Cadastro selecionarCadastro = cadastros.stream().filter(cadastro -> id.equals(cadastro.getId())).findFirst().get();
        mv.addObject("cadastro", selecionarCadastro);
        return mv;
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        cadastros.removeIf(cadastro -> id.equals(cadastro.getId()));
        posicoesDeletadas++;
        return "redirect:/listagem";  
    }
}
