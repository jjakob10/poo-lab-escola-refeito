package escola.enums;

public enum GeneroEnum {
  MASCULINO(0), FEMININO(1);

  private int codigo;

  private GeneroEnum(int codigo) {
    this.codigo = codigo;
  }

  public int getCodigo() {
    return this.codigo;
  }

  public static GeneroEnum getGenero(int codigo) {
    if (codigo == MASCULINO.codigo) {
      return MASCULINO;
    } else
      return FEMININO;
  }
}
