# ms-petpar
## Integrantes
*Sara Valentina Duran Campos*

*Giovanni Giannetti*

*Leonardo de Oliveira Fernandes*
## Dependencias
*Java 18*

*Maven 3.6.3*


### Primeiro Passo: Configurar certificado de segurança jks

Param gerar certificado de segurança jks, entre no terminal, entrar na pasta do projeto e digitar:

```keytool -genkeypair -alias petpar -keyalg RSA -keypass 123456 -keystore petpar.jks -storepass 123456 -validity 3650```

Apos o comando acima, executar o seguinte comando:

```keytool -list -keystore petpar.jks```

e digitar a senha 123456

- Criar uma nova pasta "keystore" em resources

- Mover o arquivo petpar.jks para a nova pasta criada


### Segundo passo: Rodar Docker
 Ter o Docker e a ferramenta de administração de banco da sua escolha
* comando : ```docker compose -f docker-db.yml up ```
* abrir o bash:  ```docker exec -it PetPar bash```
* abrir o mysql: ```mysql -u root -p``` a senha é: root
* criar base: ```CREATE DATABASE PetPar;```
* resetar usuarios: ```update mysql.user set host='%' where user='root';``` 
* limpar privilegios: ```FLUSH PRIVILEGES;```
* executar arquivos ```.sql``` da pasta migration na base de dados criada
