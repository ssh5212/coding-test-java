const fs = require('fs');
const inputData = fs.readFileSync('/dev/stdin').toString().split(' ');
// const inputData = fs.readFileSync('example.txt').toString().split(' ');

// console.log(input);
var N = parseInt(inputData[0]);
var M = parseInt(inputData[1]);

var array = [];
var sel = [];
var v = [];

var answer = '';

for (var i = 0; i < N; i++) {
    array[i] = i + 1;
    v[i] = false;
}

for (var i = 0; i < M; i++) {
    sel[i] = 0;
}

recursive(0);
console.log(answer);

function recursive(count) {
    // answer = '';
    if (count == sel.length) {
        for (var i = 0; i < sel.length; i++) {
            answer += sel[i];
            answer += ' ';
        }
        answer += '\n';
        return;
    }

    for (var i = 0; i < array.length; i++) {
        // if (v[i] == true) continue;
        v[i] = true;
        sel[count] = array[i];
        recursive(count + 1);
        sel[count] = 0;
        v[i] = false;
    }
}