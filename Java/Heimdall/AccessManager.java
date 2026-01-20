package Java.Heimdall;

/**
 * Gestisce l'accesso ai servizi di un sistema
 *
 * @author Alessandro
 * @version 1.0
 * @since 1.01.2026
 */
public class AccessManager {

    private int securityLevel;
    private String systemStatus;

    /**
     * Constructor
     *
     * @param securityLevel Livello di sicurezza richiesto
     * @param systemStatus  Stato del sistema
     */
    public AccessManager(int securityLevel, String systemStatus) {
        this.securityLevel = securityLevel;
        this.systemStatus = systemStatus;
    }

    /**
     * Garantisce l'accesso se si possiede il livello di sicurezza richiesto
     *
     * @param userId ID dell'utente che vuole accedere
     * @param level  Livello di accesso dell'utente
     * @return <code>true</code> se il livello di sicurezza dell'utente è maggiore del livello richiesto, altrimenti <code>false</code>
     */
    public boolean grantAccess(String userId, int level) {
        return level > securityLevel;
    }

    /**
     * Imposta lo stato del sistema su "CRITICAL"
     */
    public void emergencyLockdown() {
        systemStatus = "CRITICAL";
    }

    /**
     * Calcola il livello di allerte in base al numero di avvisi attivi e lo stato del sistema
     *
     * @param activeAlerts Numero di avvisi attivi
     * @return Il livello di allerte calcolato
     * @throws IllegalArgumentException Se il numero di allerte è negativo
     */
    private int calculateThreatLevel(int activeAlerts) throws IllegalArgumentException {
        if (activeAlerts < 0) {
            throw new IllegalArgumentException("Numero di avvisi non valido");
        }
        if (systemStatus.equals("CRITICAL")) {
            return activeAlerts * 2;
        } else {
            return activeAlerts;
        }
    }

}
