//
//  NNotationGame.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/08/26.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct NNotationGame {
    enum NumberSubstitution: Int {
        case ten = 10
        case eleven = 11
        case twelve = 12
        case thirteen = 13
        case fourteen = 14
        case fifteen = 15
        
        func getDescription() -> String {
            switch self {
            case .ten: return "A"
            case .eleven: return "B"
            case .twelve: return "C"
            case .thirteen: return "D"
            case .fourteen: return "E"
            case .fifteen: return "F"
            }
        }
    }
    
    static func solution(_ n:Int, _ t:Int, _ m:Int, _ p:Int) -> String {
        var sumResult = ""
        var number: Int = 0
        
        var finishCount = t
        var turnCount = 1
        
        while true {
            var tempNumber = number
            var tempArray: [Int] = []
            
            while tempNumber >= n {
                tempArray.append(tempNumber % n)
                tempNumber /= n
            }
            tempArray.append(tempNumber)
                
            for index in (0..<tempArray.count).reversed() {
                var stringNumber: String
                if tempArray[index] >= 10 {
                    guard let numberSubstitution = NumberSubstitution(rawValue: tempArray[index])?.getDescription() else { return "" }
                    stringNumber = numberSubstitution
                } else {
                    stringNumber = "\(tempArray[index])"
                }
                
                if (turnCount % m) == p % m {
                    sumResult += stringNumber
                    finishCount -= 1
                }
                
                if finishCount == 0 { return sumResult }
                
                turnCount += 1
            }
            
            number += 1
        }
    }
}
