Esercizio: Gestione di una Playlist Musicale 🎵
Obiettivo: Creare un'applicazione Java per gestire una playlist, implementando le classi Canzone e Playlist e testandole con una classe Java.Biblioteca_smart.Main.

1. Classe Canzone
   Definisci una classe Canzone che rappresenti un singolo brano.

Attributi (privati):

titolo (String)

artista (String)

durata (int, in secondi)

Costruttore: Deve accettare e inizializzare titolo, artista e durata.

Metodi getter: Per tutti gli attributi.

Metodo toString(): Deve restituire una stringa formattata come: "'Titolo' di Artista (mm:ss)". Ad esempio, 195 secondi devono diventare (03:15).

2. Classe Playlist
   Definisci una classe Playlist per gestire una collezione di oggetti Canzone.

Attributo (privato):

Un ArrayList<Canzone> per memorizzare i brani.

Costruttore: Inizializza l'ArrayList.

Metodi (pubblici):

aggiungiCanzone(Canzone c): Aggiunge un brano alla lista.

rimuoviCanzone(String titolo): Rimuove un brano cercandolo per titolo (la ricerca non deve essere sensibile a maiuscole/minuscole).

visualizzaPlaylist(): Stampa a console:

Un elenco numerato di tutte le canzoni (usando il loro toString()).

La durata totale della playlist, formattata come HH:mm:ss o mm:ss se le ore sono zero.

Se la playlist è vuota, stampa un messaggio adeguato.

3. Classe Java.Biblioteca_smart.Main
   Crea una classe eseguibile per testare il programma.

Crea un'istanza di Playlist.

Crea e aggiungi almeno 3 canzoni (ricorda di inserire la durata in secondi).

Chiama visualizzaPlaylist() per mostrare il risultato.

Rimuovi una canzone.

Richiama visualizzaPlaylist() per verificare che la lista e la durata totale si siano aggiornate.
