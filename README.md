# voxus
Projeto desenvolvido para o processo seletivo na Voxus.

Este projeto foi desenvolvido pela IDE netbeans, para que possa ser executado localmente, basta ser importado dentro de uma IDE
Netbeans e ser associado a um servidor GlassFish.

Este CRUD depende da base dados DashboardTasks, cujo script de criação se encontra na pasta files deste projeto. Além do script
de criação existe um banco de dados já disponivel e pronto para testes na seguinte localização:

Host: 192.241.150.181:3306
Database: DashboardTasks

User: voxusdb
Password: UYkZdPfk

Para que esta conexão funcione a partir do Netbeans é necessário criar uma Persistence Unit com essas configurações e associa-la
ao arquivo persistence.xml

Devido a integração com o Google SignIn, é necessario configurar o caminho absoluto do arquivo '/home/vinicius/NetBeansProjects/DashboardTasks/files/client_secret_263304735649-d6kse5c68fpkf1q9vcfc1s176miclqvm.apps.googleusercontent.com.json'
dentro da classe mb.MBLogin

Este é um projeto Maven, sendo assim todas as dependencias estão devidamente configuradas no pom.xml

