INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
     
INSERT INTO adresa(id, ulica, broj) VALUE(1, 'Zelena', 10);
INSERT INTO adresa(id, ulica, broj) VALUE(2, 'Glavna', 5);
INSERT INTO adresa(id, ulica, broj) VALUE(3, 'Evropa', 25);
              

INSERT INTO trotinet(id, sifra, nivo_baterije, maksimalna_brzina, iznajmljen, adresa_id) 
			VALUE(1, '123', 5, 15, false, 2);
INSERT INTO trotinet(id, sifra, nivo_baterije, maksimalna_brzina, iznajmljen, adresa_id) 
			VALUE(2, '321', 50, 20, true, 2);
INSERT INTO trotinet(id, sifra, nivo_baterije, maksimalna_brzina, iznajmljen, adresa_id) 
			VALUE(3, '147', 60, 35, true, 2);
INSERT INTO trotinet(id, sifra, nivo_baterije, maksimalna_brzina, iznajmljen, adresa_id) 
			VALUE(4, '741', 10, 10, false, 3);
INSERT INTO trotinet(id, sifra, nivo_baterije, maksimalna_brzina, iznajmljen, adresa_id) 
			VALUE(5, '987', 90, 25, false, 1);