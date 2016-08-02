
_Mitä algoritmeja ja tietorakenteita toteutat työssäsi_
Työssä toteutan pääasiassa A*-algoritmin ja (todennäköisesti) myös Primin algoritmin. Tarvittavia tietorakenteita on ainakin HashMap-tyyppinen hajautettu avain-arvo -rakenne, sekä kekorakenne lyhyimmän reitin löytämiseksi.

_Mitä ongelmaa ratkaiset ja miksi valitsit kyseiset algoritmit/tietorakenteet_
Rarkoitus on toteuttaa "Virkamiehen assari", näppärä pieni apuväline jolle esimerkiksi terveystarkastaja voi antaa syötteenä kaikki päivän(/viikon/vuoden) tarkastettavat ravintolat, ja ohjelma laskee optimaalisen käyntijärjestyksen. (Prim) Ei mene virkamiehen aika ajellessa! A-tähteä käytetään kun halutaan päästä nopeasti johonkin paikkaan (terveystarkastaja on saanut ilmoituksen ruokamyrkytyksestä tms.).

_Mitä syötteitä ohjelma saa ja miten näitä käytetään_
Ohjelma saa syötteenä tiedot käytävistä paikoista, jos haetaan lyhyintä reittiä käydä kaikki kohteet läpi. Ainakin alkuvaiheessa tiedot annetaan koordinaatteina ja muunnetaan taulukoksi. Pelkkiä osoitteitakin voisi tietyin rajoituksin käyttää.

Mikäli halutaan paikasta A paikkaan B, riittää lähtö- ja maalipaikan ilmoittaminen, edellyttäen että käytettävä paikka-aineisto on valmiiksi tallennettuna ohjelman käyttöön.


_Tavoitteena olevat aika- ja tilavaativuudet (m.m. O-analyysit)_
Algoritmien suorituksen suhteen tavoitteena on Primille aikavaativuudeksi O(mlog n)/O(n2) ja tilavaativuudeksi O(n), ja A*-algoritmille sama kuin Dijkstralle, O((m+n) log n).
    
_Lähteet_
Tietorakenteet ja Algoritmit-kurssin luentomateriaali 2016. Jyrki Kivinen.
http://theory.stanford.edu/%7Eamitp/GameProgramming/AStarComparison.html
