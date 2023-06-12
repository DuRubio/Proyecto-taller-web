package ar.edu.unlam.tallerweb1.domain.enums;

public enum TipoDeEvento {

    Deportivo(1),
    Musical(2),
    Bailable(3),
    Teatral(4),
    Recital(5),
    Cine(6),
    Cultural(7),
    Gastronomico(8),
    Feria(9),
    Marcha(10);

    private int valor;
    TipoDeEvento(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TipoDeEvento fromValor(int valor) {
        for (TipoDeEvento tipo : TipoDeEvento.values()) {
            if (tipo.ordinal() == valor) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor inválido para TipoDeEvento: " + valor);
    }
}
