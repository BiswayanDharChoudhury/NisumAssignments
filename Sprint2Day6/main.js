
import { Todo } from "./todo.js";
import { log, renderList } from "./utils.js";

const initialTitles = Array.of("Buy groceries", "Read ES6 docs", "Take a walk");
let todos = Array.from(initialTitles, title => new Todo(title));

const todoList = document.getElementById("todo-list");
const input = document.getElementById("todo-input");
const addBtn = document.getElementById("add-btn");

const messages = new Map([
  [true, "✅ Completed"],
  [false, "⬜ Incomplete"]
]);

function* idGenerator() {
  let i = 1;
  while (true) yield i++;
}
const gen = idGenerator();

const updateDOM = () => {
  todoList.innerHTML = renderList(todos);
};

const addTodo = () => {
  const title = input.value.trim();
  if (!title) return;
  const newTodo = new Todo(`${gen.next().value}. ${title}`);
  todos = [...todos, newTodo]; 
  input.value = "";
  updateDOM();
};

addBtn.addEventListener("click", addTodo);

for (const todo of todos) {
  const { title, done } = todo.data;
  log(`Task: ${title} | Status: ${messages.get(done)}`);
}

const saveTodos = () =>
  new Promise(resolve => {
    setTimeout(() => resolve("Todos saved!"), 1000);
  });

saveTodos().then(log);
updateDOM();
