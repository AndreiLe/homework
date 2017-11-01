# Codeborne kodutöö

Koduse ülesande eesmärk on implementeerida klassi otsimise
funktsionaalsus, nagu seda teeb IntelliJ IDEAs Ctrl+N.

Ülesannet võib lahendada vabalt valitud keeles.

Implementeerima peab sellise käsurealt käivitatava programmi:

```
./class-finder <filename> '<pattern>'
```

kus `<filename>` viitab failile milles on reavahetustega eraldatud
klassinimed, näiteks:

```
a.b.FooBarBaz
c.d.FooBar
```

Otsimise muster `<pattern>` peab sisaldama CamelCase'is kirjutatud klassinimede
suuri tähti õiges järjekorras, mille vahel võivad olla ka järgnevad
väikesed tähed otsingutulemuste täpsustuseks, näiteks: `'FB'`, `'FoBa'` ja
`'FBar'` peavad kõik leidma klasse `a.b.FooBarBaz` ja `c.d.FooBar`.

Vales järjekorras tähti kirjutades tulemusi ei leita, näiteks `'BF'`
ei leia `c.d.FooBar`i.

Kui muster koosneb ainult väikestest tähtedest, siis ignoreeritakse tähe
suurust, näiteks `'fbb'` leiab `FooBarBaz`i, aga `'fBb'` ei leia.

Kui muster lõppeb tühikuga `' '`, siis mustri viimane sõna peab olema ka
viimaseks sõnaks leitud klassinimes, näiteks `'FBar '` leiab `FooBar`i,
aga mitte `FooBarBaz`i.

Mustris võivad esineda ka tärnid `'*'`, mis matchivad puuduvaid tähti,
näiteks `'B*rBaz'` leiab `FooBarBaz`i, aga `BrBaz` ei leia.

Otsingu tulemus peab olema sorteeritud tähestikulises järjekorras
klassi nimede järgi (ilma package nimedeta).

Lahenduses ei tohi kasutada:
- Regexp'i.
- Muid teeke peale keele enda ja unit testide teegi.

Unit testid peavad olemas olema. Unit testide kirjutamiseks võib kasutada
väliseid teeke nagu JUnit, RSpec, Jasmine või muud sarnast.

Piisab siin failis kirjeldatud reeglite implementeerimisest.
IntelliJ IDEA's võib otsingu mustri toimimist järgi proovida
kuid sealne otsing on siin kirjeldatust veelgi keerukam.

Kodutööga kaasas on erinevates keeltes primitiivsed näited käsurealt käivitatavatest programmidest.
Neis olevat stiili ei pea järgima, ning neidsamu faile ei pea kasutama.

```
./class-finder-<language> classes.txt 'FooBar'
```
