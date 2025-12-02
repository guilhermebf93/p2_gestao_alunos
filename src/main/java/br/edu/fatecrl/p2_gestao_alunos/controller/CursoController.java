package br.edu.fatecrl.p2_gestao_alunos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.fatecrl.p2_gestao_alunos.model.Curso;
import br.edu.fatecrl.p2_gestao_alunos.repository.CursoRepository;
import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid; 
import org.springframework.validation.BindingResult;


/**
 *
 * @author gui
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/cursos")
public class CursoController {

  private final CursoRepository cursoRepository;

  @GetMapping
  public String listar(Model model) {
    model.addAttribute("cursos", cursoRepository.findAll());
    return "curso/lista";
  }

  @GetMapping("/novo")
  public String novo(Model model) {
    model.addAttribute("curso", new Curso());
    return "curso/form";
  }

  @PostMapping("/salvar")
  public String salvar(@Valid @ModelAttribute Curso curso, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("cursos", cursoRepository.findAll());
      return "curso/form";
    }
    cursoRepository.save(curso);
    return "redirect:/cursos";
  }
}
