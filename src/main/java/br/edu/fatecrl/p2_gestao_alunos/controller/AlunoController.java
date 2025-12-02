package br.edu.fatecrl.p2_gestao_alunos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.fatecrl.p2_gestao_alunos.model.Aluno;
import br.edu.fatecrl.p2_gestao_alunos.repository.AlunoRepository;
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
@RequestMapping("/alunos")
public class AlunoController {

  private final AlunoRepository alunoRepository;
  private final CursoRepository cursoRepository;

  @GetMapping
  public String listar(Model model) {
    model.addAttribute("alunos", alunoRepository.findAll());
    return "aluno/lista";
  }

  @GetMapping("/novo")
  public String novo(Model model) {
    model.addAttribute("aluno", new Aluno());
    model.addAttribute("cursos", cursoRepository.findAll());
    return "aluno/form";
  }

  @PostMapping("/salvar")
  public String salvar(@Valid @ModelAttribute Aluno aluno, BindingResult result, Model model) {

    if (result.hasErrors()) {
      model.addAttribute("cursos", cursoRepository.findAll());
      return "aluno/form";
    }

    alunoRepository.save(aluno);
    return "redirect:/alunos";
  }
}
