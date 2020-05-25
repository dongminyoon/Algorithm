//
//  main.swift
//  SwiftAlgorithm
//
//  Created by 윤동민 on 2020/05/07.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

func solution(_ board:[[Int]], _ moves:[Int]) -> Int {
    var changedBoard = board
    var stack: [Int] = []
    var popCount: Int = 0
    
    // moves에서 넣을 때, -1해서 넣기
    for move in moves {
        let picked: (rowIndex: Int, door: Int) = pickDoor(changedBoard, move-1)
        if picked.door != 0 {
            stack.append(picked.door)
            changedBoard[picked.rowIndex][move-1] = 0
        }
        
        if stack.count >= 2 && stack[stack.count-1] == stack[stack.count-2] {
            stack.remove(at: stack.count-1)
            stack.remove(at: stack.count-1)
            popCount += 2
        }
    }
    
    return popCount
}

func pickDoor(_ board: [[Int]], _ col: Int) -> (Int, Int) {
    for indexI in 0..<board.count {
        if board[indexI][col] == 0 { continue }
        else { return (indexI, board[indexI][col]) }
    }
    return (0, 0)
}


print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4]))
