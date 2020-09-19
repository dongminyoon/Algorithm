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
        var resultCount: [Int] = []

        if s.count <= 1 { return s.count }
        
        for length in 1...s.count/2 {
            print(divide(of: s, by: length))
            resultCount.append(divide(of: s, by: length).count)
        }
        
        guard let min = resultCount.min() else { return -1 }
        return min
    }
    
    static func divide(of s: String, by count: Int) -> String {
        if s.count <= 1 { return s }
        
        var pattern = s[s.startIndex..<s.index(s.startIndex, offsetBy: count)]
        var result: String = ""
        var index: Int = count
        var sameCount: Int = 1
        
        while index < s.count {
            let crtIndex = s.index(s.startIndex, offsetBy: index)
            if index+count >= s.count {
                if pattern == s[crtIndex..<s.endIndex] {
                    result += "\(sameCount+1)" + String(pattern)
                } else {
                    if sameCount != 1 {
                        result += "\(sameCount)" + String(pattern) + String(s[crtIndex..<s.endIndex])
                    } else {
                        result += String(pattern) + String(s[crtIndex..<s.endIndex])
                    }
                }
                break
            }
            let lastIndex = s.index(crtIndex, offsetBy: count)
            
            if s[crtIndex..<lastIndex] == pattern {
                sameCount += 1
            } else {
                if sameCount == 1 {
                    result += String(pattern)
                } else {
                    result += "\(sameCount)" + String(pattern)
                }
                pattern = s[crtIndex..<lastIndex]
                sameCount = 1
            }
            
            index += count
        }
        
        
        
        return result
    }
}
