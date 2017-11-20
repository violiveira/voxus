CREATE DATABASE DashboardTasks;

use DashboardTasks;

CREATE TABLE
    Anexo
    (
        idanexo INT NOT NULL AUTO_INCREMENT,
        nome VARCHAR(50) NOT NULL,
        link VARCHAR(200) NOT NULL,
        taskid INT NOT NULL,
        PRIMARY KEY (idanexo),
        INDEX Anexo_Task_fk (taskid)
    )
    ENGINE=InnoDB DEFAULT CHARSET=latin1;
	
CREATE TABLE
    Task
    (
        idtask INT NOT NULL AUTO_INCREMENT,
        nome VARCHAR(20) NOT NULL,
        descricao VARCHAR(500) NOT NULL,
        prioridade SMALLINT NOT NULL,
        submetido VARCHAR(50) NOT NULL,
        finalizado VARCHAR(50),
        status VARCHAR(15) NOT NULL,
        PRIMARY KEY (idtask)
    )
    ENGINE=InnoDB DEFAULT CHARSET=latin1;
	
	
ALTER TABLE
    Anexo ADD CONSTRAINT Anexo_Task_fk FOREIGN KEY (taskid) REFERENCES Task (idtask)
ON
DELETE
    CASCADE
ON
UPDATE
    CASCADE;


	
	
