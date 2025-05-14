# 📘 Analisador de Frases - JSF + Java 8

Sistema Web desenvolvido com foco em simplicidade, clareza de arquitetura e boas práticas modernas em Java EE 7, para análise de frases.  
Permite ao usuário digitar uma frase e obter:

- Total de palavras distintas
- Total geral de palavras
- Palavra mais frequente
- Ocorrências de cada palavra, ordenadas

Este projeto é totalmente compatível com **Java 8**, **JSF 2.2**, **CDI 1.2** e **WildFly 10**.

Esta arquitetura deste projeto segue um modelo MVC desacoplado com JSF + CDI, respeitando boas práticas de projetos Java EE baseados em Web.

---
## ✅ Benefícios da Arquitetura

- ✨ Fácil manutenção e extensão
- 🧪 Testabilidade isolada das camadas
- 🔌 Pronto para conectar a banco, REST ou filtros
- 📚 Padronizado e fácil de entender por qualquer dev Java EE

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia     | Versão / Observação  |
|----------------|----------------------|
| Java           | 8 (Temurin/OpenJDK)  |
| JSF            | 2.2                  |
| PrimeFaces     | 6.2                  |
| CDI            | 1.2                  |
| Maven          | 3.x                  |
| Servidor       | WildFly 10.x         |
| HTML/CSS       | XHTML com PrimeFaces |
| Codificação    | UTF-8                |

---

## 📦 Estrutura de Pacotes

```text
src/main/java/br/com/teste/
│
├── controller       -> Backing Beans (JSF + CDI)
├── service          -> Regras de negócio centralizadas
├── model            -> Estrutura de dados (Palavra)
└── util             -> Utilitários para processamento de texto
```

---

## 🔍 Funcionalidade

1. O usuário digita uma frase no campo de texto.
2. O sistema limpa e normaliza a frase (remove pontuação, espaços redundantes).
3. A análise retorna:
   - Mapa de palavras e suas contagens
   - Palavra mais frequente
   - Total de palavras (incluindo repetições)

---

## 💡 Boas Práticas Aplicadas

- Separação clara de camadas (`controller`, `service`, `model`, `util`)
- Escopos CDI adequados (`@RequestScoped`, `@ApplicationScoped`)
- Utilização de `TreeMap` para ordenação alfabética automática
- `TextoUtils` centraliza regras de normalização de texto
- Classe `Palavra` estruturada para possíveis extensões (JPA-ready)
- 100% compatível com Java 8 (sem uso de `.isBlank()`, `var`, `stream().toList()` etc.)

---

## 🚀 Como Rodar o Projeto no Eclipse (Enterprise Java and Web Developers 2025-03)
O Eclipse EE já vem preparado para trabalhar com projetos Java Web e servidores como WildFly. Siga os passos abaixo:

### 1. Importar o projeto Maven

- Abra o Eclipse.
- Vá em File > Import...
- Selecione Maven > Existing Maven Projects
- Clique em Next, e selecione a pasta raiz do projeto (frase-analisador-jsf).
- Conclua com Finish.
- O Eclipse reconhecerá automaticamente a estrutura do pom.xml.

### 2. Adicionar o servidor WildFly

- Vá em Window > Show View > Servers
- Clique com o botão direito no painel de servidores → New > Server
- Escolha WildFly 10.x e clique em Next
- Aponte o caminho para o diretório de instalação do WildFly
- Finalize a configuração
- O arquivo será gerado em: `target/frase-analisador-jsf.war`

### 3. Adicionar o projeto ao servidor

- Clique com o botão direito sobre o servidor WildFly → Add and Remove...
- Selecione o projeto frase-analisador-jsf → clique em Add >
- Finalize com Finish

### 4. Iniciar o servidor

- Clique com o botão direito no WildFly e escolha Start
- O projeto será publicado automaticamente
### 5. Acessar no navegador

Abra:

```bash
http://localhost:8080/frase-analisador-jsf/pages/index.xhtm
```

---



## 🚀 Como Rodar o Projeto (IntelliJ Community + WildFly)

### 1. Clonar ou baixar o repositório
```bash
git clone https://github.com/seuusuario/frase-analisador-jsf.git
cd frase-analisador-jsf
```

### 2. Gerar o `.war` com Maven
```bash
mvn clean install
```

O arquivo será gerado em: `target/frase-analisador-jsf.war`

### 3. Fazer o deploy no WildFly
- Copie o `.war` para a pasta:
  ```
  {WILDFLY_HOME}/standalone/deployments/
  ```
- Inicie o WildFly:
  ```bash
  ./standalone.sh     # Linux/macOS
  standalone.bat      # Windows
  ```

### 4. Acessar no navegador
```
http://localhost:8080/frase-analisador-jsf/pages/index.xhtml
```

---




## 🧪 Teste e Validação

> Este projeto foi construído para ser **simples de testar manualmente**.  
> Basta abrir a aplicação, digitar qualquer frase e observar o resultado em tempo real.

**Exemplo de entrada:**
```
O tempo perguntou ao tempo quanto tempo o tempo tem
```

**Resultado esperado:**
- Palavras distintas: 7
- Palavra mais frequente: tempo (4x)
- Total de palavras: 10

---

## 📌 Observações Técnicas

- O projeto **não depende de banco de dados**
- Integração entre JSF e CDI é feita via `@Named` e `@Inject`
- Utiliza apenas escopos leves (`RequestScoped`, `ApplicationScoped`)
- Pronto para extensões: persistência, REST, segurança, internacionalização

---

## 🤝 Contribuições

Este projeto foi criado como um exercício técnico.  
Fique à vontade para bifurcar, melhorar ou adaptar conforme sua necessidade.

---

## 🧠 Autor

**Paulo Junior**  
Software Developer

---

> “Código limpo é aquele que você tem orgulho de entregar. Mesmo que ninguém veja.”  
> – Um dev sênior feliz 😄
