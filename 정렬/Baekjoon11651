const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const n = input.shift();
const arr = [];

for(let i=0;i<n; i++){
    arr.push(input[i].split(' ').map(strNum => parseInt(strNum)));
}

let result = '';

arr.sort((a, b) => {
    if(a[1] !== b[1]) {
        return a[1] - b[1];
    }
    return a[0] - b[0];
})
.forEach(ar => (result += `${ar[0]} ${ar[1]}\n`));

console.log(result);
