package Java.Gestione_sicurezza;

public class DefenseTurret extends SecurityUnit {

    private String settoreDifesa;

    public DefenseTurret(String codiceSeriale, String modello, int livelloAllerta, String settoreDifesa) {
        super(codiceSeriale, modello, livelloAllerta);
        this.settoreDifesa = settoreDifesa;
    }

    @Override
    void attivaProtocollo() {
        System.out.printf("Torretta %s agganciata al settore %s. Armamenti pronti al fuoco!\n", modello, settoreDifesa);
    }
}
