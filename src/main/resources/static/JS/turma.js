// ================================
// DADOS EM MEMÓRIA (SIMULA BANCO)
// ================================
let alunos = [];

// ================================
// BOTÃO: BUSCAR TURMA
// ================================
function buscarTurma() {
    const codigo = document.querySelector('input[placeholder="Código da turma"]').value;
    const professor = document.querySelector('input[placeholder="Professor responsável"]').value;

    if (!codigo || !professor) {
        alert("Preencha o código da turma e o professor.");
        return;
    }

    alert(`Turma ${codigo} carregada!\nProfessor: ${professor}`);
}

// ================================
// BOTÃO: ADICIONAR ALUNO
// ================================
function adicionarAluno() {
    const inputAluno = document.querySelector('input[placeholder="Nome do aluno"]');
    const nome = inputAluno.value;

    if (!nome) {
        alert("Digite o nome do aluno.");
        return;
    }

    alunos.push({
        nome: nome,
        faltas: 0,
        justificativa: ""
    });

    inputAluno.value = "";
    atualizarTabela();
}

// ================================
// ATUALIZA TABELA DE FREQUÊNCIA
// ================================
function atualizarTabela() {
    const tbody = document.querySelector("tbody");
    tbody.innerHTML = "";

    alunos.forEach((aluno, index) => {
        const tr = document.createElement("tr");

        tr.innerHTML = `
            <td>${aluno.nome}</td>
            <td>${aluno.faltas}</td>
            <td>${aluno.justificativa || "—"}</td>
            <td>
                <button class="btn-mini" onclick="editarAluno(${index})">Editar</button>
            </td>
        `;

        tbody.appendChild(tr);
    });
}

// ================================
// BOTÃO: EDITAR ALUNO
// ================================
function editarAluno(index) {
    let faltas = prompt("Quantidade de faltas:", alunos[index].faltas);
    let justificativa = prompt("Justificativa:", alunos[index].justificativa);

    if (faltas !== null) {
        alunos[index].faltas = parseInt(faltas) || 0;
        alunos[index].justificativa = justificativa;
        atualizarTabela();
    }
}

// ================================
// BOTÃO: SALVAR FREQUÊNCIA
// ================================
function salvarFrequencia() {
    if (alunos.length === 0) {
        alert("Nenhum aluno cadastrado.");
        return;
    }

    console.log("Frequência salva:", alunos);
    alert("Frequência salva com sucesso!");
}

// ================================
// RELATÓRIOS
// ================================
function relatorioSemanal() {
    alert("Relatório semanal gerado!");
}

function relatorioMensal() {
    alert("Relatório mensal gerado!");
}

function exportarPlanilha() {
    alert("Planilha exportada (simulação).");
}

function enviarCoordenacao() {
    alert("Relatório enviado para a coordenação!");
}
