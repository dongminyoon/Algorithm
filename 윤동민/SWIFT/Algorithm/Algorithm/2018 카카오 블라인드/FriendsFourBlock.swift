//
//  FriendsFourBlock.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct FriendsFourBlock {
    static func solution(_ m:Int, _ n:Int, _ board:[String]) -> Int {
        var tempBoard: [[String]] = []
        
        // 스트링으로 나누는 코드
        for indexI in 0..<m {
            tempBoard.append([])
            let rowString = board[indexI]
            for indexJ in 0..<n {
                let stringIndex = rowString.index(rowString.startIndex, offsetBy: indexJ)
                tempBoard[indexI].append(String(rowString[stringIndex]))
            }
        }

        var flag: Bool = false
        var count: Int = 0
        while !flag {
            flag = false
            // 4칸의 영역이 겹치는지 검사
            let checkList = check(m: m, n: n, board: tempBoard)
            
            for indexRow in 0..<m {
                for indexCol in 0..<n {
                    if checkList[indexRow][indexCol] {
                        flag = true
                        count += 1
                    }
                }
            }
            // 4칸의 영역이 삭제되는 부분 공백으로 채우기
            tempBoard = fillBoard(checkList, tempBoard)
        }
        return count
    }

    static func check(m: Int, n: Int, board: [[String]]) -> [[Bool]] {
        var isEliminate: [[Bool]] = Array(repeating: Array(repeating: false, count: n), count: m)
        let direction: [[Int]] = [[0, 1], [1, 0], [1, 1]]
        
        for indexI in 0..<board.count-1 {
            for indexJ in 0..<board[indexI].count-1 {
                if board[indexI][indexJ] == " " { continue }
                var sameCount = 0
                for eachDirection in direction {
                    if board[indexI][indexJ] == board[indexI+eachDirection[0]][indexJ+eachDirection[1]] { sameCount += 1 }
                    else { break }
                }
                
                if sameCount == 3 {
                    isEliminate[indexI][indexJ] = true
                    for eachDirection in direction { isEliminate[indexI+eachDirection[0]][indexJ+eachDirection[1]] = true }
                }
                sameCount = 0
            }
        }
        return isEliminate
    }

    static func fillBoard(_ checkList: [[Bool]], _ board: [[String]]) -> [[String]] {
        var board = board
        for indexI in 0..<checkList.count {
            for indexJ in 0..<checkList[indexI].count {
                if checkList[indexI][indexJ] { board[indexI][indexJ] = " " }
            }
        }
        
        for indexRow in 0..<board.count {
            for indexCol in 0..<board[indexRow].count {
                if checkList[indexRow][indexCol] && indexRow != 0 {
                    for indexK in (0...indexRow-1).reversed() {
                        board[indexK+1][indexCol] = board[indexK][indexCol]
                        board[indexK][indexCol] = " "
                    }
                }
            }
        }
        
        return board
    }

}
