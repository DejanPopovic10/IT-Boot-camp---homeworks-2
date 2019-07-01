SELECT Let.IdLet, Let.MestoOd, Let.MestoDo, sum (Karta.Cena)
FROM Let, Karta
WHERE Let.Status != 'O' AND let.IdLet=Karta.IdLet AND Karta.Status!= "N"
GROUP by Let.IdLet
