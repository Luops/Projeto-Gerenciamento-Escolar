select nome, email, role
from coordenador
left join usuario
on coordenador.id_usuario = usuario.id_usuario

/*select * from coordenador*/