
export const log = (...args) => console.log(...args);

export const renderList = (todos = []) => {
  return todos.map(todo => todo.toHTML()).join("");
};

export const mergeObjects = (obj1, obj2 = {}) => {
  return Object.assign({}, obj1, obj2);
};

export const compare = (a, b) => Object.is(a, b);

export const createTodosFromTitles = (...titles) => {
  return titles.map(title => ({ title, done: false }));
};
