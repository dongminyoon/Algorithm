//
//  CorrectSquare.swift
//  Algorithm
//
//  Created by USER on 2021/02/12.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct CorrectSquare {
    func solution(_ w:Int, _ h:Int) -> Int64{
        let gcd = calculateGCD(a: w, b: h)
        
        let minWidth = w / gcd
        let minHeight = h / gcd
        
        let answer = Int64(w*h) - Int64(gcd*(minWidth + minHeight - 1))
        
        return answer
    }
    
    func calculateGCD(a: Int, b: Int) -> Int {
        var numA = a > b ? a : b
        var numB = a > b ? b : a
        
        var mod: Int
        while numB != 0 {
            mod = numA % numB
            
            numA = numB
            numB = mod
        }
        
        return numA
    }
}
