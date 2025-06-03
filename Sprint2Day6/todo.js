
const _id = Symbol("id"); 

let todoStore = new WeakMap();

export class Todo {
  constructor(title) {
    const id = Date.now();
    todoStore.set(this, { [_id]: id, title, done: false });
  }

  toggle = () => {
    const data = todoStore.get(this);
    data.done = !data.done;
  };

  get data() {
    return todoStore.get(this);
  }

  toHTML() {
    const { title, done } = this.data;
    return `<li>${done ? "✅" : "⬜"} ${title}</li>`;
  }
}
