create table ocorrencia (
	id bigint not null auto_increment primary key,
    descricao text not null,
    data_registro datetime not null,
    entrega_id bigint,
    
    constraint fk_entrega_id foreign key (entrega_id) references entrega(id)
) engine=InnoDB char set=utf8mb4;