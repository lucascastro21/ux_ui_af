Conexão com Banco de Dados

O método conectarBD é responsável por criar uma conexão com o banco de dados MySQL utilizando credenciais predefinidas.
Caso ocorra algum erro durante a conexão, uma mensagem será exibida no console.
Verificação de Credenciais

O método verificarUsuario realiza uma consulta SQL para verificar se as credenciais fornecidas (login e senha) existem no banco de dados.
Retorna true se as credenciais forem válidas, e false caso contrário.
Se o login for bem-sucedido, o nome do usuário será recuperado e armazenado na variável nome.
Estrutura do Código
Classe User
Métodos
conectarBD
Este método cria a conexão com o banco de dados.

Entrada: Nenhuma.
Saída: Objeto Connection (ou null em caso de falha).
Exemplo de uso:
java
Copiar código
Connection conn = conectarBD();
verificarUsuario
Verifica as credenciais do usuário no banco de dados.

Entrada:
String login: Login do usuário.
String senha: Senha do usuário.
Saída:
boolean: true se o usuário for autenticado, false caso contrário.
Exemplo de uso:
java
Copiar código
boolean isValid = verificarUsuario("admin", "1234");
Variáveis
String nome: Armazena o nome do usuário autenticado.
boolean result: Indica se o login foi bem-sucedido.
Pré-requisitos
Java JDK 8+
Banco de Dados MySQL
Crie uma base de dados chamada test.
Crie uma tabela chamada usuarios com os seguintes campos:
sql
Copiar código
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    login VARCHAR(50) UNIQUE,
    senha VARCHAR(50)
);
Insira registros de exemplo:
sql
Copiar código
INSERT INTO usuarios (nome, login, senha) VALUES ('João', 'joao123', 'senha123');
INSERT INTO usuarios (nome, login, senha) VALUES ('Maria', 'maria456', 'senha456');
Como Executar
Clone o repositório:

bash
Copiar código
git clone https://github.com/seu-usuario/login-system.git
cd login-system
Compile o código Java:

bash
Copiar código
javac -d bin src/login/User.java
Execute o programa (ou integre em sua aplicação):

bash
Copiar código
java -cp bin login.User
