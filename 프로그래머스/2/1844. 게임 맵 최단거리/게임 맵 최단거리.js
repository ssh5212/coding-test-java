var answer = -1;

function solution(maps) {    
    // console.log(maps)
    
    bfs(0, 0, maps, answer);
    
    return answer;
}

class Point {
    constructor(r, c, level) {
        this.r = r;
        this.c = c;
        this.level = level;
    }
}

var nr = [-1, 0, 1, 0];
var nc = [0, 1, 0, -1];

function bfs (i, j, maps) {
    var q = [];
    q.push(new Point(i, j, 1));
    maps[i][j] = 0; // 지나간 길은 0으로 변경
    
    while(q.length > 0) {
        var p = q.shift();
        
        if (p.r == maps.length - 1 && p.c == maps[0].length - 1) {
            // console.log("hello")
            // console.log(p.level)
            answer = p.level;
            return;
        }
        
        for (var d = 0; d < nr.length; d++) {
            var dr = p.r + nr[d];
            var dc = p.c + nc[d];
            
            if (dr >= 0 && dr < maps.length && dc >= 0 && dc < maps[0].length
               && maps[dr][dc] == 1) {
                maps[dr][dc] = 0;
                q.push(new Point(dr, dc, p.level + 1));
            }
        }
        
    }
    
    // console.log(`${i} ${j}`)
    
}
