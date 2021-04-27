use asrcinema;

INSERT INTO genere (DESCRIZIONE)
VALUES ('Comico');

INSERT INTO genere (DESCRIZIONE)
VALUES ('Azione');

INSERT INTO genere (DESCRIZIONE)
VALUES ('Commedia');

INSERT INTO genere (DESCRIZIONE)
VALUES ('Drammatico');

INSERT INTO genere (DESCRIZIONE)
VALUES ('Thriller');

INSERT INTO genere (DESCRIZIONE)
VALUES ('Catastrofico');

INSERT INTO genere (DESCRIZIONE)
VALUES ('Fantascienza');

INSERT INTO genere (DESCRIZIONE)
VALUES ('Animazione');


INSERT INTO FILM (TITOLO, ID_GENERE, URL_TRAILER,DURATA,TRAMA, URI_LOCANDINA, IS_IN_SLIDER, ANNO, REGISTA, FOTO_SL)
VALUES ('Avengers: Endgame',
7,
'https://www.youtube.com/watch?v=oKStYmMgNRA',
182,
'Dopo lo schiocco di dita di Thanos, infatti, il mondo si è ritrovato improvvisamente decimato: non solo metà della popolazione, a sparire sono stati anche alcuni eroi come Spider-Man, Star-Lord, Scarlet Witch, Groot e molti altri. Come visto nel primo trailer e nello spot andato in onda durante il Super Bowl, i Vendicatori rimasti hanno il compito di rimediare a quanto Thanos ha fatto insieme a nuovi, possibili alleati. Al fianco di Captain America, Vedova Nera, Thor e compagni ritroveremo Occhio di Falco e nuovi supereroi come Captain Marvel. Avengers: Endgame, senza ombra di dubbio tra i film più attesi dell\'anno, riporterà sullo schermo forse per l\'ultima volta anche Iron Man, che al momento desta molta preoccupazione nei suoi fan, ancora depresso e disperso nello spazio in compagnia di Nebula, come il primo trailer sembra aver confermato.',
'img/movie/avengers.jpg',
TRUE,
2019,
'Anthony Russo, Joe Russo',
'img/slider/endgame.jpg');

INSERT INTO FILM (TITOLO, ID_GENERE, URL_TRAILER,DURATA,TRAMA, URI_LOCANDINA, IS_IN_SLIDER, ANNO, REGISTA, FOTO_SL)
VALUES ('Aquaman',
7,
'https://www.youtube.com/watch?v=maLAL8H-GQ8&t',
143,
'Arthur è figlio di Tom, guardiano di un faro, e Atlanna, nientemeno che regina di Atlantide. L\'unione dei due è però clandestina, tanto che per salvare il figlio Atlanna accetterà di farsi giudicare nella città subacquea, che la giustizierà consegnandola al più feroce dei popoli sottomarini. Arthur cresce imparando in segreto da Vulko, consigliere del re e di suo figlio Orm, i segreti di Atlantide, ma da adulto preferisce stare lontano dalla città sommersa e si limita a compiere gesta eroiche in mare, come salvare un sottomarino da un team di pirati. Qui finisce per lasciare morire uno di loro e il figlio giura vendetta, tanto da allearsi con il fratellastro di Arthur, Orm. Nel mentre la figlia di Re Nereus, Mera, cerca di convincere Arthur ad abbracciare il suo retaggio di regale atlantideo per scongiurare una guerra, ma per riuscire in questo piano sarà necessario ritrovare il perduto tridente di Atlan.',
'img/movie/aquaman.jpg',
TRUE,
2018,
'James Wan',
'img/slider/aqua.jpg');

INSERT INTO FILM (TITOLO, ID_GENERE, URL_TRAILER,DURATA,TRAMA, URI_LOCANDINA, IS_IN_SLIDER, ANNO, REGISTA, FOTO_SL)
VALUES ('Creed II',
4,
'https://www.youtube.com/watch?v=ELC9AQRqylU',
129,
'La vita di Adonis Creed è diventata un equilibrio tra gli impegni personali e l\'allenamento per il suo prossimo grande combattimento: la sfida della sua vita. Affrontare un avversario legato al passato della sua famiglia, non fa altro che rendere più intenso il suo imminente incontro sul ring. Rocky Balboa è sempre al suo fianco e, insieme, Rocky e Adonis si preparano ad affrontare un passato condiviso, chiedendosi per cosa valga la pena combattere, per poi scoprire che nulla è più importante della famiglia. Creed II è un ritorno alle origini, alla scoperta di ciò che un tempo ti ha reso un campione, senza dimenticare che, ovunque andrai, non puoi sfuggire al tuo passato.',
'img/movie/creed.jpg',
TRUE,
2018,
'Ryan Coogler',
'img/slider/creed.jpg');

