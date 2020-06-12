//
//  BAEKJOON2178.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct BAEKJOON2178 {
    static func main() {
        guard let input = readLine()?.split(separator: " ").map(String.init) else { return }
        guard let n = Int(input[0]) else { return }
        guard let m = Int(input[1]) else { return }
        
        var map: [[Int]] = Array(repeating: Array(repeating: 0, count: m+1), count: n+1)
        
        for indexI in 1...n {
            guard let rowMap = readLine() else { return }
            for indexJ in 1...m {
                let stringIndex = rowMap.index(rowMap.startIndex, offsetBy: indexJ-1)
                map[indexI][indexJ] = Int(String(rowMap[stringIndex]))!
            }
        }
        
        bfs(map: map, startIndexI: 1, startIndexJ: 1, sizeWidth: m, sizeHeight: n)
    }

    static func bfs(map: [[Int]], startIndexI: Int, startIndexJ: Int, sizeWidth: Int, sizeHeight: Int) {
        let allDirect = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        var distance: [[Int]] = Array(repeating: Array(repeating: 0, count: sizeWidth+1), count: sizeHeight+1)
        distance[startIndexI][startIndexJ] = 1
        var visited: [[Bool]] = Array(repeating: Array(repeating: false, count: sizeWidth+1), count: sizeHeight+1)
        visited[startIndexI][startIndexJ] = true
        var queueRow: [Int] = [startIndexI]
        var queueCol: [Int] = [startIndexJ]
        
        while !queueRow.isEmpty {
            let tempRow = queueRow.removeFirst()
            let tempCol = queueCol.removeFirst()
            
            for direct in allDirect {
                let nextRow = tempRow + direct[0]
                let nextCol = tempCol + direct[1]
                if nextRow >= 1 && nextCol >= 1 && nextRow <= sizeHeight && nextCol <= sizeWidth && map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol] {
                    queueRow.append(nextRow)
                    queueCol.append(nextCol)
                    visited[nextRow][nextCol] = true
                    distance[nextRow][nextCol] = distance[tempRow][tempCol] + 1
                }
            }
        }
        
        print(distance[sizeHeight][sizeWidth])
    }
}
