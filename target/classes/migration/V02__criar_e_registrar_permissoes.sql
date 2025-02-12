

CREATE TABLE permission (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_permission    (
	id_user BIGINT(20) NOT NULL,
	id_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (id_user, id_permission),
	FOREIGN KEY (id_user) REFERENCES users(id),
	FOREIGN KEY (id_permission) REFERENCES permission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE institution_permission    (
	id_institution BIGINT(20) NOT NULL,
	id_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (id_institution, id_permission),
	FOREIGN KEY (id_institution) REFERENCES institutions(id),
	FOREIGN KEY (id_permission) REFERENCES permission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO users (id, name, email, password, birth_date, cpf , phone_number, gender, active)
	values (1, 'Sara duran', 'saraduran174@gmail.com', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '2000-09-25','12345678910','16997670880', 'FEMININO', 1);
INSERT INTO users (id, name, email, password, birth_date, cpf, phone_number, gender, active)
	values (2, 'Leonardo Fernandes', 'leonardo.fernandes@aluno.ifsp.edu.br', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '2000-08-29','12345678911','16997670880', 'MASCULINO', 1);

INSERT INTO users (id, name, email, password, birth_date, cpf, phone_number, gender, active)
values (3, 'Administrador', 'admin@ifsp.edu.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', '1975-11-16', '12345678912','16997670880', 'MASCULINO', 1);

INSERT INTO institutions (id, name, email, password, cpf_cnpj, phone_number, active)
values (3, 'Administrador', 'admin@ifsp.edu.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', '12345678912','16997670880', 1);

-- user
-- TODO: usuario
INSERT INTO permission (id, description) values (1, 'ROLE_REGISTER_USER');
INSERT INTO permission (id, description) values (2, 'ROLE_REMOVE_USER');
INSERT INTO permission (id, description) values (3, 'ROLE_SEARCH_USER');

-- activity
-- TODO: instituicao
INSERT INTO permission (id, description) values (4, 'ROLE_REGISTER_INSTITUTION');
INSERT INTO permission (id, description) values (5, 'ROLE_REMOVE_INSTITUTION');
INSERT INTO permission (id, description) values (6, 'ROLE_SEARCH_INSTITUTION');

-- admin
INSERT INTO institution_permission (id_institution , id_permission) values (3, 1);
INSERT INTO institution_permission (id_institution, id_permission) values (3, 2);
INSERT INTO institution_permission (id_institution, id_permission) values (3, 3);
INSERT INTO institution_permission (id_institution, id_permission) values (3, 4);
INSERT INTO institution_permission (id_institution, id_permission) values (3, 5);
INSERT INTO institution_permission (id_institution, id_permission) values (3, 6);

INSERT INTO user_permission (id_user, id_permission) values (3, 1);
INSERT INTO user_permission (id_user, id_permission) values (3, 2);
INSERT INTO user_permission (id_user, id_permission) values (3, 3);
INSERT INTO user_permission (id_user, id_permission) values (3, 4);
INSERT INTO user_permission (id_user, id_permission) values (3, 5);
INSERT INTO user_permission (id_user, id_permission) values (3, 6);

---- outros

INSERT INTO user_permission (id_user, id_permission) values (1, 1);
INSERT INTO user_permission (id_user, id_permission) values (1, 3);
INSERT INTO user_permission (id_user, id_permission) values (1, 4);
INSERT INTO user_permission (id_user, id_permission) values (1, 5);
INSERT INTO user_permission (id_user, id_permission) values (1, 6);

INSERT INTO user_permission (id_user, id_permission) values (2, 1);
INSERT INTO user_permission (id_user, id_permission) values (2, 3);
INSERT INTO user_permission (id_user, id_permission) values (2, 4);
INSERT INTO user_permission (id_user, id_permission) values (2, 5);
INSERT INTO user_permission (id_user, id_permission) values (2, 6);
