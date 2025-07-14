let livros = [];
let indexAtual = 0;
const gostos = []; // Simula base de dados local

async function pesquisarLivros() {
  const termo = document.getElementById("pesquisa").value;
  if (!termo) return;

  const resposta = await fetch(`https://www.googleapis.com/books/v1/volumes?q=${encodeURIComponent(termo)}`);
  const dados = await resposta.json();

  livros = dados.items || [];
  indexAtual = 0;
  mostrarLivro();
}

function mostrarLivro() {
  if (!livros.length || !livros[indexAtual]) {
    document.getElementById("titulo").innerText = "Sem resultados";
    document.getElementById("descricao").innerText = "";
    document.getElementById("capa").src = "";
    document.getElementById("link").href = "#";
    return;
  }

  const livro = livros[indexAtual].volumeInfo;

  document.getElementById("titulo").innerText = livro.title || "Sem título";
  document.getElementById("descricao").innerText = livro.description || "Sem descrição disponível.";
  document.getElementById("capa").src = livro.imageLinks?.thumbnail || "";
  document.getElementById("link").href = livro.infoLink || "#";
}

function passarLivro() {
  indexAtual = (indexAtual + 1) % livros.length;
  mostrarLivro();
}

function gostarLivro() {
  const livro = livros[indexAtual];
  if (!livro) return;

  // Simular POST
  gostos.push(livro);
  alert(`Adicionado "${livro.volumeInfo.title}" à lista de gostos!`);

  passarLivro();
}

// Simular PUT (editar o título do primeiro gosto)
function editarPrimeiroGosto(novoTitulo) {
  if (gostos.length > 0) {
    gostos[0].volumeInfo.title = novoTitulo;
    console.log("PUT simulado:", gostos[0]);
  }
}

// Simular DELETE (remover o primeiro gosto)
function removerPrimeiroGosto() {
  if (gostos.length > 0) {
    const removido = gostos.shift();
    console.log("DELETE simulado:", removido);
  }
}
