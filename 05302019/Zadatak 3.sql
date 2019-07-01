SELECT sum (Let.PotrGoriva) as "Ukupno", avg (Let.PotrGoriva) as "Prosek"
FROM Let
WHERE Let.MestoOd = "Istanbul" AND Let.Status = 'Z'

ORDER by  ukupno DESC,  Prosek DESC