SELECT Let.IdLet as "Id leta", let.MestoOd as "Mesto poletanja", let.MestoDo as "Mesto sletanja"
FROM Let
WHERE MestoOd IS NOT NULL
