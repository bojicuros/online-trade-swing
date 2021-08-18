# Objektno-orjentisano-programiranje
Семинарски рад из предмета објектно орјентисано програмирање. Текст задатка:
1) База података која се користи у овом семинарском раду је seminarski_ors1
(MySQL база), која служи за организацију и управљање подацима везаним за
трговину преко интернета. Ова база података се састоји од 6 табела: kupac,
trgovac, prodajno_mjesto, narudzba, artikal_narudzbe и proizvod. Важно је
напоменути да табеле kupac и trgovac имају колону korisnicko_ime, чија
вриједност мора бити јединствена у посматраној табели. Такође ове табеле
садрже колону lozinka. Вриједност ове табеле је MD-5 код korisnicno_ime123.
2) Потребно је написати Јава пројекат – апликацију, која има двије врсте корисника
– купци и трговци, и служи за управљање подацима унутар наведене базе
података.
3) Покретањем апликације, потребно је да се прикаже форма за пријаву корисника
у систем. Овом приликом корисник бира да ли се пријављује као купац или као
трговац. Такође, овом приликом је могуће одабрати опцију да се корисник
региструје као нови купац у посматраном систему. Приликом регистрације новог
корисника није потребна верификација истог.
4) Уколико се корисник у систем пријави као купац, приказују му се основне
информације о њему (име, презиме, град, адреса, држава), те број обављених
наруџби користећи овај систем и број и вриједност наруџби чија се испорука
чека. Сматра се да се испорука наруџбе чека уколико вриједност поља
datum_isporuke није попуњен.
5) Сваки купац има могућност да погледа списак своји наруџби. Списак наруџби
садржи информације као што су: датум наруџбе, датум испоруке, вриједност
наруџбе. Одабиром наруџбе, купац има могућност да прикаже детаље о истој
као што су: списак наручених артикала и њихов износ, те продајно мјесто гдје је
обављена трговина.
6) Сваки пријављени купац има могућност да прикаже информације о својим
наруџбама чија се испорука чека. Потребно је приказати информације аналогно
као под 5)
7) Сваки пријављени купац има могућност да откаже наруџбу чија се испорука чека.
8) Сваки купац има могућност да прикаже расположиве производе са њиховом
цијеном, те има могућност да исте наручи. Овом приликом корисник не може
бирати продајно мјесто на које врши наруџбу.
9) Када корисник изврши наруџбу, избор продајног мјеста се врши на сљедећи
начин:
a) Ако постоји продајно мјесто које може испоручити тражену наруџбу у истој
држави из које је купац, наруџба се шаље на сва продајна мјеста.
b) Ако нема продајног мјеста у држави купца, продајно мјесто за посматрану
наруџбу може бити било које од продајних мјеста из система, које
задовољава услов да може испоручити тражену наруџбу. Наруџба се и у
овом случају шаље на сва таква продајна мјеста.
Даље, сваком од трговаца који ради у продајном мјесту, које може бити
потенцијално продајно мјесто једне наруџбе, стиже обавјештење о истој.
Обавјештење је послато кроз a) или b). Први трговац који прихвати наруџбу,
сматра се одговорним лицем за исту. На тај начин je одабрано и продајно мјесто
наруџбе. Након што први трговац прихвати наруџбу, обавјештење осталим
потенцијално одговорним особама (трговцима) се поништава.
10) Када се трговац пријави у систем, приказују му се обавјештења наруџбама
купаца, које још увијек нису прихваћене. Обратити пажњу на дио под 9). Овом
приликом се такође приказују и основне информације о пријављеном трговцу.
11) Трговац који је одговоран за наруџбу, има могућност уноса у систем датум
испоруке посматране наруџбе.
12) Трговац такође има приступ свим наруџбама које је он одобрио, без обзира да
ли су испоручене или се чека на испоруку. Овом приликом трговац може да види
вриједност свих наруџби за које је он одговорно лице.
13) Трговац може да дода ново продајно мјесто у систем.
14) Трговац може да дода новог трговца. Приликом додавања новог трговца
потребно је одмах одабрати продајно мјесто за које је надлежан трговац који се
додаје.
15) Трговац може да дода нови и ажурира већ постојећи производ.
16) Информације о конекцији на базу података (Connection string) чувати на само
једном мјесту у апликацији.
