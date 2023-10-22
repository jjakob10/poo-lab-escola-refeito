package input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import escola.Aluno;
import escola.Escola;
import escola.enums.GeneroEnum;

public class Input {
  public static Escola lerEntrada(String arquivo) {

    Locale brLocale = Locale.forLanguageTag("pt-BR");
    NumberFormat nf = NumberFormat.getInstance(brLocale);
    Escola escola = new Escola();
    try (FileInputStream f = new FileInputStream(arquivo)) {
      Scanner file = new Scanner(f, "ISO-8859-1");
      while (file.hasNextLine()) {
        String linha = file.nextLine();

        try (Scanner sLinha = new Scanner(linha)) {
          sLinha.useDelimiter(";");
          String matricula = sLinha.next();
          String nome = sLinha.next();
          GeneroEnum genero = GeneroEnum.getGenero(nf.parse(sLinha.next()).intValue());
          Float cr = nf.parse(sLinha.next()).floatValue();
          LocalDate nascimento = LocalDate.parse(sLinha.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          float renda = nf.parse(sLinha.next()).floatValue();
          Aluno a = new Aluno(matricula, nome, cr, genero, nascimento, renda);
          escola.addAluno(a);
        }
      }
      file.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return escola;
  }
}
