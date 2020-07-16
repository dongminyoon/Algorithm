//
//  Problem1.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/07/16.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct Problem1 {
    
    let keyBoard: [String] = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]

    enum Direction {
        case clockwise
        case counterClockwise
    }

    func solution(s: String) -> Int {
        var currentIndex: Int = 0
        var time: Int = 0
        
        s.forEach { eachChar in
            let each = String(eachChar)
            let destIndex = searchDestIndex(of: each)
            
            let clockCount = searchDirection(direction: .clockwise, from: currentIndex, to: destIndex)
            let counterClockwiseCount = searchDirection(direction: .counterClockwise, from: currentIndex, to: destIndex)
            
            time += min(clockCount, counterClockwiseCount)
            currentIndex = destIndex
        }

        return time
    }

    func searchDestIndex(of char: String) -> Int {
        for index in 0..<keyBoard.count {
            if keyBoard[index] == char { return index }
        }
        return -1
    }

    func searchDirection(direction: Direction, from fromIndex: Int, to toIndex: Int) -> Int {
        var time_term = 0
        var currentIndex = fromIndex
        
        while true {
            if keyBoard[currentIndex] == keyBoard[toIndex] { break }
            
            time_term += 1
            switch direction {
            case .clockwise: currentIndex = (currentIndex+1) % keyBoard.count
            case .counterClockwise:
                if currentIndex-1 < 0 { currentIndex = keyBoard.count-1 }
                else { currentIndex -= 1 }
            }
        }
        return time_term
    }


}
