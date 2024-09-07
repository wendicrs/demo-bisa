
CREATE TABLE autor (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(255) NOT NULL,
                       apellido_paterno VARCHAR(255) NOT NULL,
                       apellido_materno VARCHAR(255),
                       fecha_nacimiento DATE,
                       pais_residencia VARCHAR(255),
                       correo VARCHAR(255) NOT NULL UNIQUE
);
CREATE TABLE blog (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      titulo VARCHAR(255) NOT NULL,
                      tema VARCHAR(255),
                      contenido TEXT,
                      periodicidad ENUM('DIARIA', 'SEMANAL', 'MENSUAL'),
                      permite_comentarios BOOLEAN DEFAULT TRUE,
                      autor_id BIGINT,
                      fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      FOREIGN KEY (autor_id) REFERENCES autor(id)
);
CREATE TABLE comentario (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nombre VARCHAR(255) NOT NULL,
                            correo VARCHAR(255) NOT NULL,
                            pais_residencia VARCHAR(255),
                            comentario TEXT,
                            puntuacion INT CHECK (puntuacion BETWEEN 0 AND 10),
                            fecha_publicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            blog_id BIGINT,
                            FOREIGN KEY (blog_id) REFERENCES blog(id),
                            CONSTRAINT fk_blog_comentarios FOREIGN KEY (blog_id)
                                REFERENCES blog(id)
                                ON DELETE CASCADE
);
CREATE TABLE historial_blog (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                blog_id BIGINT,
                                titulo VARCHAR(255),
                                tema VARCHAR(255),
                                contenido TEXT,
                                periodicidad ENUM('DIARIA', 'SEMANAL', 'MENSUAL'),
                                permite_comentarios BOOLEAN,
                                fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                FOREIGN KEY (blog_id) REFERENCES blog(id)
);