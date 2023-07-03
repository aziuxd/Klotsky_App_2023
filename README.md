# Descrizione del Progetto

Questo programma implementa il gioco di Klotski che consiste in una plancia composta da 10 pezzi che possono essere quadrati, rettangoli e un quadrato più grande che funziona come blocco principale.

# Regole

I blocchi sono posizionati dentro una plancia di dimensione 4x5 e si dividono in quadrati di 1x1, rettangoli di 2x1 e un quadrato di 2x2. L'obiettivo del gioco è portare il quadrato principale( quello di dimensioni 2x2 e colorato di rosso) in una determinata posizione cercando di usare meno tempo e mosse possibili.

# Gameplay

È possibile scegliere tra quattro configurazioni iniziali nel menu a tendina chiamato  Puzzle per iniziare a giocare. Per portare il blocco principale nella posizione vincente bisogna selezionare il pezzo che si vuole muovere, per poi muoverlo tramite il mouse, le frecce della tastiera o anche le frecce presenti sullo schermo della partita. I blocchi non possono essere sovrapposti e si possono muovere solo orizzontalmente o verticalmente. Durante la partita sono possibili diverse azioni tramite l’uso dei bottoni presenti sullo schermo:

●	Undo: Permette di tornare indietro di una mossa.
●	NBM: Premendo il tasto si fa la prossima mossa migliore (ovvero la mossa che avvicina il giocatore alla vittoria), se possibile.
●	Reset: Ritorna alla configurazione iniziale della partita ripristinando il tempo e il numero di mosse.
●	Quit: Chiude il programma.

Oltre a queste funzionalità c'è anche un menù a tendina che permette di fare le seguenti operazioni.

●	Save as: Permette di salvare lo stato della partita su un file che verrà inserito dentro la cartella di salvataggio.
●	Open: Carica il salvataggio della partita selezionata.



# Installazione Tramite IDE
Per far funzionare il programma si consiglia di clonare la repository GitHub tramite il seguente link https://github.com/aziuxd/Klotsky_App_2023.git, aprire il progetto scaricato usando un IDE (ad esempio IntelliJ IDEA o Eclipse) ed eseguire il file Main.java presente al percorso : src\klotsky\Main.java 

# Requisiti per l’installazione 
Per poter utilizzare al meglio l’applicazione è richiesto che l’utente installi Java JDK (preferibilmente versione 20 o superiore), reperibile al seguente link : https://www.oracle.com/it/java/technologies/downloads/ e seguire le istruzioni indicate sul sito di Oracle.

# Istruzioni per leggere correttamente il JDOC
Una volta scaricato il progetto, nella cartella principale sarà presente una sotto cartella chiamata documentazione Klotsky_App_2023 all‘interno della quale sarà presente una successiva sottocartella chiamata jdoc; al suo interno ci sarà un file chiamato index.html(il percorso nella cartella principale è il seguente \documentazione Klotsky_App_2023\jdoc\index.html), aprendo tale file sarà possibile visualizzare  la documentazione per l’intera applicazione con lo standard della Java api.

