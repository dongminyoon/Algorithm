//
//  MakeMaxNumber.swift
//  Algorithm
//
//  Created by 윤동민 on 2021/02/03.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct MakeMaxNumber {
    func solution(_ number:String, _ k:Int) -> String {
        var answer: String = ""
        
        let restNumber = number.count - k
        
        var startIndex: Int = 0
        
        for indexI in 0..<restNumber {
            let startStringIndex = number.index(number.startIndex, offsetBy: startIndex)
            var max: Int = Int(String(number[startStringIndex]))!
                              
            for indexJ in startIndex...number.count-(restNumber-indexI) {
                let stringIndex = number.index(number.startIndex, offsetBy: indexJ)
                let castingNumber = Int(String(number[stringIndex]))!
                
                if castingNumber > max {
                    max = castingNumber
                    startIndex = indexJ
                }
            }
            
            startIndex = startIndex + 1
            answer += "\(max)"
        }
        
        return answer
    }
}
