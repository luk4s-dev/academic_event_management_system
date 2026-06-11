## Instruções de Compilação

### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior
- Compilador Java (javac)

### Compilar o Sistema

#### Opção 1: Compilar todos os arquivos (recomendado)
```bash
javac -d bin src/modelo/*.java src/sistema/*.java src/Main.java
```

#### Opção 2: Compilar incrementalmente
```bash
# Compilar as classes de modelo
javac -d bin src/modelo/*.java

# Compilar o sistema
javac -d bin -cp bin src/sistema/*.java

# Compilar a classe principal
javac -d bin -cp bin src/Main.java
```

#### Opção 3: Usar VS Code (recomendado)
- Abra o arquivo `src/Main.java`
- Clique em **Run** acima da função `main()` ou pressione `Ctrl+F5`

### Executar o Sistema

#### Via linha de comando
```bash
java -cp bin Main
```

#### Via VS Code
- Abra o arquivo `src/Main.java`
- Clique em **Run** ou pressione `Ctrl+F5`

### Estrutura de Compilação
- **Código-fonte**: `src/` (contém as classes do modelo e o sistema)
- **Saída compilada**: `bin/` (arquivos .class gerados automaticamente)
- **Bibliotecas externas**: `lib/` (para dependências adicionais, se houver)

### Notas Importantes
- Todos os arquivos .class compilados serão gerados em `bin/`
- O classpath padrão está configurado em `.vscode/settings.json`
- Certifique-se de que o JDK está instalado e configurado no PATH do sistema
