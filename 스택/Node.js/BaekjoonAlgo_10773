const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().trim().split("\n");

const caseCount = Number(input[0]);
const stack = [];

for(let i=1;i<=caseCount;i++){
    const value = Number(input[i]);

    if(value == 0 ){
        stack.pop();
    } else {
        stack.push(value);
    }
}

let result = 0;

for(let i=0;i<stack.length;i++){
    result += stack[i];
}

console.log(result);
