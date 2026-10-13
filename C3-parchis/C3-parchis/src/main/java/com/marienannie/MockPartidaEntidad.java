package com.marienannie;

public class MockPartidaEntidad {
    private String idPartida = "P-001";
    private String estado = "En Espera";

    public void iniciarPartida() {
        this.estado = "Jugando";
        System.out.println("\n   [MOCK ENTIDAD] Reglas de negocio aplicadas exitosamente:");
        System.out.println("   -> La Partida " + idPartida + " ha cambiado su estado a: [" + estado + "]");
    }
}
