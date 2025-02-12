# Traditional T9
Questo manuale spiega come configurare e utilizzare Traditional T9 in diversi scenari. Per le istruzioni di installazione e le informazioni sulle versioni "lite" e "full", consultare la [Guida all’installazione](https://github.com/sspanak/tt9/blob/master/docs/installation.md) su GitHub. Infine, è possibile dare un’occhiata alla [pagina principale del repository](https://github.com/sspanak/tt9), che include tutto il codice sorgente, una guida per sviluppatori, la politica sulla privacy e la documentazione supplementare.

## Configurazione iniziale
Dopo l’installazione, per prima cosa bisogna abilitare Traditional T9 come tastiera Android. Per farlo, cliccare sull'icona del launcher. Se è necessaria un'azione, tutte le opzioni tranne Configurazione Iniziale saranno disabilitate e apparirà l'etichetta: "TT9 è disabilitato". Andare su Configurazione Iniziale e abilitarlo.

_Se l'icona non appare subito dopo l’installazione, riavviare il telefono, e dovrebbe apparire. Ciò è dovuto al tentativo di Android di risparmiare batteria non aggiornando la lista delle app appena installate._

### Utilizzo su telefoni solo touchscreen
Sui dispositivi touchscreen, si consiglia vivamente di disabilitare il correttore ortografico di sistema. Non può essere usato quando si digita con i tasti numerici, quindi è possibile risparmiare batteria disabilitandolo.

Un altro problema è che potrebbe mostrare un fastidioso popup "Aggiungi Parola", che aggiunge parole alla tastiera di sistema predefinita (solitamente, Gboard) e non al dizionario di Traditional T9. Di nuovo, per evitare tali situazioni, il correttore ortografico di sistema deve essere disabilitato.

Se è necessario eseguire questo passaggio, l'opzione "Correttore ortografico di sistema" nella schermata Configurazione Iniziale sarà attiva. Cliccarci per disabilitare il componente di sistema. Se tale opzione non è presente, non è necessario fare altro.

Dopo aver completato la configurazione, dare un'occhiata alla sezione [Tastierino su Schermo](#tastierino-su-schermo) per ulteriori suggerimenti e trucchi.

### Abilitare la Modalità Predittiva
La Modalità Predittiva richiede che venga caricato un dizionario di lingua per fornire suggerimenti di parole. È possibile attivare le lingue abilitate e caricare i loro dizionari da Schermata Impostazioni → [Lingue](#opzioni-di-lingua). In caso di dimenticanza, Traditional T9 caricherà automaticamente il dizionario quando si inizia a digitare. Per ulteriori informazioni, [vedi sotto](#opzioni-di-lingua).

#### Note per telefoni di fascia bassa
Il caricamento del dizionario può saturare i telefoni di fascia bassa. Quando si usa la versione "lite" di TT9, ciò può causare l'interruzione dell’operazione da parte di Android. Se il caricamento dura più di 30 secondi, collegare il caricatore o assicurarsi che lo schermo rimanga acceso durante il caricamento.

È possibile evitare quanto sopra utilizzando invece la versione "full".

#### Note per Android 13 o versioni successive
Di default, le notifiche per le nuove app installate sono disabilitate. Si consiglia di abilitarle. In questo modo, si riceverà una notifica quando ci sono aggiornamenti del dizionario e, una volta scelto di installarli, TT9 mostrerà lo stato di caricamento. Gli aggiornamenti vengono rilasciati al massimo una volta al mese, quindi non ci si deve preoccupare di ricevere troppo spam.

È possibile abilitare le notifiche andando su Impostazioni → Lingue e attivando Notifiche del Dizionario.

_Se si decide di tenerle disattivate, TT9 continuerà a funzionare senza problemi, ma sarà necessario gestire i dizionari manualmente._

## Tasti Rapidi

Tutti i tasti rapidi possono essere riconfigurati o disabilitati da Impostazioni → Tastierino → Seleziona Tasti Rapidi.

### Tasti di Digitazione

#### Tasto Suggerimento Precedente (Default: D-pad Sinistra):
Seleziona il suggerimento di parola/lettera precedente.

#### Tasto Suggerimento Successivo (Default: D-pad Destra):
Seleziona il suggerimento di parola/lettera successivo.

#### Tasto Filtro Suggerimenti (Default: D-pad Su):
_Solo modalità predittiva._

- **Pressione singola**: Filtra l'elenco dei suggerimenti, lasciando solo quelli che iniziano con la parola corrente. Non importa se è una parola completa o meno. Ad esempio, digitare "remin" e premere Filtro. Lascerà tutte le parole che iniziano con "remin": "remin" stesso, "ricordare", "ricorda", "ricordato", "ricordando" e così via.
- **Pressione doppia**: Espandi il filtro fino al suggerimento completo. Ad esempio, digitare "remin" e premere Filtro due volte. Filtrerà prima "remin", quindi estenderà il filtro a "ricordare". Si può continuare a espandere il filtro fino a ottenere la parola più lunga del dizionario.

Il filtro è utile anche per digitare parole sconosciute. Diciamo che si vuole digitare "Anakin", che non è nel dizionario. Iniziare con "A", quindi premere Filtro per nascondere "B" e "C". Ora premere il tasto 6. Poiché il filtro è attivo, oltre alle parole reali del dizionario, fornirà tutte le combinazioni possibili per 1+6: "A..." + "m", "n", "o". Selezionare "n" e premere Filtro per confermare la selezione e produrre "An". Ora premendo il tasto 2, verranno visualizzati "An..." + "a", "b", e "c". Selezionare "a" e continuare fino a ottenere "Anakin".

Quando il filtro è abilitato, il testo di base diventa grassetto e in corsivo.

#### Tasto Cancella Filtro (Default: D-pad Giù):
_Solo modalità predittiva._

Cancella il filtro di suggerimento, se applicato.

#### D-pad Centro (OK o INVIO):
- Quando sono visualizzati i suggerimenti, digita il suggerimento attualmente selezionato.
- Altrimenti, esegue l'azione predefinita per l'applicazione corrente (ad esempio invia un messaggio, vai a un URL o digita una nuova riga).

_**Nota:** Ogni applicazione decide autonomamente cosa fare quando si preme OK e TT9 non ha alcun controllo su questo._

_**Nota 2:** Per inviare messaggi con OK nelle applicazioni di messaggistica, è necessario abilitare l'impostazione "Invia con INVIO" o una simile. Se l'applicazione non dispone di questa impostazione, probabilmente non supporta l'invio dei messaggi in questo modo. In tal caso, utilizzare l'app KeyMapper dal [Play Store](https://play.google.com/store/apps/details?id=io.github.sds100.keymapper) o da [F-droid](https://f-droid.org/packages/io.github.sds100.keymapper/). KeyMapper può rilevare le app di chat e simulare un tocco sul pulsante di invio del messaggio premendo o tenendo premuto un tasto hardware. Consultare la [guida rapida](https://docs.keymapper.club/quick-start/) per ulteriori informazioni._

#### Tasto 0:
- **In modalità 123:**
  - **Premere:** digita "0".
  - **Tenere premuto:** digita caratteri speciali/matematici.
  - **Tenere premuto "0", quindi premere Maiusc (Default: tenere premuto "0", premere "✱"):** digita caratteri di valuta
- **In modalità ABC:**
  - **Premere:** digita spazio, nuova riga o caratteri speciali/matematici.
  - **Tenere premuto:** digita "0".
  - **Premere "0", quindi premere Maiusc (Default: premere "0", "✱"):** digita caratteri di valuta
- **In modalità Predittiva:**
  - **Premere:** digita uno spazio, una nuova linea, "0" o caratteri speciali/matematici.
  - **Premere due volte:** digita il carattere assegnato nelle impostazioni della modalità predittiva. (Default: ".")
  - **Tenere premuto:** digita "0".
  - **Premere "0", quindi premere Maiusc (Default: premere "0", "✱"):** digita caratteri di valuta
- **In modalità Cheonjiin (Coreano):**
  - **Premere:** digita "ㅇ" e "ㅁ".
  - **Tenere premuto:** digita uno spazio, una nuova linea, "0" o caratteri speciali/matematici.
  - **Tenere premuto "0", poi premere Maiusc (Predefinito: tenere premuto "0", premere "✱"):** Digita caratteri monetari.

#### Tasto 1:
- **In modalità 123:**
  - **Premere:** digita "1".
  - **Tenere premuto:** digita caratteri di punteggiatura
- **In modalità ABC:**
  - **Premere:** digita caratteri di punteggiatura
  - **Tenere premuto:** digita "1".
- **In modalità Predittiva:**
  - **Premere:** digita caratteri di punteggiatura
  - **Premere più volte:** digita emoji
  - **Premere 1-1-3:** digita emoji aggiunti personalizzati (è necessario averne aggiunti alcuni utilizzando [il Tasto Aggiungi Parola](#tasto-aggiungi-parola))
  - **Tenere premuto:** digita "1".
- **In modalità Cheonjiin (Coreano):**
  - **Premere:** digita la vocale "ㅣ".
  - **Tenere premuto:** digita caratteri di punteggiatura.
  - **Tenere premuto, quindi premere:** digita emoji.
  - **Tenere premuto 1, premere 1, poi 3:** digita emoji aggiunti personalizzati (è necessario averne aggiunti alcuni utilizzando [il Tasto Aggiungi Parola](#tasto-aggiungi-parola))

#### Tasti da 2 a 9:
- **In modalità 123:** digita il rispettivo numero
- **In modalità ABC e Predittiva:** digita una lettera o tenere premuto per digitare il numero corrispondente.

### Tasti Funzione

#### Tasto Aggiungi Parola:
Aggiunge una nuova parola al dizionario per la lingua corrente.

È anche possibile aggiungere nuove emoji e accedervi premendo 1-1-3. Indipendentemente dalla lingua selezionata, tutte le emoji saranno disponibili in tutte le lingue.

#### Tasto Backspace (Indietro, Canc, o Backspace):
Cancella semplicemente il testo.

Se il telefono ha un tasto dedicato "Canc" o "Cancella", non è necessario impostare nulla nelle Impostazioni, a meno che non si desideri avere un altro tasto Backspace. In questo caso, l'opzione vuota: "--" sarà pre-selezionata automaticamente.

Su telefoni che hanno un tasto "Elimina"/"Indietro" combinato, quel tasto sarà selezionato automaticamente. Tuttavia, è possibile assegnare la funzione "Backspace" a un altro tasto, così "Indietro" servirà solo per navigare.

_**NB:** Usare "Indietro" come backspace non funziona in tutte le applicazioni, in particolare Firefox, Spotify e Termux. Possono assumere il pieno controllo del tasto e ridefinirne la funzione, significando che farà ciò che i creatori dell’app hanno deciso. Purtroppo, non è possibile fare nulla, poiché "Indietro" ha un ruolo speciale in Android e il suo utilizzo è limitato dal sistema._

_**NB 2:** Tenendo premuto il tasto "Indietro" si attiverà sempre l'azione predefinita del sistema (cioè mostrare l’elenco delle applicazioni in esecuzione)._

_In questi casi, si potrebbe assegnare un altro tasto (tutti gli altri tasti sono completamente utilizzabili), oppure usare il tasto backspace su schermo._

#### Tasto Modalità di Input Successiva (Default: premere #):
Cicla tra le modalità di input (abc → Predittiva → 123).

_La modalità predittiva non è disponibile nei campi password._

_Nei campi a soli numeri, cambiare modalità non è possibile. In questi casi, il tasto torna alla sua funzione predefinita (cioè digita "#")._

#### Tasto Modifica Testo:
Mostra il pannello di modifica del testo, che consente di selezionare, tagliare, copiare e incollare testo. È possibile chiudere il pannello premendo di nuovo il tasto "✱" o, nella maggior parte delle applicazioni, premendo il tasto Indietro. Per dettagli, vedere [sotto](#modifica-testo).

#### Tasto Lingua Successiva (Default: tenere premuto #):
Seleziona la lingua successiva, quando sono abilitate più lingue nelle Impostazioni.

#### Tasto Seleziona Tastiera:
Apre la finestra di dialogo Cambia Tastiera di Android, dove è possibile selezionare una tastiera tra tutte quelle installate.

#### Tasto Maiusc (Default: premere ✱):
- **Quando si digita testo:** Passa tra maiuscole e minuscole.
- **Quando si digitano caratteri speciali con il tasto 0**: Mostra il gruppo di caratteri successivo.

#### Tasto Mostra Impostazioni:
Apre la schermata di configurazione Impostazioni. Qui è possibile scegliere le lingue per digitare, configurare i tasti rapidi del tastierino, cambiare l’aspetto dell’applicazione o migliorare la compatibilità con il proprio telefono.

#### Tasto Input Vocale:
Attiva l'input vocale sui telefoni che lo supportano. Vedere [sotto](#input-vocale) per ulteriori informazioni.

#### Tasto Elenco Comandi / aka Tavolozza Comandi / (Default: tenere premuto ✱):
Mostra un elenco di tutti i comandi (o funzioni).

Molti telefoni hanno solo due o tre pulsanti "liberi" che possono essere usati come tasti rapidi. Tuttavia, Traditional T9 ha molte più funzioni, il che significa che semplicemente non c’è spazio per tutte sul tastierino. La Tavolozza Comandi risolve questo problema. Permette di invocare le funzioni aggiuntive (o comandi) usando combinazioni di tasti.

Di seguito è riportato un elenco dei comandi possibili:
- **Mostra la schermata delle impostazioni (Combinazione predefinita: tenere premuto ✱, tasto 1).** Uguale a premere [Mostra Impostazioni](#tasto-mostra-impostazioni).
- **Aggiungi una parola (Combinazione predefinita: tenere premuto ✱, tasto 2).** Uguale a premere [Aggiungi Parola](#tasto-aggiungi-parola).
- **Input Vocale (Combinazione predefinita: tenere premuto ✱, tasto 3).** Uguale a premere [Input Vocale](#tasto-input-vocale).
- **Modifica Testo (Combinazione predefinita: tenere premuto ✱, tasto 5).** Uguale a premere [Modifica Testo](#tasto-modifica-testo).
- **Seleziona una Tastiera Diversa (Combinazione predefinita: tenere premuto ✱, tasto 8).** Uguale a premere [Seleziona Tastiera](#tasto-seleziona-tastiera).

_Questo tasto non fa nulla quando il Layout dello Schermo è impostato su "Tastierino Virtuale" perché tutti i tasti per tutte le funzioni possibili sono già disponibili sullo schermo._

## Input Vocale
La funzione di input vocale consente l’inserimento vocale, simile a Gboard. Come tutte le altre tastiere, Traditional T9 non esegue il riconoscimento vocale autonomamente, ma richiede al telefono di farlo.

_Il tasto Input Vocale è nascosto sui dispositivi che non lo supportano._

### Dispositivi Supportati
Sui dispositivi con Google Services, verrà utilizzata l'infrastruttura Google Cloud per convertire le parole in testo. Per usare questo metodo, è necessario essere connessi a una rete Wi-Fi o abilitare i dati mobili.

Sui dispositivi senza Google, se il dispositivo dispone di un’app assistente vocale o se la tastiera nativa supporta l'input vocale, verrà utilizzata una di queste per il riconoscimento vocale. Questo metodo è meno preciso rispetto a Google: non funziona in ambienti rumorosi e riconosce solitamente solo frasi semplici, come: "apri calendario" o "riproduci musica". Il vantaggio è che funziona offline.

Altri telefoni senza Google generalmente non supportano l'input vocale. I telefoni cinesi non dispongono di funzionalità di riconoscimento vocale a causa delle politiche di sicurezza cinesi. Su questi telefoni, è possibile abilitare il supporto per l'input vocale installando l’applicazione Google, nome del pacchetto: "com.google.android.googlequicksearchbox".

## Tastierino su Schermo
Sui telefoni solo touchscreen, è disponibile un tastierino su schermo completamente funzionale, che verrà abilitato automaticamente. Se, per qualche motivo, il tuo telefono non è stato rilevato come touchscreen, attivalo andando su Impostazioni → Aspetto → Layout su Schermo e selezionando "Tastierino Virtuale".

Se hai sia un touchscreen che un tastierino fisico e preferisci avere più spazio sullo schermo, disabilita i tasti software da Impostazioni → Aspetto.

Si consiglia anche di disabilitare il comportamento speciale del tasto "Indietro" come "Backspace". È utile solo con un tastierino hardware. Di solito ciò avviene automaticamente, ma se non accade, vai su Impostazioni → Tastierino → Seleziona Tasti Rapidi → Tasto Backspace, quindi seleziona l'opzione "--".

### Panoramica dei Tasti Virtuali
La tastiera su schermo funziona come il tastierino numerico di un telefono con tasti fisici. Se un tasto offre una sola funzione, ha un'etichetta (o un'icona) che indica quella funzione. Se il tasto ha una funzione secondaria da attivare tenendolo premuto, avrà due etichette (o icone).

Di seguito è riportata una descrizione dei tasti con più di una funzione.

#### Tasto F2 destro (secondo tasto dall'alto nella colonna di destra)
_Solo in modalità predittiva._

- **Premere:** Filtra l'elenco dei suggerimenti. Vedi [sopra](#tasto-filtro-suggerimenti-default-d-pad-su) per sapere come funziona il filtro delle parole.
- **Tenere premuto:** Cancella il filtro, se attivo.

#### Tasto F3 destro (terzo tasto dall'alto nella colonna di destra)
- **Premere:** Apre le opzioni per copiare, incollare e modificare il testo.
- **Tenere premuto:** Attiva l'immissione vocale.

#### Tasto F4 sinistro (il tasto in basso a sinistra)
- **Premere:** Cambia modalità di input (abc → Predittiva → 123).
- **Tenere premuto:** Cambia lingua, se più lingue sono state abilitate nelle impostazioni.
- **Scorrere orizzontalmente:** Passa all'ultima tastiera utilizzata, diversa da TT9.
- **Scorrere verticalmente:** Apre il dialogo Cambia tastiera di Android, dove è possibile selezionare tra tutte le tastiere installate.

_Il tasto mostrerà una piccola icona a forma di globo quando hai abilitato più di una lingua in Impostazioni → Lingue. L'icona indica che è possibile cambiare lingua tenendo premuto il tasto._

### Ridimensionamento del Pannello Tastiera Durante la Digitazione
A volte potresti trovare che il Tastierino Virtuale occupi troppo spazio, impedendoti di vedere cosa stai digitando o alcuni elementi dell’app. Se è così, puoi ridimensionarlo tenendo premuto e trascinando il tasto Impostazioni/Tavolozza Comandi o trascinando la Barra di Stato (dove è visualizzata la lingua corrente o modalità di digitazione). Quando l’altezza diventa troppo ridotta, il layout cambierà automaticamente a "Tasti Funzione" o "Solo Lista Suggerimenti". Analogamente, ingrandendo il layout tornerà al "Tastierino Virtuale". È anche possibile fare doppio tap sulla barra di stato per minimizzare o massimizzare istantaneamente.

_Ridimensionare Traditional T9 ridimensiona anche l'applicazione corrente, ma questa operazione è molto impegnativa. Potrebbe causare sfarfallii o rallentamenti su molti telefoni, anche di fascia alta._

### Modificare l'Altezza dei Tasti
È anche possibile modificare l'altezza dei tasti su schermo. Vai su Impostazioni → Aspetto → Altezza Tasti su Schermo e regolala come desideri.

L’impostazione predefinita di 100% offre un buon equilibrio tra dimensioni dei tasti e spazio sullo schermo occupato. Se hai dita grandi, puoi aumentarla leggermente, mentre su uno schermo più grande, come un tablet, potresti ridurla.

_Se lo spazio disponibile sullo schermo è limitato, TT9 ignorerà questa impostazione e ridurrà automaticamente l’altezza, per lasciare spazio all'applicazione corrente._

## Modifica Testo
Dal pannello di Modifica Testo, puoi selezionare, tagliare, copiare e incollare testo, come su una tastiera per computer. Per uscire da Modifica Testo, premi il tasto "✱" o il tasto Indietro (eccetto in browser, Spotify e altre applicazioni). Oppure premi il tasto lettere sulla Tastiera su Schermo.

Di seguito è riportato un elenco dei possibili comandi di testo:
1. Seleziona il carattere precedente (come Shift+Freccia Sinistra su una tastiera per computer)
2. Seleziona nessuno
3. Seleziona il carattere successivo (come Shift+Freccia Destra)
4. Seleziona la parola precedente (come Ctrl+Shift+Freccia Sinistra)
5. Seleziona tutto
6. Seleziona la parola successiva (come Ctrl+Shift+Freccia Destra)
7. Taglia
8. Copia
9. Incolla

Per facilitare la modifica, sono attivi anche i tasti backspace, spazio e OK.

## Schermata Impostazioni
Nella schermata delle impostazioni, puoi scegliere le lingue per la digitazione, configurare i tasti rapidi del tastierino, cambiare l'aspetto dell'applicazione o migliorare la compatibilità con il telefono.

### Come accedere alle Impostazioni?

#### Metodo 1
Clicca sull'icona di avvio di Traditional T9.

#### Metodo 2 (usando un touchscreen)
- Tocca un campo di testo o numero per attivare TT9.
- Usa il pulsante a forma di ingranaggio su schermo.

#### Metodo 3 (usando una tastiera fisica)
- Inizia a digitare in un campo di testo o numero per attivare TT9.
- Apri l'elenco dei comandi utilizzando il pulsante degli strumenti su schermo o premendo il tasto assegnato [Predefinito: Tenere premuto ✱].
- Premi il tasto 2.

### Navigare nelle Impostazioni
Se hai un dispositivo con tastierino fisico, ci sono due modi per navigare nelle Impostazioni.

1. Usa i tasti Su/Giù per scorrere e OK per aprire o attivare un'opzione.
2. Premi i tasti da 1 a 9 per selezionare l'opzione corrispondente e premi due volte per aprirla/attivarla. La doppia pressione funziona ovunque tu sia nella schermata. Per esempio, anche se ti trovi in cima, premendo due volte il tasto 3 si attiverà la terza opzione. Infine, il tasto 0 è una comoda scorciatoia per scorrere fino alla fine ma non apre l'ultima opzione.

### Opzioni di Lingua

#### Caricamento di un Dizionario
Dopo aver abilitato una o più lingue nuove, devi caricare i rispettivi dizionari per la Modalità Predittiva. Una volta caricato, il dizionario resterà disponibile fino a quando non utilizzerai una delle opzioni "cancella". In questo modo, puoi abilitare e disabilitare le lingue senza dover ricaricare i dizionari ogni volta. Basta farlo una sola volta, solo la prima volta.

Significa anche che, se devi iniziare a usare la lingua X, puoi disabilitare tutte le altre lingue, caricare solo il dizionario X (risparmiando tempo!), e poi riattivare tutte le lingue che usavi prima.

Ricorda che ricaricare un dizionario reimposta la popolarità dei suggerimenti ai valori predefiniti. Tuttavia, non c’è nulla di cui preoccuparsi. Di solito, noterai poche o nessuna differenza nell'ordine dei suggerimenti, a meno che tu non usi spesso parole insolite.

#### Caricamento Automatico del Dizionario

Se salti o dimentichi di caricare un dizionario dalla schermata Impostazioni, il caricamento avverrà automaticamente quando apri un'applicazione dove puoi digitare e passi alla Modalità Predittiva. Verrà visualizzato un messaggio che ti chiederà di attendere il completamento del caricamento e poi potrai iniziare a digitare subito.

Se cancelli uno o più dizionari, NON verranno ricaricati automaticamente. Dovrai farlo manualmente. Verranno ricaricati automaticamente solo i dizionari delle nuove lingue abilitate.

#### Eliminazione di un Dizionario
Se smetti di usare le lingue X o Y, puoi disabilitarle e anche usare "Cancella Non Selezionati" per liberare spazio di archiviazione.

Per cancellare tutto, indipendentemente dalla selezione, usa "Cancella Tutto".

In tutti i casi, le parole aggiunte personalizzate verranno conservate e ripristinate una volta ricaricato il dizionario.

#### Parole Aggiunte
L'opzione "Esporta" ti permette di esportare tutte le parole aggiunte, per tutte le lingue, inclusi eventuali emoji, in un file CSV. Successivamente, puoi utilizzare il file CSV per migliorare Traditional T9! Vai su GitHub e condividi le parole in una [nuova issue](https://github.com/sspanak/tt9/issues) o una [pull request](https://github.com/sspanak/tt9/pulls). Dopo la revisione e l’approvazione, saranno incluse nella prossima versione.

Con "Importa", puoi importare un CSV precedentemente esportato. Tuttavia, ci sono alcune restrizioni:
- È possibile importare solo parole composte da lettere. Apostrofi, trattini, altri segni di punteggiatura o caratteri speciali non sono ammessi.
- Gli emoji non sono ammessi.
- Un file CSV può contenere un massimo di 250 parole.
- È possibile importare fino a 1000 parole, quindi al massimo 4 file da 250 parole ciascuno. Oltre questo limite, è comunque possibile aggiungere parole durante la digitazione.

Con "Elimina", puoi cercare e cancellare parole errate o altre che non vuoi nel dizionario.

### Opzioni di Compatibilità
Per alcune applicazioni o dispositivi, è possibile abilitare opzioni speciali, che miglioreranno la compatibilità con Traditional T9. Puoi trovarle alla fine di ciascuna schermata di impostazioni, nella sezione Compatibilità.

#### Metodo Alternativo di Scorrimento dei Suggerimenti
_In: Impostazioni → Aspetto._

Su alcuni dispositivi, in Modalità Predittiva, potrebbe non essere possibile scorrere la lista fino alla fine o potrebbe essere necessario scorrere avanti e indietro più volte prima che appaia l'ultimo suggerimento. Il problema si verifica a volte su Android 9 o versioni precedenti. Abilita l'opzione se riscontri questo problema.

#### Sempre in Primo Piano
_In: Impostazioni → Aspetto._

Su alcuni telefoni, in particolare Sonim XP3plus (XP3900), Traditional T9 potrebbe non apparire quando inizi a digitare, oppure potrebbe essere parzialmente coperto dai tasti software. In altri casi, potrebbero apparire delle barre bianche attorno alla tastiera. Il problema può verificarsi in un'applicazione specifica o in tutte. Per evitarlo, abilita l'opzione "Sempre in Primo Piano".

#### Protezione dalla Ripetizione dei Tasti
_In: Impostazioni → Tastierino._

I telefoni CAT S22 Flip e Qin F21 sono noti per i loro tastierini di bassa qualità, che si deteriorano rapidamente e iniziano a registrare più clic per una singola pressione. Potresti notarlo mentre scrivi o navighi nei menu del telefono.

Per i telefoni CAT, l'impostazione consigliata è di 50-75 ms. Per Qin F21, prova con 20-30 ms. Se il problema persiste, aumenta il valore leggermente, ma cerca di mantenerlo il più basso possibile.

_**Nota:** Più alto è il valore impostato, più lentamente dovrai digitare. TT9 ignorerà le pressioni dei tasti molto rapide._

_**Nota 2:** Oltre a ciò, i telefoni Qin potrebbero non rilevare le pressioni prolungate dei tasti. Sfortunatamente, in questo caso non c'è nulla che si possa fare._

#### I pannelli degli sticker ed emoji su Telegram/Snapchat non si aprono
Questo accade se stai utilizzando uno dei layout di dimensioni ridotte. Al momento, non esiste una soluzione definitiva, ma puoi utilizzare la seguente procedura temporanea:
- Vai su Impostazioni → Aspetto e abilita il Tastierino su Schermo.
- Torna alla chat e clicca sul pulsante emoji o sticker. Ora appariranno.
- Puoi ora tornare alle impostazioni e disabilitare il tastierino su schermo. I pannelli degli emoji e degli sticker rimarranno accessibili fino a quando non riavvii l'app o il telefono.

#### Traditional T9 non appare immediatamente in alcune applicazioni
Se hai aperto un'applicazione in cui puoi scrivere, ma TT9 non appare automaticamente, inizia semplicemente a digitare e apparirà. In alternativa, premere i tasti di scelta rapida per cambiare [la modalità di input](#tasto-modalità-di-input-successiva-default-premere) o [la lingua](#tasto-lingua-successiva-default-tenere-premuto) può anche far apparire TT9, quando è nascosto.

Su alcuni dispositivi, TT9 potrebbe rimanere invisibile, indipendentemente da ciò che fai. In questi casi, devi abilitare [Sempre in Primo Piano](#sempre-in-primo-piano).

**Spiegazione lunga.** Il motivo di questo problema è che Android è progettato principalmente per dispositivi touchscreen. Di conseguenza, si aspetta che tu tocchi il campo di testo/numero per mostrare la tastiera. È possibile far apparire TT9 senza questa conferma, ma poi, in alcuni casi, Android dimentica di nasconderlo quando dovrebbe. Ad esempio, potrebbe rimanere visibile dopo aver composto un numero di telefono o dopo aver inviato testo in un campo di ricerca.

Per questi motivi, per seguire gli standard attesi di Android, il controllo è nelle tue mani. Basta premere un tasto per "toccare" lo schermo e continuare a digitare.

#### Sul Qin F21 Pro, tenendo premuto il tasto 2 o il tasto 8 si alza o abbassa il volume invece di digitare un numero
Per attenuare questo problema, vai su Impostazioni → Aspetto e abilita "Icona di Stato". TT9 dovrebbe rilevare il Qin F21 e abilitare le impostazioni automaticamente, ma in caso di fallimento del rilevamento automatico, o se hai disabilitato l'icona per qualche motivo, devi attivarla per consentire il corretto funzionamento di tutti i tasti.

**Spiegazione lunga.** Il Qin F21 Pro (e possibilmente anche il F22) ha un'applicazione di tasti rapidi che consente di assegnare le funzioni Volume Su e Volume Giù ai tasti numerici. Di default, il gestore dei tasti rapidi è abilitato, e tenendo premuto il tasto 2 il volume aumenta, mentre tenendo premuto l'8 il volume diminuisce. Tuttavia, quando non c'è un'icona di stato, il gestore presuppone che non sia attiva alcuna tastiera e regola il volume, anziché lasciare che Traditional T9 gestisca il tasto e digiti un numero. Quindi, abilitare l'icona bypassa semplicemente il gestore dei tasti rapidi e tutto funziona correttamente.

#### Problemi generali sui telefoni Xiaomi
Xiaomi ha introdotto diverse autorizzazioni non standard sui loro telefoni, che impediscono il corretto funzionamento della tastiera virtuale su schermo di Traditional T9. Più precisamente, i tasti "Mostra Impostazioni" e "Aggiungi Parola" potrebbero non svolgere le rispettive funzioni. Per risolvere questo problema, devi concedere a TT9 i permessi di "Visualizza finestra pop-up" e "Visualizza finestra pop-up in esecuzione in background" dalle impostazioni del telefono. [Questa guida](https://parental-control.flashget.com/how-to-enable-display-pop-up-windows-while-running-in-the-background-on-flashget-kids-on-xiaomi) per un'altra applicazione spiega come fare.

È anche altamente raccomandato concedere l'autorizzazione per la "Notifica permanente". Questa è simile all'autorizzazione per le "Notifiche" introdotta in Android 13. Vedi [sopra](#note-per-android-13-o-versioni-successive) per ulteriori informazioni sul motivo per cui è necessaria.

_I problemi di Xiaomi sono stati discussi in [questa issue su GitHub](https://github.com/sspanak/tt9/issues/490)._

#### L'Input Vocale impiega molto tempo per fermarsi
È [un problema noto](https://issuetracker.google.com/issues/158198432) su Android 10 che Google non ha mai risolto. Non è possibile attenuarlo dal lato TT9. Per fermare l'operazione di Input Vocale, resta in silenzio per qualche secondo. Android spegne il microfono automaticamente quando non rileva alcun suono.

## Domande Frequenti

#### Non puoi aggiungere la funzione X?
No.

Ognuno ha le proprie preferenze. Alcuni vogliono tasti più grandi, altri in un ordine diverso, alcuni vogliono un tasto di scelta rapida per digitare ".com" e altri sentono la mancanza del loro vecchio telefono o tastiera. Ma per favore, capisci che sto lavorando a questo progetto nel mio tempo libero e su base volontaria. È impossibile soddisfare migliaia di richieste diverse, alcune delle quali si contraddicono tra loro.

Henry Ford una volta disse: "Il cliente può avere l'auto di qualsiasi colore desideri, purché sia nera." Allo stesso modo, Traditional T9 è essenziale, efficace e gratuito, ma quello che vedi è quello che ottieni.

#### Non puoi renderlo più simile a Sony Ericsson o Xperia, Nokia C2, Samsung o a un'altra tastiera software?
No.

Traditional T9 non è pensato per essere un sostituto o un'app clone. Ha un design unico, ispirato principalmente al Nokia 3310 e 6303i. E sebbene catturi l'essenza dei classici, offre un'esperienza propria che non replica esattamente nessun dispositivo.

#### Dovresti copiare Touchpal, è la migliore tastiera del mondo!
No, non dovrei. Vedi i punti precedenti.

Touchpal era la migliore tastiera nel 2015, quando non aveva una vera concorrenza. Tuttavia, da allora le cose sono cambiate. Ecco un confronto tra Traditional T9 e Touchpal:

_**Traditional T9**_
- Rispetta la tua privacy.
- Non contiene pubblicità ed è gratuito.
- Supporta un'ampia gamma di dispositivi: telefoni base e TV con tastiere hardware, oltre a smartphone e tablet solo touchscreen.
- Offre un vero layout T9 a 12 tasti per ogni lingua.
- Fornisce suggerimenti di parole migliorati. Ad esempio, se provi a digitare espressioni con textonimi come "go in", imparerà a non suggerire "go go" o "in in", ma l'espressione corretta che avevi in mente.
- Tutto ciò che digiti rimane sul tuo telefono. Nessuna informazione viene inviata altrove.
- È open source, permettendoti di controllare tutto il codice sorgente e i dizionari, contribuire al progetto per migliorarlo (molti utenti hanno aiutato correggendo bug e aggiungendo nuove lingue e traduzioni) o persino creare una versione modificata in base alle tue preferenze e visione.
- Ha un design pulito e altamente leggibile che si integra con il sistema. Non ci sono elementi superflui che distraggono, permettendoti di concentrarti sulla digitazione.
- La velocità di caricamento del dizionario è lenta.

_**Touchpal**_
- Chiede in modo aggressivo l'accesso a tutto il tuo dispositivo e ai tuoi contatti; scrive file casuali ovunque; alla fine è stato bandito dal Play Store perché si comportava come un virus.
- Pieno di pubblicità.
- Supporta solo dispositivi touchscreen.
- Non è una vera tastiera T9. Offre un layout T9 solo in alcune lingue. Inoltre, alcuni layout sono errati (ad esempio, nel layout bulgaro manca una lettera e alcune lettere sono scambiate tra il tasto 8 e il tasto 9).
- Quando si digitano textonimi consecutivi, suggerisce solo l'ultima parola selezionata. Ad esempio, se provi a digitare "go in", mostrerà solo "go go" o "in in".
- I suggerimenti basati sul cloud potrebbero migliorare la precisione. Tuttavia, affinché ciò funzioni, tu e tutti gli altri utenti dovreste inviare tutto ciò che digitate ai server di Touchpal per l'elaborazione.
- Codice chiuso. Non c'è modo di verificare cosa faccia in background.
- Include molti temi, colori, GIF e altre distrazioni non legate alla digitazione.
- La velocità di caricamento del dizionario è veloce. Touchpal vince questo punto.

Se non sei d'accordo o vuoi spiegare il tuo punto di vista, partecipa alla [discussione aperta](https://github.com/sspanak/tt9/issues/647) su GitHub. Ricorda solo di essere rispettoso verso gli altri. I messaggi di odio non saranno tollerati.

#### Ho bisogno di usare un layout QWERTY (solo dispositivi touchscreen)
Traditional T9 è una tastiera T9 e, in quanto tale, non fornisce un layout simile al QWERTY.

Se stai ancora imparando a usare T9 e hai bisogno di tornare indietro occasionalmente, oppure trovi più conveniente digitare nuove parole usando QWERTY, scorri verso l'alto il tasto F4 sinistro per passare a una tastiera diversa. Vedi [panoramica dei tasti virtuali](#panoramica-dei-tasti-virtuali) per ulteriori informazioni.

La maggior parte delle altre tastiere permette di tornare a Traditional T9 tenendo premuta la barra spaziatrice o il tasto "cambia lingua". Controlla il rispettivo manuale per ulteriori informazioni.

#### Non riesco a cambiare lingua su un telefono touchscreen
Innanzitutto, assicurati di aver abilitato tutte le lingue desiderate in Impostazioni → Lingue. Poi tieni premuto il [tasto sinistro F4](#tasto-f4-sinistro-il-tasto-in-basso-a-sinistra) per cambiare lingua.