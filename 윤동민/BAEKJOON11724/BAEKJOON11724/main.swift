//
//  main.swift
//  BAEKJOON11724
//
//  Created by 윤동민 on 2020/05/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

var visited: [Bool] = []

func main() {
    guard let input = readLine()?.split(separator: " ").map(String.init) else { return }
    guard let n = Int(input[0]) else { return }
    guard let m = Int(input[1]) else { return }
    visited = Array(repeating: false, count: n+1)
    
    var map: [[Int]] = Array(repeating: Array(repeating: 0, count: n+1), count: n+1)
    for _ in 1...m {
        guard let lineInput = readLine()?.split(separator: " ").map(String.init) else { return }
        guard let pointX = Int(lineInput[0]) else { return }
        guard let pointY = Int(lineInput[1]) else { return }
        map[pointX][pointY] = 1
        map[pointY][pointX] = 1
    }

    var connectedCount: Int = 0
    
    for pointIndex in 1...n {
        if !visited[pointIndex] {
            dfs(map, n, startIndex: pointIndex)
            connectedCount += 1
        }
    }
    print(connectedCount)
}

func dfs(_ map: [[Int]],_ size: Int, startIndex: Int) {
    visited[startIndex] = true
    
    for lastIndex in 1...size {
        if map[startIndex][lastIndex] == 1 && !visited[lastIndex] {
            dfs(map, size, startIndex: lastIndex)
        }
    }
}

main()
