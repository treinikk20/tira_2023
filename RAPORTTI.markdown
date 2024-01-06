# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK
Opin miten lisäyslajittelu toimii.
Lisäyslajittelun aikakompleksisuus on O(n^2).
Reversen aikakompleksisuus on O(n).
Jos taulukko on jo valmiiksi nousevassa järjestyksessä, ja se halutaan kääntää laskevaksi, se kannattaa kääntää lajittelun sijaan, sillä reversen aikakompleksisuus on pienempi.
## 02-TASK
![Excelkuva](image.png)
Fill näyttäisi olevan O(N*log(N)), kun taas search pienien lukujen outouksia lukuunottamatta O(N).
Hitaassa tilanteessa joudutaan lajittelemaan, ja lajittelun aikakompleksisuus on luokkaa O(N^2), kun taas kääntäminen O(N). Kannattaa siis aina käyttää reverseä jos taulukko on jo lajiteltuna.
Toteutettuja hakualgoritmeja sanotaan lineaarisiksi, sillä niiden toteuttamisaika kasvaa suoraan verrannollisena alkioiden määrään. Näiden aikakompleksisuus on siis O(n).
## 03-TASK
Opin miten puolitushaku toimii.
![Excelkuva, vasemmalla ascending ja oikealla descending](image-1.png)
Fill O(n*log(N)) ja sort O(N^2) kummassakin tapauksessa, kun taas puolitushaku on aikaluokkaa O(log(N)).
Puolitushausta on toteutettu myös rekursiivinen versio, ilman komparaattoria ja komparaattorin kanssa.
## 04-TASK
ToString aiheutti vaikeuksia, vaikka stack toimikin. Muuten tehtävä oli helppo.
Toteutukset vastaavat aikakompleksisuusvaatimuksia, sillä ainoat for-loopit ovat stackin reallokoinnissa ja ParenthesisCheckerissä.
Jos lainausmerkkejä on tekstissä vain esimerkiksi yksi keskellä merkkijonoa, ei algoritmi periaatteessa toimi, sillä se ei tarkista milloin lainausmerkit suljetaan, jolloin lopputeksti skippaantuisi. Olisin muuten implementoinut tämän stackkia käyttäen, mutta tehtävä ei sitä vaatinut, eikä ParenthesesExceptionissa ollut exceptionia tätä varten.
## 05-TASK
Tein jonotietorakenteen taulukkoa käyttäen. Opin miten jono toimii. Tehtävä oli helppo.
Toteutus noudattaa aikakompleksisuutta.
Linkitetyn listan muistikompleksisuus voi olla pienempi, jos taulukossa on paljon tyhjiä paikkoja. Myöskin linkitettyyn listaan alkioiden aikakompleksisuus on aina O(1), sillä reallokointia ei tarvita.
Taulukolla ei paljoa etuja ole jonorakennetta toteuttaessa, mutta esimerkiksi taulukon koon pysyminen vakiona (jos tiedetään tarkalleen alkioille tarvittavan tilan määrä), voi olla hyvä asia.
## 06-TASK
Quicksort oli helppo tehdä. Koitin tehdä mergesorttia mutta motivaation puutteen takia jätin sen kesken.
![Excelkuva, vasemmalla puolella hidas lajittelu, oikealla nopea](image-2.png)
Kuvasta näkee, että quicksort on järjettömän paljon nopeampi kuin insertion sort. Quicksort ei hidastu per elementti, kun elementtien määrä kasvaa. En nyt voi verrata quicksorttia muihin nopeisiin lajittelumenetelmiin niiden puuttumisen takia.
## 07-TASK
Toteutin getIndex ja indexOf metodit käyttäen solmujen lapsien määrää haussa eli metodilla D. Toteutin toArray metodin stackia käyttäen, eli metodilla B, muut rekursiolla, eli metodilla A. Tämän tein vain kokeilumielessä, eikä stackin käyttäminen vaikuttanut toteutukseen tai sen nopeuteen.
Valinnaisista tehtävistä koitin toteuttaa puusta noden poistamista, mutta toteutus ei oman testauksen mukaan näyttänyt toimivan eikä mielenterveys riitä sen korjaamiseen. En toteuttanut visitoria.
![Excelkuva, vasemmalla simpleContainer, oikealla BST](image-3.png)
Taulukoista huomaa hyvin BSTn nopeuden verrattuna simpleContaineriin, varsinkin ku indeksihaut pohjautuvat tuohon nopeaan metodiin. Lisääminen vaikuttaisi olevan aikalailla O(N) luokkaa, sekä indeksihaku O(N*log(N)) luokkaa. Normaali hakuaikakaan ei hidastu tajuttomasti, kun aineiston määrä kasvaa.
BST:n syvyys, jos se on täydellisesti tasapainotettu, on noin log_2(n), eli kahdella miljoonalla nodella syvyys olisi noin 21. Testasin jokaisella aineistolla syvyyttä, käyttäen hyväksi BSTPerformanceTests testejä, ja syvyydet olivat seuraavat:
13, 22, 29, 30, 40, 38, 51, 53. Syvyydet eivät ole optimaaliset, mutta tämä johtuu siitä että puu ei ole tasapainotettu. Tulokset ovat ovat todella hyviä, sillä kahdella miljoonalla nodella syvyys on siltikin vain 53. 
TIRA codersissa toiminta on hiukan hitaampaa sovelluksen luomien hidastumisten vuoksi, mutta omalla koneella myös kahdella miljoonalla coderilla sovellus toimi, jokseenkin hitaasti. Sadalla tuhannella coderilla sovellus toimi sulavasti.
## 08-TASK
Hashtablen toteuttaminen oli paljon helpompi kuin BSTn, eikä mikään oikein toteuttanut ongelmia.
![Excelkuva](image-4.png)
Taulukoista huomaa kuinka hashtable parantaa nopeutta BST verrattuna jokaisessa luokassa, paitsi kun hashtable viedään arrayksi ja lajitellaan. Hashtablen optimaaliset lisäämis- ja hakuajat ovat luokkaa O(1), ja toteutus näyttäisi seuraavan näitä aikakompleksisuuksia add time/item ja search time/item sarakkeiden mukaan. ToArray-metodi joutuu käymään läpi koko hashtablen, jolloin se myös käy tyhjiä indeksejä läpi. Tästä johtuu hitaampi toiminta verrattuna BSTn toArray metodiin.
Vaikka simple keyed containeriin on nopeampi lisätä elementtejä, huomaa hidastumisen hakuajassa. Koitin testata omalla koneellani lisätä miljoonaa koodaria, ja kahden tunninkaan jälkeen ei tämä ollut onnistunut.
## 09-TASK
Graafin toteutus tietorakenteena tuntui helpolta aluksi, mutta paljon bugifixausta piti tehdä. Opin kuitenkin miten graafi toimii.
![Excelkuva](image-5.png)
En jaksanut odottaa viimeistä aineistoa, sillä tunninkaan jälkeen ei se ollut valmis.
Graafin toteutus on oikeellinen, jonka testitkin varmistavat, mutta aikakompleksisuudet eivät todellakaan ole oikein BFS:ssa tai DFS:ssa. Tämä siksi koska niiden toteutus ei todennäköisesti ole oikeellinen. Aikakompleksisuuden pitäisi olla O(E+V), mutta se on toteutuksesssa paljon suurempi. Myöskin Dijkstran hakualgoritmi on todella hidas suurilla aineistoilla, ja sen hitaus vain kasvaa eksponentiaalisesti, joten toteutus ei todennäköisesti ole oikeellinen. Sen aikakompleksisuus pitäisi olla O((V+E)*log(V)), mutta todellisuudessa se on paljon suurempi. Ehkä hitaus johtuu vain suuresta yhdistyneisyydestä.
Verkot ovat siis todennäköisesti tiheitä, sillä edgejä oli todella paljon.
Matriisi olisi todennäköisesti ollut parempi.
Hashaaminen on aina nopeampaa, kun dataa lisätään muutenkin satunnaisesti.
En koittanut eri Mapin toteutuksia. Käytin HashMappia.
En käyttänyt erilaisia aputietorakenteita. Käytin ArrayListia.