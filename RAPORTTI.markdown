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

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK