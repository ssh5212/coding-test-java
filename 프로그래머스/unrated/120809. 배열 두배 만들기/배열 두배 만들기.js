function solution(numbers) {
    var answer = [];
    
    console.log(numbers.length)
    for (var i = 0 ; i < numbers.length; i++) {
        answer[i] = numbers[i] * 2; 
    }
    
    // console.log(answer);
    
    return answer;
}