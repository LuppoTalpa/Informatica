Classe TestEcosistema (Java.Biblioteca_smart.Main)
Crea una classe con un metodo main per testare la gerarchia:

Crea l'Ecosistema (Livello 1): Crea un oggetto Ecosistema (es. "Riserva Naturale").

Crea le Zone (Livello 2): Crea due oggetti Zona (es. "Foresta Boreale", "Fiume").

Aggiungi le due zone all'ecosistema.

Crea gli Animali (Livello 3):

Crea 3 animali (es. 2 "Coniglio", 1 "Lupo").

Crea altri 2 animali (es. 1 "Salmone", 1 "Orso").

Popola le Zone:

Aggiungi i primi 3 animali alla zona "Foresta Boreale".

Aggiungi gli altri 2 animali alla zona "Fiume".

Verifica Attributi Statici:

Verifica ID Univoci: Stampa i dettagli degli animali. Anche se ci sono due "Coniglio", i loro ID (generati da contatoreID) devono essere diversi (es. 1 e 2). L'orso potrebbe essere ID 5.

Verifica Limite: Prova ad aggiungere 10 animali (puoi creare un ciclo) alla zona "Fiume" per verificare che rifiuti l'undicesimo animale (a causa di CAPIENZA_MASSIMA_ZONA).

Stampa Report Finale: Chiama mostraReportEcosistema() sull'oggetto Ecosistema per vedere una panoramica completa di quali animali vivono in quali zone.