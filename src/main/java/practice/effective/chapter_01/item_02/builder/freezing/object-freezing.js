'use strict';

var obj = {
  name: 'jinuliz',
  age: 40
}

obj = {
  name: 'jilinuz',
  age: 80
}

console.log(obj);


/**
 * 내부 값을 변경할 수는 있지만, 다른 객체로 변경할 수 없다.
 * Object.freeze를 사용하면 내부 값도 변경할 수 없다.
 */
const obj2 = {
  name: 'jinuliz',
  age: 40
}

obj2.name = 'jilinuz';
console.log(obj2);

// strict 모드에서만 사용 가능.
Object.freeze(obj2);

// 에러가 발생한다.
obj2.name = 'jizlinu';
console.log(obj2);