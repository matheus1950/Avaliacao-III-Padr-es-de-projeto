
# Análise da Questão 1 — Avaliação III (Padrões de Projeto)

## 🎯 Objetivo da Refatoração
Eliminar `if` encadeados e garantir:
- Encapsulamento da lógica de estados.
- Princípio do **Open/Closed**.
- Facilidade de extensão e manutenção.

---

## 🎯 Padrão Aplicado: **State**
Permite que o objeto `BoletimProva` altere seu comportamento de acordo com o **estado interno atual**. A lógica de decisão sobre o que pode ser feito é transferida para as classes que representam os estados.

---

## 🆔 Identificação das Classes e Papéis

| Classe                  | Papel no padrão State       |
|-------------------------|-----------------------------|
| `EstadoBoletim`         | Interface de Estado         |
| `BoletimProva`          | Contexto                    |
| `PreProva`, `Pista`, `PosProva`, `MomentoDaLargada` | Estados Concretos |

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

## ✅ Conclusão
A refatoração resolve corretamente o problema apresentado na Questão 1, atendendo todos os requisitos funcionais e aplicando o padrão de projeto de forma adequada. A transição entre estados é encapsulada e controlada, mantendo a integridade das regras de negócio para cada fase do boletim.