INSERT INTO FILM (TITOLO, ID_GENERE, URL_TRAILER,DURATA,TRAMA, URI_LOCANDINA, IS_IN_SLIDER, ANNO, REGISTA, FOTO_SL)
VALUES ('Captain Marvel',
7,
'https://www.youtube.com/watch?v=RPqT-lFQZHY',
124,
'Dopo aver abbandonato la propria vita sulla Terra, Carol si unisce alla Starforce, il reparto d\'elite intergalattico della civiltà aliena dei Kree, guidato dall\'enigmatico comandante Yon-Rogg (Jude Law), guerriero molto stimato e leader capace di incutere timore, un vero e proprio eroe tra i Kree che diventerà il mentore di Carole. Ma una volta terminato l\'addestramento ed essere divenuta un importante membro della Starforce, si ritrova nuovamente sulla Terra - coinvolta nella guerra tra le due razze aliene dei Kree e degli Skrull - con nuove domande sul proprio passato. La supereroina attira presto l\'attenzione di Nick Fury (Samuel L. Jackson), agente dello dello S.H.I.E.L.D, che si trova in quegli anni post Guerra Fredda in lotta per trovare uno scopo all\'interno dell\'organizzazione spionistica e antiterroristica.',
'img/movie/marvel.jpg',
TRUE,
2019,
'Anna Boden, Ryan Fleck',
'img/slider/marvel.png');

INSERT INTO FILM (TITOLO, ID_GENERE, URL_TRAILER,DURATA,TRAMA, URI_LOCANDINA, IS_IN_SLIDER, ANNO, REGISTA, FOTO_SL)
VALUES ('Shazam!',
7,
'https://www.youtube.com/watch?v=I0iBBzyiRes',
132,
'Thaddeus è un bambino trattato con freddezza dal fratello maggiore e dal padre, finché non si ritrova improvvisamente in una caverna di fronte all\'antico mago Shazam, che lo mette alla prova. Si fa però tentare da sinistre presenze e fallisce il suo test, così continuerà a vivere ossessionato dall\'occasione che ha perduto. Dagli anni 80 si arriva ai giorni nostri, quando Thaddeus finalmente riesce a ottenere terribili poteri, ma il mago a sua volta trova un giovane a cui donare straordinarie capacità. Quando questi dice Shazam acquisisce infatti la saggezza di Salomone, la forza di Hercules, la resistenza di Atlante, il potere di Zeus, il coraggio di Achille e la velocità di Mercurio.',
'img/movie/shazam.jpg',
FALSE,
2019,
'David F. Sandberg',
null);

INSERT INTO FILM (TITOLO, ID_GENERE, URL_TRAILER,DURATA,TRAMA, URI_LOCANDINA, IS_IN_SLIDER, ANNO, REGISTA, FOTO_SL)
VALUES ('Van Gogh - Sulla soglia dell_eternità',
4,
'https://www.youtube.com/watch?v=hJk23YvXWgE',
130,
'È di sole che ha bisogno la salute e l\'arte di Vincent van Gogh, insofferente a Parigi e ai suoi grigi. Confortato dall\'affetto e sostenuto dai fondi del fratello Theo, Vincent si trasferisce ad Arles, nel sud della Francia e a contatto con la forza misteriosa della natura. Ma la permanenza è turbata dalle nevrosi incalzanti e dall\'ostilità dei locali, che biasimano la sua arte e la sua passione febbrile. Bandito dalla casa gialla e ricoverato in un ospedale psichiatrico, lo confortano le lettere di Gauguin e le visite del fratello. A colpi di pennellate corte e nervose, arriverà bruscamente alla fine dei suoi giorni.',
'img/movie/vangogh.jpg',
FALSE,
2018,
'Julian Schnabel',
null);

INSERT INTO FILM (TITOLO, ID_GENERE, URL_TRAILER,DURATA,TRAMA, URI_LOCANDINA, IS_IN_SLIDER, ANNO, REGISTA, FOTO_SL)
VALUES ('The Lego Movie 2: Una nuova avventura',
8,
'https://www.youtube.com/watch?v=dtlI0dn8_ko',
106,
'Brichsburg, la città di Emmet, della sua amata Lucy e dei loro amici, la città dove tutto "È meraviglioso!" viene visitata da una specie aliena, i DUPLO, e da essa rasa al suolo. Da allora il suo nome è Apocalypseburg e la sua apparenza rubata a Mad Max: Fury Road, con Lucy nei panni di una guerriera tosta e dark, che cavalca la versione feroce e metallica di UniKitty, e Emmet nei panni di...se stesso.',
'img/movie/lego.jpg',
FALSE,
2019,
'Mike Mitchell',
null);

INSERT INTO FILM (TITOLO, ID_GENERE, URL_TRAILER,DURATA,TRAMA, URI_LOCANDINA, IS_IN_SLIDER, ANNO, REGISTA, FOTO_SL)
VALUES ('A Star Is Born',
4,
'https://www.youtube.com/embed/jvMaHOOY5VA',
135,
'Ally fa la cameriera di giorno e si esibisce come cantante il venerdì sera, durante l\'appuntamento en travesti del pub locale. È lì che incontra per la prima volta Jackson Maine, star del rock, di passaggio per un rifornimento di gin. E siccome nella vita di Jack un super alcolico tira l\'altro, dalla più giovane età, i due proseguono insieme la serata e Ally si ritrova a prendere a pugni un uomo grande il doppio di lei, reo di essersi comportato da fan molesto. La favola di lei comincia quando lui la invita sul palco, rivelando il suo talento al mondo, poi sarà con le sue mani che scalerà le classifiche, mentre la carriera e la tenuta fisica e psicologica di lui rotolano nella direzione opposta, seguendo una china oramai inarrestabile.',
'img/movie/star.jpg',
FALSE,
2018,
'Bradley Cooper',
null);



