Esercizio: Sistema di Gestione Ordini E-commerce
Scenario
Un Ordine (es. Ordine #101 per Mario Rossi) contiene un elenco di righe.

Ogni RigaOrdine rappresenta un articolo e la sua quantità (es. 3 x "Mouse Wireless", 1 x "Tastiera Meccanica").

Ogni Prodotto è un'entità a sé stante con un codice e un prezzo.

Un Ordine ha un ArrayList di RigaOrdine.

Una RigaOrdine ha un Prodotto e una quantita.

Specifiche delle Classi da Creare
Dovrai creare 3 classi distinte:

1. Classe Prodotto
   Questa classe rappresenta un singolo articolo disponibile per la vendita.

Attributi (privati):

sku (String): Un codice identificativo univoco (es. "M-001", "T-002").

nome (String): Il nome del prodotto (es. "Mouse Logitech MX Master").

prezzoUnitario (double): Il costo di un singolo prodotto.

Costruttore:

Un costruttore che accetta sku, nome e prezzoUnitario per inizializzare l'oggetto.

Metodi:

getSku(): Restituisce lo SKU.

getNome(): Restituisce il nome.

getPrezzoUnitario(): Restituisce il prezzo.

toString(): Un metodo (override) per stampare in modo leggibile i dettagli del prodotto (es. "Prodotto [SKU: M-001, Nome: Mouse..., Prezzo: 89.99 €]").

2. Classe RigaOrdine
   Questa classe fa da "ponte". Collega un Prodotto a una quantita specifica all'interno di un ordine.

Attributi (privati):

prodotto (Prodotto): L'oggetto Prodotto a cui questa riga si riferisce (Composizione).

quantita (int): Quanti esemplari di questo prodotto sono stati ordinati.

Costruttore:

Un costruttore che accetta un oggetto Prodotto e una quantita.

Metodi:

getProdotto(): Restituisce l'oggetto Prodotto.

getQuantita(): Restituisce la quantità.

setQuantita(int quantita): Imposta una nuova quantità (ci servirà per aggiornare il carrello).

getSubtotale(): Un metodo che calcola e restituisce il prezzo totale per questa riga ( prezzoUnitario del prodotto \* quantita).

toString(): Un metodo (override) per stampare i dettagli della riga (es. "Riga: [Prodotto: Mouse..., Qta: 2, Subtotale: 179.98 €]").

3. Classe Ordine
   Questa è la classe "contenitore" principale. Gestisce l'intero ordine.

Attributi (privati):

idOrdine (int): Un numero univoco per l'ordine. (Suggerimento: usare una variabile private static int contatoreOrdini = 0; che si incrementa nel costruttore).

nomeCliente (String): Il nome del cliente che ha effettuato l'ordine.

righe (ArrayList<RigaOrdine>): L'elenco di tutte le righe che compongono l'ordine (Composizione).

Costruttore:

Un costruttore che accetta il nomeCliente.

Importante: All'interno del costruttore, devi ricordarti di inizializzare l'ArrayList (es. this.righe = new ArrayList<>();) e di assegnare un idOrdine univoco.

Metodi:

aggiungiProdotto(Prodotto prodotto, int quantita): Questo è il metodo più importante.

Deve cercare nell'ArrayList righe se esiste già una RigaOrdine per quel prodotto (usa getProdotto().getSku() per il confronto).

Se esiste: Aggiorna la quantità di quella RigaOrdine (sommando la nuova quantita a quella esistente, usando setQuantita()).

Se non esiste: Crea un nuovo oggetto RigaOrdine e lo aggiunge all'ArrayList righe.

rimuoviProdotto(String sku):

Cerca nell'ArrayList righe la RigaOrdine che corrisponde allo sku fornito.

Se la trova, la rimuove dall'ArrayList. (Suggerimento: per rimuovere elementi durante un ciclo, è consigliabile usare un Iterator oppure trovare prima l'oggetto da rimuovere e poi chiamare righe.remove(oggettoTrovato) dopo il ciclo).

calcolaTotaleOrdine():

Scorre tutto l'ArrayList righe.

Somma i valori restituiti da getSubtotale() per ogni RigaOrdine.

Restituisce il totale (double).

stampaRicevuta():

Stampa un'intestazione con idOrdine e nomeCliente.

Cicla sull'ArrayList righe e stampa ogni RigaOrdine (usando il suo metodo toString()).

Stampa il totale finale formattato, chiamando calcolaTotaleOrdine().

Compito: Classe TestEcommerce (Java.Biblioteca_smart.Main)
Crea una classe TestEcommerce con un metodo main per verificare che tutto funzioni.

Crea 3 o 4 oggetti Prodotto (es. Mouse, Tastiera, Monitor, Cuffie).

Crea un nuovo Ordine per un cliente (es. "Mario Rossi").

Aggiungi prodotti all'ordine usando aggiungiProdotto():

Aggiungi 1 Mouse.

Aggiungi 1 Tastiera.

Aggiungi 2 Monitor.

Chiama stampaRicevuta() per vedere il riepilogo e il totale parziale.

Simula un aggiornamento del carrello:

Aggiungi un altro Mouse (lo stesso prodotto di prima). Il sistema dovrebbe aggiornare la quantità (portandola a 2), non aggiungere una nuova riga.

Chiama stampaRicevuta() di nuovo per verificare che la quantità del mouse sia 2 e il totale sia aggiornato.

Simula la rimozione di un articolo:

Chiama rimuoviProdotto() usando lo SKU della Tastiera.

Chiama stampaRicevuta() un'ultima volta per mostrare l'ordine finale.

Bonus
Aggiungi alla classe Ordine un attributo stato (usa un enum chiamato StatoOrdine con valori come IN_PREPARAZIONE, SPEDITO, CONSEGNATO) e un metodo aggiornaStato(StatoOrdine nuovoStato). Modifica stampaRicevuta() per mostrare anche lo stato corrente dell'ordine.
