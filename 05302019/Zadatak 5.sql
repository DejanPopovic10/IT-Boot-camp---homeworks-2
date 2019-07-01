SELECT let.MestoDo, min (karta.Cena), max (karta.Cena)
FROM Let, Karta
WHERE Karta.Status !='N' AND Let.Status != 'O'  AND let.Poletanje <20190401 AND let.Poletanje >20190101 AND Let.IdLet=Karta.IdLet
group by let.MestoDo
HAVING sum (Karta.Cena) >= 300   AND count( Karta.IdKar ) >=2