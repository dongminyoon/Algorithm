//
//  main.swift
//  BFSPractice
//
//  Created by 윤동민 on 2020/05/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

var dfsVisited: [Bool] = []
var bfsVisited: [Bool] = []
var dfsRoot: [Int] = []
var bfsRoot: [Int] = []

func main() {
    guard let input = readLine()?.split(separator: " ").map(String.init) else { return }
    let n: Int = Int(input[0]) ?? 0
    let m: Int = Int(input[1]) ?? 0
    let startIndex = Int(input[2]) ?? 0
    dfsVisited = Array(repeating: false, count: n+1)
    bfsVisited = Array(repeating: false, count: n+1)
    
    var map: [[Int]] = Array(repeating: Array(repeating: 0, count: n+1), count: n+1)
    
    for _ in 1...m {
        guard let line = readLine()?.split(separator: " ").map(String.init) else { return }
        guard let row = Int(line[0]) else { return }
        guard let col = Int(line[1]) else { return }
        map[row][col] = 1
        map[col][row] = 1
    }
    
    dfs(startIndex, map)
    bfs(startIndex, map)
    for point in dfsRoot {
        print(point, terminator: " ")
    }
    print("")
    for point in bfsRoot {
        print(point, terminator: " ")
    }
    print("")
}

func dfs(_ startIndex: Int, _ map: [[Int]]) {
    dfsRoot.append(startIndex)
    dfsVisited[startIndex] = true
    
    for lastIndex in 1...map.count-1 {
        if map[startIndex][lastIndex] == 1 && !dfsVisited[lastIndex] {
            dfs(lastIndex, map)
        }
    }
}

func bfs(_ startIndex: Int, _ map: [[Int]]) {
    bfsVisited[startIndex] = true
    bfsRoot.append(startIndex)
    var queue: [Int] = [startIndex]
    
    while !queue.isEmpty {
        let tempPoint = queue.removeFirst()
        
        for lastIndex in 1...map.count-1 {
            if map[tempPoint][lastIndex] == 1 && !bfsVisited[lastIndex] {
                queue.append(lastIndex)
                bfsVisited[lastIndex] = true
                bfsRoot.append(lastIndex)
            }
        }
    }
    
}


main()
