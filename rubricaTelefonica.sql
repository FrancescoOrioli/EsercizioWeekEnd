
CREATE DATABASE IF NOT EXISTS RubricaTelef
	DEFAULT CHARACTER SET latin1 
	DEFAULT COLLATE latin1_general_ci;

USE RubricaTelef;



CREATE TABLE IF NOT EXISTS Smartphone (
    imei VARCHAR(15) NOT NULL PRIMARY KEY,
    marca VARCHAR(15) NOT NULL,
    modello VARCHAR(15) NOT NULL,
    annoProduzione VARCHAR(4),
    colore VARCHAR(12),
    materiale VARCHAR(12),
    sistOp VARCHAR(12)
);


CREATE TABLE IF NOT EXISTS Utente (
    id INT NOT NULL PRIMARY KEY,
    imei VARCHAR(15) NOT NULL,
    nome VARCHAR(15),
    cognome VARCHAR(15),
    email VARCHAR(50),
    numCell VARCHAR(12),
    numTelFisso VARCHAR(12),
    dataNascita DATE,
    FOREIGN KEY (imei)
        REFERENCES Smartphone (imei)
);

  
 

# popolamento 
 # popolamento 
 
INSERT INTO Smartphone (imei,marca,modello,annoProduzione,colore,materiale,sistOp ) VALUES 
('A12ut4','lg', 'g5',2017,'giallo','alluminio','android'),
('B4566','Samsung', 's5',2016,'ROSA','alluminio','android'),
('C6754','lg', 'g4',2016,'rosso','plastica','android'),
('Z5653','apple', 'iphone 6',2015,'nero','alluminio','IOS'),
('C5677','xiaomi', 'm1',2013,'rosso','alluminio','android'),
('B5555','Iphone', 's8',2017,'verde','alluminio','IOS');


INSERT INTO Utente ( id,imei,nome,cognome,email,numCell,numTelFisso,dataNascita) VALUES

(2,'B4566','Marco','Oliva','marco.ol@gmail.com' ,'3396753456','023545678','1997-4-11'),
(3,'C6754','Lino','sasso','sasso.lino@gmail.com' ,'3334787653','0832345678','1982-9-12'),
(4,'Z5653','rosa','maria','maria.rosa@libero.ot' ,'3324567812','02563157','1977-8-6'),
(5,'C5677','Pino','marino','marino.pino@gmail.com' ,'335678964','06789123','1992-1-1'),
(6,'B5555','Luca','Bardo','luca.bard@msn.com' ,'3394584125','04456723','1990-2-2');


#•	Visualizzazione delle informazioni anagrafiche e del modello di telefono posseduto

select U.nome, U.cognome, U.dataNascita, s.marca,s.modello
from Smartphone as s inner join Utente as U on s.imei=U.imei;

#•	Update sia delle informazioni anagrafiche che del telefono (decidete voi a priori quali)
UPDATE Smartphone
SET materiale = "policarb"
WHERE imei="A12ut4";

UPDATE Utente
SET nome = "Giuseppina"
WHERE id=4;

UPDATE Smartphone
SET marca = "apple"
WHERE imei="B5555";

#•	Visualizzazione delle informazioni relative al telefono
select U.nome, U.cognome,  s.marca,s.modello, s.colore, s.materiale, s.sistOp
from Smartphone as s inner join Utente as U on s.imei=U.imei
where U.nome="Pino" Or U.nome="Marco";

UPDATE Smartphone
SET marca = "apple"
WHERE imei="B5555";


# quante persone hanno il cell di marca apple
select Count(s.imei) AS numeroIphone
from Smartphone as s inner join Utente as U on s.imei=U.imei
where marca="apple";
 
 
# stampa le persone che hanno il numero che inizia per 339 
 select u.nome, u.cognome, u.numCell
 from  Utente u
 where numCell LIKE'339%';
 
 #stampa l'email delle persone proprietarie di un lg
 select  u.nome, u.cognome,s.marca, u.email
from Smartphone as s inner join Utente as U on s.imei=U.imei
where marca="lg";

 insert into Smartphone (imei,marca,modello,annoProduzione,colore,materiale,sistOp) VALUES
("oppi7", "xonex", "m7", "1998", "giallo", "acciaio", "android");
select * from Utente