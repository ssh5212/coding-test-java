function solution(sizes) {
    var answer = 0;
    
    var w = 0; // 카드 중 긴 부위를 w로 하겠음
    var h = 0;
    
    for (var i = 0; i < sizes.length; i++) {
        var nowW = sizes[i][0];
        var nowH = sizes[i][1];
        
        // console.log(`${nowW} ${nowH}`);
        
        if (nowW > nowH) {
            var temp = nowW;
            nowW = nowH;
            nowH = temp;
        }
        
        w = Math.max(nowW, w);
        h = Math.max(nowH, h);
        
    }
    
    answer = w * h;
    
    return answer;
}