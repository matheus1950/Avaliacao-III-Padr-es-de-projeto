# Avaliação III – Padrões de Projeto (INF011 – IFBA) - 2025.1
## Leonardo Trindade
## Matheus Hirth
---

## ✅ Questão 1 – Padrão State

### ✔️ Nome do padrão:
**State**

### ✔️ Justificativa:
O padrão **State** foi aplicado para encapsular os comportamentos de um objeto `BoletimProva` de acordo com seu estado interno, eliminando condicionais dispersas e centralizando a lógica de transição em objetos de estado. Essa abordagem garante que cada fase da prova (pré-prova, largada, percurso e chegada) seja validada com regras específicas, tornando o código mais limpo, compreensível e com maior coesão.

### ✔️ Participantes:
| Classe                   | Papel no padrão State     |
|--------------------------|---------------------------|
| `BoletimProva`           | Context                   |
| `StateProva`             | State (interface)         |
| `StatePreProva`          | ConcreteState             |
| `StateProntoPraLargada`  | ConcreteState             |
| `StateEmProva`           | ConcreteState             |
| `StateProvaConcluida`    | ConcreteState             |

---

## ✅ Questão 2 – Padrão Chain of Responsibility

### ✔️ Nome do padrão:
**Chain of Responsibility**

### ✔️ Justificativa:
O padrão **Chain of Responsibility** foi escolhido para estruturar a lógica de apuração da prova em regras encadeadas, cada uma encapsulada em uma classe concreta. Com isso, é possível adicionar, remover ou reordenar as validações de forma flexível, sem impactar a estrutura do `Apurador`. Essa abordagem segue os princípios SOLID (aberto para extensão, fechado para modificação), tornando o código mais adaptável e de fácil manutenção.

### ✔️ Participantes:
| Classe                 | Papel no padrão Chain of Responsibility |
|------------------------|------------------------------------------|
| `Apurador`             | Handler Client                           |
| `RegraApuracao`        | Handler (abstrato)                       |
| `RegraChegada`         | ConcreteHandler                          |
| `RegraTempoMaximo`     | ConcreteHandler                          |
| `RegraOrdemPrismas`    | ConcreteHandler                          |
| `RegraTodosPrismas`    | ConcreteHandler                          |
| `RegraPenalizaAtraso`  | ConcreteHandler                          |
