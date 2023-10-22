import escola.Escola;

import java.text.NumberFormat;
import java.util.Locale;

import escola.Aluno;
import input.Input;

public class App {
    public static void main(String[] args) throws Exception {
        Escola escola = Input.lerEntrada("entrada.csv");
        Locale brLocale = Locale.forLanguageTag("pt-BR");
        NumberFormat nf = NumberFormat.getCurrencyInstance(brLocale);
        for (Aluno a : escola.getAlunos()) {
            System.out.println(a);
        }
        System.out.println("Renda média dos alunos: " + nf.format(escola.getRendaMedia()));
    }
}
