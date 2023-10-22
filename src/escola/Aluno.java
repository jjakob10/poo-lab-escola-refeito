package escola;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Date;

import escola.enums.GeneroEnum;

public class Aluno {
  private String matricula;
  private String nome;
  private float cR;
  private GeneroEnum genero;
  private LocalDate nascimento;
  private float rendaFamiliar;

  Locale brLocale = Locale.forLanguageTag("pt-BR");
  NumberFormat nf = NumberFormat.getInstance(brLocale);
  NumberFormat real = NumberFormat.getCurrencyInstance(brLocale);

  public Aluno(String matricula, String nome, float cR, GeneroEnum genero, LocalDate nascimento, float rendaFamiliar) {
    this.matricula = matricula;
    this.nome = nome;
    this.cR = cR;
    this.genero = genero;
    this.nascimento = nascimento;
    this.rendaFamiliar = rendaFamiliar;
  }

  public float getRendaFamiliar() {
    return rendaFamiliar;
  }

  public String getMatricula() {
    return matricula;
  }

  @Override
  public String toString() {

    String saida = this.matricula + " - " + this.nome + " - CR: " + nf.format(cR) + " - ";
    saida += GeneroEnum.MASCULINO == this.genero ? " Masculino" : " Feminino";
    ;
    saida += " - Idade: " + ChronoUnit.YEARS.between(nascimento, LocalDate.now());
    saida += " - Renda familiar:" + real.format(rendaFamiliar);

    return saida;
  }

}
