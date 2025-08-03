
# Análise da Questão 1 — Avaliação III (Padrões de Projeto)

## ✅ Requisito da Questão
O sistema deve implementar a lógica do ciclo de vida do objeto `BoletimProva`, que possui quatro fases:
1. **Pré-Prova**: não pode registrar largada, chegada nem passagens.
2. **Momento da Largada**: pode registrar atraso. Não pode registrar chegada nem passagens.
3. **Pista**: pode registrar atraso, passagens e chegada.
4. **Pós-Prova**: não pode registrar passagem nem chegada, mas ainda pode consultar atraso.

## 🎯 Objetivo da Refatoração
Eliminar `if` encadeados e garantir:
- Encapsulamento da lógica de estados.
- Princípio do **Open/Closed**.
- Facilidade de extensão e manutenção.

---

## 🎯 Padrão Aplicado: **State**
Permite que o objeto `BoletimProva` altere seu comportamento de acordo com o **estado interno atual**. A lógica de decisão sobre o que pode ser feito é transferida para as classes que representam os estados.

---

## 🏗️ Estrutura Adotada

### Interface Base
```java
public interface EstadoBoletim {
    void apresentarParaLargada();
    void registrarLargada();
    void registrarPassagem(int prisma, Duration tempo);
    void registrarChegada(Duration tempo);
    void registrarAtraso(long minutoPartidaEfetivo);
}
```

### Classe Contexto
```java
public class BoletimProva {
    private EstadoBoletim estado;
    // métodos delegam para estado:
    public void apresentarParaLargada() {
        estado.apresentarParaLargada();
    }
    // ...
}
```

### Estados Concretos
```java
public class PreProva implements EstadoBoletim {
    public void apresentarParaLargada() {
        // muda para MomentoDaLargada
    }
    public void registrarLargada() {
        // lança exceção
    }
    public void registrarPassagem(...) { /* bloqueado */ }
}
```

Outros estados implementam comportamentos válidos conforme a fase:
- `MomentoDaLargada`
- `Pista`
- `PosProva`

---

## 🧪 Verificação dos Requisitos

| Fase             | Largada | Passagem | Chegada | Atraso | Estado Permite? |
|------------------|---------|----------|---------|--------|-----------------|
| Pré-Prova        | ❌      | ❌       | ❌      | ❌     | ✔               |
| Momento Largada  | ❌      | ❌       | ❌      | ✔      | ✔               |
| Pista            | ❌      | ✔        | ✔      | ✔     | ✔               |
| Pós-Prova        | ❌      | ❌       | ❌      | ✔      | ✔               |

✔ Todos os comportamentos esperados estão encapsulados em classes distintas.

---

## 🧠 Justificativa
- O padrão **State** permite isolar comportamentos de cada fase.
- Reduz a complexidade condicional na classe `BoletimProva`.
- Possibilita adicionar novos estados ou transições sem alterar o código existente (extensibilidade).

---

## 🆔 Identificação das Classes e Papéis

| Classe                  | Papel no padrão State       |
|-------------------------|-----------------------------|
| `EstadoBoletim`         | Interface de Estado         |
| `BoletimProva`          | Contexto                    |
| `PreProva`, `Pista`, `PosProva`, `MomentoDaLargada` | Estados Concretos |

---

## ✅ Conclusão
A refatoração resolve corretamente o problema apresentado na Questão 1, atendendo todos os requisitos funcionais e aplicando o padrão de projeto de forma adequada. A transição entre estados é encapsulada e controlada, mantendo a integridade das regras de negócio para cada fase do boletim.
