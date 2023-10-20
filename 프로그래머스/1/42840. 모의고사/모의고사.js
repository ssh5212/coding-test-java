// 1, 2, 3, 4, 5
// 2, 1, 2, 3, 2, 4, 2, 5
// 3, 3, 1, 1, 2, 2, 4, 4, 5, 5

function solution(answers) {
    var answer = [];
    
    var h1 = [1,2,3,4,5];
    var h2 = [2,1,2,3,2,4,2,5];
    var h3 = [3,3,1,1,2,2,4,4,5,5];
    
    var hs = [0,0,0];
    
    for (var i = 0; i < answers.length; i++) {
        if (answers[i] == h1[i % h1.length]) hs[0]+= 1;
        if (answers[i] == h2[i % h2.length]) hs[1]+= 1;
        if (answers[i] == h3[i % h3.length]) hs[2]+= 1;
        
    }
    
    var maxCurrent = Math.max(hs[0], hs[1], hs[2], );
    
    for (var i = 0; i < hs.length; i++) {
        if (hs[i] == maxCurrent) {
            answer.push(i+1); // 뒤에 집어 넣기
            // answer.unshift(i+1); // 앞에 집어 넣기
        }
    }
    
    return answer;
}