package ar.edu.unlam.tallerweb1.delivery;

public enum TipoDeEvento {

    DEPORTIVO(1),
    MUSICAL(2),
    EVENTO(3),
    TEATRO(4),
    RECITAL(5),
    CINE(6),
    MARCHA(7);

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
