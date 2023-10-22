package escola;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Escola {
  HashMap<String, Aluno> alunos = new HashMap<>();

  public Set<Aluno> getAlunos() {
    return new HashSet<>(alunos.values());
  }

  public void addAluno(Aluno a) {
    alunos.put(a.getMatricula(), a);
  }

  public float getRendaMedia() {
    float r = 0;
    for (Aluno a : alunos.values()) {
      r += a.getRendaFamiliar();
    }
    return r / alunos.size();
  }
}
