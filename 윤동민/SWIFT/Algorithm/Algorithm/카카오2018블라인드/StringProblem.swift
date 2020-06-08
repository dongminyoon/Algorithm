//
//  StringProblem.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct StringProblem {
    static func solution(_ s:String) -> Int {
        var stack: [String] = []
        var tempPattern: String = ""
        
        var compressedByPattern: [String] = [s]
        
        for compressLength in 1...s.count/2 {
            for index in 0..<s.count {
                let stringIndex = s.index(s.startIndex, offsetBy: index)
                tempPattern += String(s[stringIndex])
                if tempPattern.count == compressLength {
                    stack.append(tempPattern)
                    tempPattern = ""
                }
            }
            
            if tempPattern != "" {
                stack.append(tempPattern)
                tempPattern = ""
            }
            
            var compressString = ""
            var index: Int = 0
            var sameCount: Int = 1
            while index < stack.count-1 {
                if stack[index] == stack[index+1] {
                    sameCount += 1
                    if index+1 == stack.count-1 {
                        compressString += "\(sameCount)\(stack[index])"
                        break
                    }
                } else {
                    if sameCount == 1 {
                        compressString += stack[index]
                        if index+1 == stack.count-1 {
                            compressString += stack[index+1]
                            break
                        }
                    }
                    else { compressString += "\(sameCount)\(stack[index])" }
                    sameCount = 1
                }
                index += 1
            }
            compressedByPattern.append(compressString)
            stack = []
        }
        
        
        var countByPattern: [Int] = []
        countByPattern.append(s.count)
        for compressed in compressedByPattern { countByPattern.append(compressed.count) }
        return countByPattern.sorted(by: <)[0]
    }
}
